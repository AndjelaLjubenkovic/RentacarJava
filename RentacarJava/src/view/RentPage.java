package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.KlijentController;
import controller.RezervacijaController;
import model.Auto;
import model.Klijent;
import model.Rezervacija;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RentPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField imeField;
	private JTextField prezimeField;
	private JTextField brTelefonaField;
	private JTextField brVozackeField;
	private JButton btnPotvrdi;

	KlijentController klijentController = new KlijentController();
	RezervacijaController rezervacijaController = new RezervacijaController();

	/**
	 * Create the frame.
	 */
	public RentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIme = new JLabel("Ime");
		lblIme.setBounds(34, 64, 61, 16);
		contentPane.add(lblIme);

		imeField = new JTextField();
		imeField.setBounds(131, 59, 255, 26);
		contentPane.add(imeField);
		imeField.setColumns(10);

		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setBounds(34, 107, 61, 16);
		contentPane.add(lblPrezime);

		prezimeField = new JTextField();
		prezimeField.setBounds(131, 102, 255, 26);
		contentPane.add(prezimeField);
		prezimeField.setColumns(10);

		JLabel lblbrTelefona = new JLabel("Broj telefona");
		lblbrTelefona.setBounds(34, 148, 85, 16);
		contentPane.add(lblbrTelefona);

		brTelefonaField = new JTextField();
		brTelefonaField.setBounds(131, 143, 255, 26);
		contentPane.add(brTelefonaField);
		brTelefonaField.setColumns(10);

		JLabel lblBrVozacke = new JLabel("Broj Vozacke");
		lblBrVozacke.setBounds(34, 189, 85, 16);
		contentPane.add(lblBrVozacke);

		brVozackeField = new JTextField();
		brVozackeField.setBounds(131, 184, 255, 26);
		contentPane.add(brVozackeField);
		brVozackeField.setColumns(10);

		JLabel lblAuto = new JLabel("Auto");
		lblAuto.setBounds(34, 20, 61, 16);
		contentPane.add(lblAuto);

		JComboBox<Auto> comboBox = new JComboBox<Auto>();
		comboBox.setBounds(131, 16, 255, 27);
		contentPane.add(comboBox);

		AutoTableModel atm = new AutoTableModel();
		ArrayList<Auto> dostupniAutomobili = atm.getDostupniAutomobili();

		for (Auto auto : dostupniAutomobili) {
			// comboBox.addItem(auto);
			comboBox.addItem(auto);
		}

		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Deo za kreiranje Klijenta
				Klijent k = new Klijent();

				k.setIme(imeField.getText());
				k.setPrezime(prezimeField.getText());
				k.setBroj_telefona(brTelefonaField.getText());
				k.setBroj_vozacke(brVozackeField.getText());

				klijentController.dodajKlijenta(k);
				int created_klijent_id = klijentController.dodajKlijenta(k);
				
				// Deo za kreiranje Auta
				Auto selectedAuto = (Auto) comboBox.getSelectedItem();
				int selected_auto_id = selectedAuto.getAuto_id();

				// Deo za kreiranje Rezervacije				
				if (created_klijent_id != 0) {
					Rezervacija r = new Rezervacija(created_klijent_id, selected_auto_id);
					rezervacijaController.dodajRezervaciju(r);
					dispose();
					new AutoTable().setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Nije kreiran klijent");
				}
			}
		});
		btnPotvrdi.setBounds(269, 222, 117, 29);
		contentPane.add(btnPotvrdi);

	}
}
