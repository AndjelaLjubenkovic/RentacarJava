package controller;

import java.sql.*;
import model.Auto;
import java.util.ArrayList;
import java.util.List;

import konekcija.DatabaseConnection;

public class AutoController {
    private Connection connection;

    public AutoController() {
        connection = DatabaseConnection.getInstance().getConnection();
    }
/**
 * 
 * @param auto
 * ova metoda dodaje novi auto
 */
    public void dodajAuto(Auto auto) {
        String query = "INSERT INTO auto (marka, model, godiste, is_iznajmljen) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, auto.getMarka());
            statement.setString(2, auto.getModel());
            statement.setInt(3, auto.getGodiste());
            statement.setBoolean(4, auto.isIznajmljen());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/**
 * 
 * @param auto
 * ova metoda azurira novi auto
 */
    public void azurirajAuto(Auto auto) {
        String query = "UPDATE auto SET marka=?, model=?, godiste=?, is_iznajmljen=? WHERE auto_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, auto.getMarka());
            statement.setString(2, auto.getModel());
            statement.setInt(3, auto.getGodiste());
            statement.setBoolean(4, auto.isIznajmljen());
            statement.setInt(5, auto.getAuto_id());

            statement.executeUpdate();
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
        String query = "DELETE FROM auto WHERE auto_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, autoId);

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
        String query = "SELECT * FROM auto";
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auti;
    }
}