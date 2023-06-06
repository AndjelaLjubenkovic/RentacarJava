package konekcija;
import java.sql.*;

public class DBConnection {
	private static DBConnection instance;
    private Connection connection;
/**
 * privatni konstruktor da bi se samo u klasi mogla instancirati ova klasa
 * 
 */
    private DBConnection() {
        try {
            // Inicijalizacija konekcije s bazom podataka
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentacar", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/**
 * 
 * @return vraca postojecu konekciju ako postoji,ako ne pravi konekciju
 * cilj je imati samo jednu konekciju na bazu podataka i uvek vracati istu
 * ovo je "singlton patern"
 */
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void zatvoriKonekciju() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * ova metoda proverava da li je zatvarena konekcija
     */
    
    public boolean isKonekcijaZatvorena() throws SQLException
    {
    	if (connection != null && !connection.isClosed()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}

