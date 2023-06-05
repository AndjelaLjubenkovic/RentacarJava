package controller;

import java.sql.*;
import model.Auto;
import java.util.ArrayList;
import java.util.List;

import konekcija.DBConnection;

public class AutoController {
    private Connection connection;

    public AutoController() {
        connection = DBConnection.getInstance().getConnection();
    }
/**
 * 
 * @param auto
 * ova metoda dodaje novi auto
 */
    public void dodajAuto(Auto auto) {
        String query = "INSERT INTO Auto (marka, model, godiste, is_iznajmljen) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, auto.getMarka());
            statement.setString(2, auto.getModel());
            statement.setInt(3, auto.getGodiste());
            statement.setBoolean(4, auto.isIznajmljen());

            statement.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * @param autoId
     * @return vraca jedan auto po id
     */
    public Auto dobaviAuto(int autoId) {
        String query = "SELECT * FROM Auto WHERE auto_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, autoId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String marka = resultSet.getString("marka");
                String model = resultSet.getString("model");
                int godiste = resultSet.getInt("godiste");
                boolean isIznajmljen = resultSet.getBoolean("is_iznajmljen");

                Auto auto = new Auto();
                auto.setAuto_id(autoId);
                auto.setMarka(marka);
                auto.setModel(model);
                auto.setGodiste(godiste);
                auto.setIznajmljen(isIznajmljen);

                connection.close();
                return auto;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Vraćamo null ako auto nije pronađen
    }
   
/**
 * 
 * @param auto
 * ova metoda azurira novi auto
 */
    public void azurirajAuto(Auto auto) {
        String query = "UPDATE Auto SET marka=?, model=?, godiste=?, is_iznajmljen=? WHERE auto_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, auto.getMarka());
            statement.setString(2, auto.getModel());
            statement.setInt(3, auto.getGodiste());
            statement.setBoolean(4, auto.isIznajmljen());
            statement.setInt(5, auto.getAuto_id());

            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/**
 * 
 * @param autoId
 * ova metoda brise auto
 */
    public void obrisiAuto(int autoId) {
        String query = "DELETE FROM Auto WHERE auto_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, autoId);

            connection.close();

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/**
 * 
 * @return ova metoda vraca sve automobile
 */
    public List<Auto> dobaviSveAute() {
        List<Auto> auti = new ArrayList<>();
        String query = "SELECT * FROM Auto";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int autoId = resultSet.getInt("auto_id");
                String marka = resultSet.getString("marka");
                String model = resultSet.getString("model");
                int godiste = resultSet.getInt("godiste");
                boolean isIznajmljen = resultSet.getBoolean("is_iznajmljen");

                Auto auto = new Auto();
                auto.setAuto_id(autoId);
                auto.setMarka(marka);
                auto.setModel(model);
                auto.setGodiste(godiste);
                auto.setIznajmljen(isIznajmljen);

                auti.add(auto);
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auti;
    }
    
    
   
}