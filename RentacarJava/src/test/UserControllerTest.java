package test;

import controller.UserController;
import konekcija.DBConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    private UserController userController;
    private Connection connection;

    @BeforeEach
    public void setUp() {
        userController = new UserController();
        connection = DBConnection.getInstance().getConnection();
    }

    /**
     * Metoda koja testira registraciju novog korisnika
     */
    @Test
    public void testRegister() {
        String username = "testuser";
        String password = "testpassword";

        userController.register(username, password);

        // Provera da li je korisnik uspešno dodat u bazu
        try {
            String query = "SELECT * FROM User WHERE username = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            var resultSet = preparedStatement.executeQuery();
            assertTrue(resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda koja testira proces logovanja korisnika
     */
    @Test
    public void testLogin() {
        String username = "testuser";
        String password = "testpassword";

        userController.login(username, password);

        // Provera da li je korisnik uspešno ulogovan
        // Ovde možete dodati dodatne asertacije ili provere da biste proverili logiku prijavljivanja korisnika
    }

}

