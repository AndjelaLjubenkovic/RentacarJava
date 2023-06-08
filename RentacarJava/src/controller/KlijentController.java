package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import konekcija.DBConnection;
import model.Klijent;

public class KlijentController {

	private Connection connection;

	/**
	 * konekcija za mysql bazu u konstruktoru
	 */
	public KlijentController() {
		connection = DBConnection.getInstance().getConnection();
	}

	/**
	 * Sluzi za kreiranje novog klijentai vraca klijent_id
	 * 
	 * @param client
	 */

	public int dodajKlijenta(Klijent klijent) {
		int created_klijent_id = 0;

		try {
			// Priprema SQL upita
			String query = "INSERT INTO Klijent (ime, prezime, broj_telefona, broj_vozacke) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			// Postavljanje parametara upita
			preparedStatement.setString(1, klijent.getIme());
			preparedStatement.setString(2, klijent.getPrezime());
			preparedStatement.setString(3, klijent.getBroj_telefona());
			preparedStatement.setString(4, klijent.getBroj_vozacke());

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
	 * @vraca sve klijente Sluzi za dobijanje svih klijenata
	 */
	public List<Klijent> dobaviSveKlijente() {
		List<Klijent> clients = new ArrayList<>();

		try {
			// Priprema SQL upita
			String query = "SELECT * FROM Klijent";
			Statement statement = connection.createStatement();

			// Izvršavanje upita
			ResultSet resultSet = statement.executeQuery(query);

			// Prolazak kroz rezultate upita
			while (resultSet.next()) {
				Klijent klijent = new Klijent();
				klijent.setKlijent_id(resultSet.getInt("klijent_id"));
				klijent.setIme(resultSet.getString("ime"));
				klijent.setPrezime(resultSet.getString("prezime"));
				klijent.setBroj_telefona(resultSet.getString("broj_telefona"));
				klijent.setBroj_vozacke(resultSet.getString("broj_vozacke"));

				clients.add(klijent);
			}
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
	public Klijent dobaviKlijenta(int id) {
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
				Klijent klijent = new Klijent();
				klijent.setKlijent_id(resultSet.getInt("klijent_id"));
				klijent.setIme(resultSet.getString("ime"));
				klijent.setPrezime(resultSet.getString("prezime"));
				klijent.setBroj_telefona(resultSet.getString("broj_telefona"));
				klijent.setBroj_vozacke(resultSet.getString("broj_vozacke"));

				return klijent;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param updatedClient 
	 * sluzi za azuriranje postojeceg klijenta
	 */
	public void azurirajKlijenta(Klijent klijent) {

		String sql = "UPDATE Klijent SET ime=?, prezime=?, broj_telefona=?, broj_vozacke=? WHERE klijent_id=?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, klijent.getIme());
			statement.setString(2, klijent.getPrezime());
			statement.setString(3, klijent.getBroj_telefona());
			statement.setString(4, klijent.getBroj_vozacke());
			statement.setInt(5, klijent.getKlijent_id());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param clientId sluzi za brisanje klijenta
	 */
	public void obrisiKlijenta(int id) {

		String sql = "DELETE FROM Klijent WHERE klijent_id=?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
