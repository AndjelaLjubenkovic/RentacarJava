package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UserController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	UserController userController = new UserController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(161, 18, 130, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(161, 80, 130, 16);
		contentPane.add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(31, 39, 352, 29);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(31, 102, 352, 29);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Uloguj se");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userController.login(usernameField.getText(), passwordField.getText());
				dispose();
				new AutoTable().setVisible(true);
			}
		});
		btnLogin.setBounds(215, 143, 117, 29);
		contentPane.add(btnLogin);
		
		JLabel lblRegister = new JLabel("Nemas nalog?");
		lblRegister.setBounds(106, 218, 97, 16);
		contentPane.add(lblRegister);
		
		JButton btnRegister = new JButton("Registruj se");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterPage().setVisible(true);
			}
		});
		btnRegister.setBounds(215, 213, 117, 29);
		contentPane.add(btnRegister);
	}
}
