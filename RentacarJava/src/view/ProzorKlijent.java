package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProzorKlijent {

	private JFrame frame;
	private JTextField tbIme;
	private JTextField tbPrezime;
	private JTextField tbBrTelefona;
	private JTextField tbBrDozvole;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProzorKlijent window = new ProzorKlijent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProzorKlijent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 409, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tbIme = new JTextField();
		tbIme.setFont(new Font("Apple Braille", Font.PLAIN, 14));
		tbIme.setBounds(38, 35, 337, 26);
		frame.getContentPane().add(tbIme);
		tbIme.setColumns(10);
		
		tbPrezime = new JTextField();
		tbPrezime.setFont(new Font("Apple Braille", Font.PLAIN, 14));
		tbPrezime.setBounds(38, 89, 337, 26);
		frame.getContentPane().add(tbPrezime);
		tbPrezime.setColumns(10);
		
		tbBrTelefona = new JTextField();
		tbBrTelefona.setFont(new Font("Apple Braille", Font.PLAIN, 14));
		tbBrTelefona.setBounds(38, 145, 337, 26);
		frame.getContentPane().add(tbBrTelefona);
		tbBrTelefona.setColumns(10);
		
		tbBrDozvole = new JTextField();
		tbBrDozvole.setFont(new Font("Apple Braille", Font.PLAIN, 14));
		tbBrDozvole.setBounds(38, 197, 337, 26);
		frame.getContentPane().add(tbBrDozvole);
		tbBrDozvole.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ime");
		lblNewLabel.setFont(new Font("Apple Braile", Font.PLAIN, 12));
		lblNewLabel.setBounds(49, 20, 23, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime");
		lblNewLabel_1.setFont(new Font("Apple Braile", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(48, 74, 49, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Broj Telefona");
		lblNewLabel_2.setFont(new Font("Apple Braile", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(48, 130, 82, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Broj Vozacke dozvole");
		lblNewLabel_3.setFont(new Font("Apple Braile", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(48, 180, 144, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnKreiraj = new JButton("Kreiraj");
		btnKreiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Sve ok?");
			}
		});
		btnKreiraj.setBounds(205, 317, 187, 43);
		btnKreiraj.setFont(new Font("Apple Braile", Font.PLAIN, 12));
		frame.getContentPane().add(btnKreiraj);
		
		JButton btnReset = new JButton("Resetuj");
		btnReset.setFont(new Font("Apple Braile", Font.PLAIN, 12));
		btnReset.setBounds(17, 317, 187, 43);
		frame.getContentPane().add(btnReset);
		
	}

}
