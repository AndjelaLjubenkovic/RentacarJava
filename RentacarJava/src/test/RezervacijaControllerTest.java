package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.RezervacijaController;
import konekcija.DBConnection;
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
        DBConnection.getInstance().getConnection();
    }

    /**
     * Metoda koja proverava da li je rezervacija uspešno dodata u bazu
     */
    @Test
    public void testDodajRezervaciju() {
        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setKlijent_id(2);
        rezervacija.setAuto_id(2);

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
