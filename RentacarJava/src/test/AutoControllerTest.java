package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import controller.AutoController;
import konekcija.DatabaseConnection;
import model.Auto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AutoControllerTest {

    private AutoController autoController;
    private Connection connection;

    @BeforeEach
    public void setUp() {
        autoController = new AutoController();
        connection = DatabaseConnection.getInstance().getConnection();
    }

    /**
     * Metoda koja proverava da li je auto uspesno dodat u bazu
     */
    @Test
    public void testDodajAuto() {
        Auto auto = new Auto();
        auto.setMarka("BMW");
        auto.setModel("X5");
        auto.setGodiste(2021);
        auto.setIznajmljen(false);

        autoController.dodajAuto(auto);

        List<Auto> auti = autoController.dobaviSveAute();
        assertTrue(auti.contains(auto));
    }

    /**
     * Metoda koja testira azuriranje auta u bazi
     */
    @Test
    public void testAzurirajAuto() {
        // Pretpostavimo da postoji auto sa ID-jem 1 u bazi podataka
        int autoId = 1;

        Auto auto = new Auto();
        auto.setAuto_id(autoId);
        auto.setMarka("Audi");
        auto.setModel("A4");
        auto.setGodiste(2019);
        auto.setIznajmljen(true);

        autoController.azurirajAuto(auto);

        Auto azuriraniAuto = autoController.dobaviAuto(autoId);
        assertEquals(auto, azuriraniAuto);
    }

    /**
     * Metoda koja testira brisanje auta iz baze
     */
    @Test
    public void testObrisiAuto() {
        // Pretpostavimo da postoji auto sa ID-jem 1 u bazi podataka
        int autoId = 1;

        autoController.obrisiAuto(autoId);

        List<Auto> auti = autoController.dobaviSveAute();
        assertFalse(auti.stream().anyMatch(auto -> auto.getAuto_id() == autoId));
    }

    /**
     * Metoda koja cita sve automobile iz baze
     */
    @Test
    public void testDobaviSveAute() {

        List<Auto> auti = autoController.dobaviSveAute();
        assertNotNull(auti);
        assertFalse(auti.isEmpty());
    }

    /**
     * Testiranje zatvaranja konekcije
     * @throws SQLException 
     */
    @Test
    public void testZatvoriKonekciju() throws SQLException {

    	((DatabaseConnection) connection).zatvoriKonekciju();
        assertTrue(((DatabaseConnection) connection).isKonekcijaZatvorena());
    }
}
