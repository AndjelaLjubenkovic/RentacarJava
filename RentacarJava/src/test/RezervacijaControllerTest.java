package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.RezervacijaController;
import konekcija.DatabaseConnection;
import model.Rezervacija;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class RezervacijaControllerTest {
    
	private RezervacijaController rezervacijaController;
    @BeforeEach
    public void setUp() {
        rezervacijaController = new RezervacijaController();
        DatabaseConnection.getInstance().getConnection();
    }

    /**
     * Metoda koja proverava da li je rezervacija uspešno dodata u bazu
     */
    @Test
    public void testDodajRezervaciju() {
        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setKlijent_id(1);
        rezervacija.setAuto_id(1);

        rezervacijaController.dodajRezervaciju(rezervacija);

        List<Rezervacija> rezervacije = rezervacijaController.dobaviSveRezervacije();
        assertTrue(rezervacije.contains(rezervacija));
    }

    /**
     * Metoda koja testira dobavljanje svih rezervacija iz baze
     */
    @Test
    public void testDobaviSveRezervacije() {

        List<Rezervacija> rezervacije = rezervacijaController.dobaviSveRezervacije();
        assertNotNull(rezervacije);
        assertFalse(rezervacije.isEmpty());
    }

}
