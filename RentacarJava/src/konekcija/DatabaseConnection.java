package konekcija;
import java.sql.*;

public class DatabaseConnection {
	private static DatabaseConnection instance;
    private Connection connection;
/**
 * privatni konstruktor da bi se samo u klasi mogla instancirati ova klasa
 * 
 */
    private DatabaseConnection() {
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
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

