package view;

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

public class RegisterPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	UserController userController = new UserController();

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
		lblUsername.setBounds(18, 25, 85, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(18, 88, 61, 16);
		contentPane.add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(103, 16, 318, 35);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(103, 79, 318, 35);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Uloguj se");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginPage().setVisible(true);
			}
		});
		btnLogin.setBounds(304, 237, 117, 29);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Registruj se");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userController.register(usernameField.getText(), passwordField.getText());
				dispose();
				new AutoTable().setVisible(true);
			}
		});
		btnRegister.setBounds(304, 137, 117, 29);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_3 = new JLabel("Vec imas nalog?");
		lblNewLabel_3.setBounds(167, 242, 139, 16);
		contentPane.add(lblNewLabel_3);
	}

}
