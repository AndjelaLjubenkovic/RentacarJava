package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.RezervacijaController;
import controller.AutoController;
import konekcija.DBConnection;
import model.Rezervacija;
import model.Auto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class RezervacijaControllerTest {
    
	private RezervacijaController rezervacijaController;
	private AutoController autoController = new AutoController();
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
    public void testAzurirajRezervaciju()
    {
    	int rezervacijaId = 35;
    	Rezervacija rezervacija = rezervacijaController.dobaviRezervaciju(rezervacijaId);
    	 Auto prethodniAuto = autoController.dobaviAuto(rezervacija.getAuto_id());
    	 prethodniAuto.setIznajmljen(false);
    	 autoController.azurirajAuto(prethodniAuto);
    	 assertFalse(prethodniAuto.isIznajmljen());
    	rezervacija.setAuto_id(6);
    	rezervacija.setKlijent_id(11);
    	rezervacijaController.azurirajRezervaciju(rezervacija);
    	Rezervacija azuriranaRezervacija = rezervacijaController.dobaviRezervaciju(rezervacijaId);
    	 assertEquals(rezervacija.getAuto_id(),azuriranaRezervacija.getAuto_id());
    	 assertEquals(rezervacija.getKlijent_id(),azuriranaRezervacija.getKlijent_id());
    	 Auto auto = autoController.dobaviAuto(6);
    	 auto.setIznajmljen(true);
    	 autoController.azurirajAuto(auto);
    	 assertTrue(auto.isIznajmljen());
    	
    } 
    /**
     * Metoda koja testira brisanje rezervacije automobila u bazi
     */
     @Test
     public void testObrisiRezervaciju()
     {
   	  int rezervacijaId = 36;
   	  rezervacijaController.obrisiRezervaciju(rezervacijaId);
   	  List<Rezervacija> rezervacije = rezervacijaController.dobaviSveRezervacije();
   	  assertFalse(rezervacije.stream().anyMatch(rezervacija -> rezervacija.getRezervacija_id() == rezervacijaId));
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
