package controller;

import java.sql.*;

import konekcija.DBConnection;




public class UserController {
	
	private Connection connection;
	
	/**
	 * konekcija za mysql bazu u konstruktoru
	 */
	
	public UserController() {
		connection = DBConnection.getInstance().getConnection();
    }
	

	/**
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * slusi za dodavanje novog korisnika u bazu i registraciju korisnika na sistem
	 */
	
	  public void register(String username, String password) {
	        try {
	            // Priprema SQL upita
	            String query = "INSERT INTO User (username, password) VALUES (?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);

	            // Postavljanje parametara upita
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            // Izvršavanje upita
	            preparedStatement.executeUpdate();

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
 * @param username
 * @param password
 * @return boolean
 * login metoda sluzi za logovanje na sistem
 */
	    public boolean login(String username, String password) {
	        try {
	            // Priprema SQL upita
	            String query = "SELECT * FROM User WHERE username = ? AND password = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);

	            // Postavljanje parametara upita
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            // Izvršavanje upita
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
		        	return true;
		        }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	        }
	        /*
	        try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
*/	    
	    
}
