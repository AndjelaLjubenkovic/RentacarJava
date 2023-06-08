package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import konekcija.DBConnection;
import model.Auto;
import model.Rezervacija;


public class RezervacijaController {
    private Connection connection;
    private AutoController autoController = new AutoController();

    public RezervacijaController() {
        connection = DBConnection.getInstance().getConnection();
    }
/**
 * 
 * @param rezervacija
 * ova metoda pravi novu rezervaciju
 */
    public void dodajRezervaciju(Rezervacija rezervacija) {

    	try {
    		Auto auto = autoController.dobaviAuto(rezervacija.getAuto_id());
            if (auto == null) {
                System.out.println("Automobil sa datim auto_id ne postoji.");
                return;
            }
            // Izvršavanje INSERT upita za kreiranje nove rezervacije
            PreparedStatement statement = connection.prepareStatement("INSERT INTO rezervacija (rezervacija_id, klijent_id, auto_id) VALUES (?, ?, ?)");
            statement.setInt(1, rezervacija.getRezervacija_id());
            statement.setInt(2, rezervacija.getKlijent_id());
            statement.setInt(3, rezervacija.getAuto_id());
            statement.executeUpdate();

            // Postavite vrednost polja iznajmljen na true
            if (auto != null) {
                auto.setIznajmljen(true);
                autoController.azurirajAuto(auto); // Ažurirajte automobil u bazi podataka
            } 
            
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Obrada greške
        }
    }
    public Rezervacija dobaviRezervaciju(int rezervacija_id) {
        // Pretpostavljamo da postoji konekcija ka bazi podataka
        Rezervacija rezervacija = null;

        try {
            // Izvršavanje SELECT upita za čitanje rezervacije
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rezervacija WHERE rezervacija_id = ?");
            statement.setInt(1, rezervacija_id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Kreiranje objekta Rezervacija na osnovu rezultata upita
                int klijent_id = resultSet.getInt("klijent_id");
                int auto_id = resultSet.getInt("auto_id");
                rezervacija = new Rezervacija(rezervacija_id, klijent_id, auto_id);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Obrada greške
        }

        return rezervacija;
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

    }
    
    /**
     * Ova metoda briše rezervaciju
     */
    public void obrisiRezervaciju(int rezervacija_id) {

    	try {
            // Izvršavanje DELETE upita za brisanje rezervacije
            PreparedStatement statement = connection.prepareStatement("DELETE FROM rezervacija WHERE rezervacija_id = ?");
            statement.setInt(1, rezervacija_id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Obrada greške
        }
    }

    /**
     * Ova metoda ažurira rezervaciju
     */
    public void azurirajRezervaciju(Rezervacija rezervacija) {

    	try {
            // Izvršavanje UPDATE upita za ažuriranje rezervacije
            PreparedStatement statement = connection.prepareStatement("UPDATE rezervacija SET klijent_id = ?, auto_id = ? WHERE rezervacija_id = ?");
            statement.setInt(1, rezervacija.getKlijent_id());
            statement.setInt(2, rezervacija.getAuto_id());
            statement.setInt(3, rezervacija.getRezervacija_id());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Obrada greške
        }
    }
    
}
