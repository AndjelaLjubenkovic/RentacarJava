package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ClientController;
import model.Klijent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KlijentPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField imeField;
	private JTextField prezimeField;
	private JTextField brTelefonaField;
	private JTextField brVozackeField;
	private JButton btnPotvrdi;

	ClientController clientController = new ClientController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KlijentPage frame = new KlijentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KlijentPage() {
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

		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Klijent k = new Klijent();

				k.setIme(imeField.getText());
				k.setPrezime(prezimeField.getText());
				k.setBroj_telefona(brTelefonaField.getText());
				k.setBroj_vozacke(brVozackeField.getText());

				clientController.createClient(k);
				dispose();
				new AutoTable().setVisible(true);
			}
		});
		btnPotvrdi.setBounds(269, 222, 117, 29);
		contentPane.add(btnPotvrdi);
	}

}
