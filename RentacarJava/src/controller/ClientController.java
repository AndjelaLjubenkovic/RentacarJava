package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Klijent;

public class ClientController {
	
	private Connection connection;

    public ClientController() {
        // Inicijalizacija konekcije s bazom podataka
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentacar", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createClient(Klijent client) {
        try {
            // Priprema SQL upita
            String query = "INSERT INTO Klijent (ime, prezime, br_telefona, broj_vozacka, user_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Postavljanje parametara upita
            preparedStatement.setString(1, client.getIme());
            preparedStatement.setString(2, client.getPrezime());
            preparedStatement.setString(3, client.getBroj_telefona());
            preparedStatement.setString(4, client.getBroj_vozacke());
            preparedStatement.setInt(5, client.getUser_id());

            // Izvršavanje upita
            preparedStatement.executeUpdate();

            System.out.println("Klijent uspešno kreiran.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
                client.setUser_id(resultSet.getInt("user_id"));

                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

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
                client.setUser_id(resultSet.getInt("user_id"));

                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
