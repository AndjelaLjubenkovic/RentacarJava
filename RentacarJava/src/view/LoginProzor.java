package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;

public class LoginProzor {

	private JFrame frame;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginProzor window = new LoginProzor();
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
	public LoginProzor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 369, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Apple Braille", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Login");
			}
		});
		btnNewButton.setBounds(84, 168, 209, 36);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Apple Braille", Font.PLAIN, 14));
		textField.setBounds(40, 44, 294, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("Create new account");
		btnNewButton_1.setFont(new Font("Apple Braille", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Create");
			}
		});
		btnNewButton_1.setBounds(74, 253, 231, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(40, 112, 294, 36);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setFont(new Font("Apple Braille", Font.PLAIN, 12));
		lblNewLabel.setBounds(50, 19, 111, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Apple Braille", Font.PLAIN, 12));
		lblPassword.setBounds(50, 84, 111, 28);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(40, 222, 294, 7);
		frame.getContentPane().add(btnNewButton_2);
	}
}
