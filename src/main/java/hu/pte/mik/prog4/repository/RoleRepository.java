package hu.pte.mik.prog4.repository;
import hu.pte.mik.prog4.entity.RoleEntity;
import hu.pte.mik.prog4.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class RoleRepository extends Repository {
    public List<RoleEntity> findRolesByUser(UserEntity userEntity) {
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement("" +
                     "SELECT r.id, r.code, r.description " +
                     "FROM role r " +
                     "JOIN user_role ur on r.id = ur.role_id " +
                     "JOIN user u on u.id = ur.user_id WHERE u.id = ?");) {
            stmt.setLong(1, userEntity.getAzonosito());

            ResultSet rs = stmt.executeQuery();
            List<RoleEntity> roles = new ArrayList<>();
            while (rs.next()) {
                RoleEntity role = new RoleEntity();
                role.setAzonosito(rs.getLong("azonosito"));
                role.setKod(rs.getString("kod"));
                role.setLeiras(rs.getString("leiras"));
                roles.add(role);
            }
            return roles;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }
}
