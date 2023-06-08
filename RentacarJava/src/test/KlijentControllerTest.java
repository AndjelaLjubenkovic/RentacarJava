package test;

import controller.KlijentController;
import konekcija.DBConnection;
import model.Klijent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KlijentControllerTest {

    private KlijentController clientController;
    @BeforeEach
    public void setUp() {
        clientController = new KlijentController();
        DBConnection.getInstance().getConnection();
    }

    /**
     * Metoda koja proverava da li je klijent uspešno dodat u bazu
     */
    @Test
    public int testDodajKlijenta() {
        Klijent klijent = new Klijent();
        klijent.setIme("Marko");
        klijent.setPrezime("Markovic");
        klijent.setBroj_telefona("123456789");
        klijent.setBroj_vozacke("ABC123");

        clientController.dodajKlijenta(klijent);

        List<Klijent> klijenti = clientController.dobaviSveKlijente();
        assertTrue(klijenti.contains(klijent));
        
        return klijent.getKlijent_id();
    }

    /**
     * Metoda koja testira dobavljanje svih klijenata iz baze
     */
    @Test
    public void testDobaviSveKlijente() {

        List<Klijent> klijenti = clientController.dobaviSveKlijente();
        assertNotNull(klijenti);
        assertFalse(klijenti.isEmpty());
    }

    /**
     * Metoda koja testira dobavljanje klijenta po ID-u
     */
    @Test
    public void testDobaviKlijenta() {
        // Pretpostavimo da postoji klijent sa ID-jem 1 u bazi podataka
        int klijentId = 2;

        Klijent klijent = clientController.dobaviKlijenta(klijentId);
        assertNotNull(klijent);
        assertEquals(klijentId, klijent.getKlijent_id());
    }

    /**
     * Metoda koja testira ažuriranje klijenta u bazi
     */
    @Test
    public void testAzurirajKlijenta() {
        // Pretpostavimo da postoji klijent sa ID-jem 1 u bazi podataka
        int klijentId = 2;

        Klijent klijent = clientController.dobaviKlijenta(klijentId);
        assertNotNull(klijent);

        // Ažuriranje podataka klijenta
        klijent.setIme("Novo ime");
        klijent.setPrezime("Novo prezime");
        klijent.setBroj_telefona("987654321");
        klijent.setBroj_vozacke("XYZ789");

        clientController.azurirajKlijenta(klijent);

        Klijent azuriraniKlijent = clientController.dobaviKlijenta(klijentId);
        assertEquals(klijent.getIme(), azuriraniKlijent.getIme());
        assertEquals(klijent.getPrezime(), azuriraniKlijent.getPrezime());
        assertEquals(klijent.getBroj_telefona(), azuriraniKlijent.getBroj_telefona());
        assertEquals(klijent.getBroj_vozacke(), azuriraniKlijent.getBroj_vozacke());

        //assertEquals(klijent, azuriraniKlijent);
    }

    /**
     * Metoda koja testira brisanje klijenta iz baze
     */
    @Test
    public void testObrisiKlijenta() {
        // Pretpostavimo da postoji klijent sa ID-jem 1 u bazi podataka
        int klijentId = 1;

        clientController.obrisiKlijenta(klijentId);

        List<Klijent> klijenti = clientController.dobaviSveKlijente();
        assertFalse(klijenti.stream().anyMatch(klijent -> klijent.getKlijent_id() == klijentId));
    }

}

