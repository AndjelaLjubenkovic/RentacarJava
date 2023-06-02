package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import konekcija.DatabaseConnection;
import model.Rezervacija;

public class RezervacijaController {
    private Connection connection;

    public RezervacijaController() {
        connection = DatabaseConnection.getInstance().getConnection();
    }
/**
 * 
 * @param rezervacija
 * ova metoda pravi novu rezervaciju
 */
    public void dodajRezervaciju(Rezervacija rezervacija) {
        String query = "INSERT INTO Rezervacija (klijent_id, auto_id) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, rezervacija.getKlijent_id());
            statement.setInt(2, rezervacija.getAuto_id());

            statement.executeUpdate();
            connection.zatvoriKonekciju();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   /**
    * 
    * @return ova metoda vraca sve rezervacje
    */

    public List<Rezervacija> dobaviSveRezervacije() {
        List<Rezervacija> rezervacije = new ArrayList<>();
        String query = "SELECT * FROM Rezervacija";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int rezervacijaId = resultSet.getInt("rezervacija_id");
                int klijentId = resultSet.getInt("klijent_id");
                int autoId = resultSet.getInt("auto_id");
                Rezervacija rezervacija = new Rezervacija();
                rezervacija.setRezervacija_id(rezervacijaId);
                rezervacija.setKlijent_id(klijentId);
                rezervacija.setAuto_id(autoId);
                rezervacije.add(rezervacija);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rezervacije;
        connection.zatvoriKonekciju();
    }
    
}
