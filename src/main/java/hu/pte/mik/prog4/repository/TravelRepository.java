package hu.pte.mik.prog4.repository;
import hu.pte.mik.prog4.entity.TravelEntity;
import hu.pte.mik.prog4.ws.TravelDataResponse;
import hu.pte.mik.prog4.ws.TravelDataService_Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TravelRepository extends Repository {
    public TravelEntity save(TravelEntity travel) {
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO uticel (nev, tipus, leiras, orszag) VALUES (?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, travel.getNev());
            stmt.setString(2, travel.getTipus());
            stmt.setString(3, travel.getLeiras());
            stmt.setString(4, travel.getOrszag());

            stmt.executeUpdate();
            ResultSet generatedKey = stmt.getGeneratedKeys();
            generatedKey.next();

            return this.findTravelById(generatedKey.getLong(1));

        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public TravelEntity update(TravelEntity travel) {
        try (Connection conn = this.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "UPDATE uticel SET nev = ?, tipus = ?, leiras = ?, orszag = ? WHERE uticel_id = ?")) {
            stmt.setString(1, travel.getNev());
            stmt.setString(2, travel.getTipus());
            stmt.setString(3, travel.getLeiras());
            stmt.setString(4, travel.getOrszag());
            stmt.setLong(5, travel.getUticelid());

            stmt.executeUpdate();

            return this.findTravelById(travel.getUticelid());
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public TravelEntity findTravelById(Long id) {
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT uticel_id, nev, tipus, leiras, orszag FROM uticel WHERE uticel_id = ?")) {
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            rs.next();

            return this.createTravelFromResultSet(rs);

        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public List<TravelEntity> listAll() {
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs =
                    stmt.executeQuery("SELECT uticel_id, nev, tipus, leiras, orszag FROM uticel");

            List<TravelEntity> travels = new ArrayList<>();
            while (rs.next()) {
                travels.add(this.createTravelFromResultSet(rs));
            }

            return travels;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public Double getUticel(String travelId) {
        try {

            // Convert the company to the SOAP service format (for calling the web service)
            var wsTravelData = new hu.pte.mik.prog4.ws.TravelDataRequest();
            wsTravelData.setTravelId(travelId);

            // Call the SOAP service to process the payment
            var travelDataService = new TravelDataService_Service();
            var port = travelDataService.getSoapTravelDataServicePort();

            TravelDataResponse response = port.getTravelData(wsTravelData); // error

            return response.getUticel();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new UnsupportedOperationException();
        }
    }

    private TravelEntity mapTravel(ResultSet rs) throws SQLException {
        TravelEntity travel = new TravelEntity();
        travel.setUticelid(rs.getLong("uticel_id"));
        travel.setNev(rs.getString("nev"));
        travel.setTipus(rs.getString("tipus"));
        travel.setLeiras(rs.getString("leiras"));
        travel.setOrszag(rs.getString("orszag"));
        return travel;
    }
    
    private TravelEntity createTravelFromResultSet(ResultSet rs) throws SQLException {
        TravelEntity travel = new TravelEntity();
        travel.setUticelid(rs.getLong("uticel_id"));
        travel.setNev(rs.getString("nev"));
        travel.setTipus(rs.getString("tipus"));
        travel.setLeiras(rs.getString("leiras"));
        travel.setOrszag(rs.getString("orszag"));
        return travel;
    }
}
