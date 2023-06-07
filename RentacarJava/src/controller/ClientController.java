package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import konekcija.DBConnection;
import model.Klijent;

public class ClientController {
	
	private Connection connection;

	/**
	 * konekcija za mysql bazu u konstruktoru
	 */
    public ClientController() {
    	connection = DBConnection.getInstance().getConnection();
    }
    
    /**
     * Sluzi za kreiranje novog klijenta
     * @param client
     */
    
    public int createClient(Klijent client) {
        int created_klijent_id = 0;

        try {
            // Priprema SQL upita
            String query = "INSERT INTO Klijent (ime, prezime, broj_telefona, broj_vozacke) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Postavljanje parametara upita
            preparedStatement.setString(1, client.getIme());
            preparedStatement.setString(2, client.getPrezime());
            preparedStatement.setString(3, client.getBroj_telefona());
            preparedStatement.setString(4, client.getBroj_vozacke());

            // Izvršavanje upita
            preparedStatement.executeUpdate();

            // Dobijanje generisanog klijent_id
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                created_klijent_id = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return created_klijent_id;
    }


    /**
     * 
     * @vraca sve klijente
     * Sluzi za dobijanje svih klijenata
     */
    public List<Klijent> getAllClients() {
        List<Klijent> clients = new ArrayList<>();

        try {
            // Priprema SQL upita
            String query = "SELECT * FROM Klijent";
            Statement statement = connection.createStatement();

            // Izvršavanje upita
            ResultSet resultSet = statement.executeQuery(query);

            // Prolazak kroz rezultate upita
            while (resultSet.next()) {
            	Klijent client = new Klijent();
                client.setKlijent_id(resultSet.getInt("klijent_id"));
                client.setIme(resultSet.getString("ime"));
                client.setPrezime(resultSet.getString("prezime"));
                client.setBroj_telefona(resultSet.getString("broj_telefona"));
                client.setBroj_vozacke(resultSet.getString("broj_vozacke"));

                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

        return clients;

    }

    /**
     * 
     * @param id
     * @vraca jednog klijenta
     */
    public Klijent getClientById(int id) {
        try {
            // Priprema SQL upita
            String query = "SELECT * FROM Klijent WHERE klijent_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Postavljanje parametara upita
            preparedStatement.setInt(1, id);

            // Izvršavanje upita
            ResultSet resultSet = preparedStatement.executeQuery();

            // Provjera rezultata upita
            if (resultSet.next()) {
            	Klijent client = new Klijent();
                client.setKlijent_id(resultSet.getInt("klijent_id"));
                client.setIme(resultSet.getString("ime"));
                client.setPrezime(resultSet.getString("prezime"));
                client.setBroj_telefona(resultSet.getString("broj_telefona"));
                client.setBroj_vozacke(resultSet.getString("broj_vozacke"));

                return client;         
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return null;
    }
    
    /**
     * 
     * @param updatedClient
     * sluzi za azuriranje postojeceg klijenta
     */
    public void updateClient(Klijent updatedClient) {
        String sql = "UPDATE Klijent SET ime=?, prezime=?, broj_telefona=?, broj_vozacke=? WHERE klijent_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, updatedClient.getIme());
            statement.setString(2, updatedClient.getPrezime());
            statement.setString(3, updatedClient.getBroj_telefona());
            statement.setString(4, updatedClient.getBroj_vozacke());
            statement.setInt(6, updatedClient.getKlijent_id());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}        
    }

    /**
     * 
     * @param clientId
     * sluzi za brisanje klijenta
     */
    public void deleteClient(int clientId) {
        String sql = "DELETE FROM Klijent WHERE klijent_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, clientId);
            statement.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
   
}
