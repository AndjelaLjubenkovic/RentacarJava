package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import controller.AutoController;
import konekcija.DBConnection;
import model.Auto;

import java.util.List;

public class AutoControllerTest {

    private AutoController autoController;
    
    @BeforeEach
    public void setUp() {
        autoController = new AutoController();
        DBConnection.getInstance().getConnection();
    }

    /**
     * Metoda koja proverava da li je auto uspesno dodat u bazu
     */
    @Test
    public void testDodajAuto() {
        Auto auto = new Auto();
        auto.setMarka("Volvo");
        auto.setModel("XC90");
        auto.setGodiste(2023);
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
        int autoId = 2;

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

}
