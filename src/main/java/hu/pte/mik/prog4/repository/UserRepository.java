package hu.pte.mik.prog4.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import hu.pte.mik.prog4.entity.UserEntity;
public class UserRepository extends Repository {
    public UserEntity findByUsername(String username) {
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement( "SELECT azonosito, felhasznalonev, jelszo FROM felhasznalo WHERE felhasznalonev = ?" )){
            stmt.setString( 1, username );

            ResultSet rs = stmt.executeQuery();

            rs.next();

            UserEntity user = new UserEntity();
            user.setAzonosito( rs.getLong( "azonosito" ) );
            user.setFelhasznalonev( rs.getString( "felhasznalonev" ) );
            user.setJelszo( rs.getString( "jelszo" ) );

            return user;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }
}
