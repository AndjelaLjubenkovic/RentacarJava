package test;

import controller.ClientController;
import konekcija.DBConnection;
import model.Klijent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClientControllerTest {

    private ClientController clientController;
    @BeforeEach
    public void setUp() {
        clientController = new ClientController();
        DBConnection.getInstance().getConnection();
    }

    /**
     * Metoda koja proverava da li je klijent uspešno dodat u bazu
     */
    @Test
    public int testCreateClient() {
        Klijent klijent = new Klijent();
        klijent.setIme("Marko");
        klijent.setPrezime("Markovic");
        klijent.setBroj_telefona("123456789");
        klijent.setBroj_vozacke("ABC123");

        clientController.createClient(klijent);

        List<Klijent> klijenti = clientController.getAllClients();
        assertTrue(klijenti.contains(klijent));
        
        return klijent.getKlijent_id();
    }

    /**
     * Metoda koja testira dobavljanje svih klijenata iz baze
     */
    @Test
    public void testGetAllClients() {

        List<Klijent> klijenti = clientController.getAllClients();
        assertNotNull(klijenti);
        assertFalse(klijenti.isEmpty());
    }

    /**
     * Metoda koja testira dobavljanje klijenta po ID-u
     */
    @Test
    public void testGetClientById() {
        // Pretpostavimo da postoji klijent sa ID-jem 1 u bazi podataka
        int klijentId = 1;

        Klijent klijent = clientController.getClientById(klijentId);
        assertNotNull(klijent);
        assertEquals(klijentId, klijent.getKlijent_id());
    }

    /**
     * Metoda koja testira ažuriranje klijenta u bazi
     */
    @Test
    public void testUpdateClient() {
        // Pretpostavimo da postoji klijent sa ID-jem 1 u bazi podataka
        int klijentId = 1;

        Klijent klijent = clientController.getClientById(klijentId);
        assertNotNull(klijent);

        // Ažuriranje podataka klijenta
        klijent.setIme("Novo ime");
        klijent.setPrezime("Novo prezime");
        klijent.setBroj_telefona("987654321");
        klijent.setBroj_vozacke("XYZ789");

        clientController.updateClient(klijent);

        Klijent azuriraniKlijent = clientController.getClientById(klijentId);
        assertEquals(klijent, azuriraniKlijent);
    }

    /**
     * Metoda koja testira brisanje klijenta iz baze
     */
    @Test
    public void testDeleteClient() {
        // Pretpostavimo da postoji klijent sa ID-jem 1 u bazi podataka
        int klijentId = 1;

        clientController.deleteClient(klijentId);

        List<Klijent> klijenti = clientController.getAllClients();
        assertFalse(klijenti.stream().anyMatch(klijent -> klijent.getKlijent_id() == klijentId));
    }

}

