package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class RegisterPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField emailtField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(163, 15, 85, 16);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(163, 81, 61, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(163, 145, 61, 16);
		contentPane.add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(55, 43, 347, 35);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		emailtField = new JTextField();
		emailtField.setBounds(55, 98, 347, 35);
		contentPane.add(emailtField);
		emailtField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(55, 162, 347, 35);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Uloguj se");
		btnLogin.setBounds(190, 237, 117, 29);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Registruj se");
		btnRegister.setBounds(190, 196, 117, 29);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_3 = new JLabel("Vec imas nalog?");
		lblNewLabel_3.setBounds(55, 250, 139, 16);
		contentPane.add(lblNewLabel_3);
	}

}
