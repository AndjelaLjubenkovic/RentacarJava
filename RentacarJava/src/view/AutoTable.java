package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AutoTable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable autoTable;	

	/**
	 * Create the frame.
	 */
	public AutoTable() {
		setTitle("Automobili");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		
		JButton btnIznajmi = new JButton("Iznajmi");
		btnIznajmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RentPage().setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnIznajmi)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnIznajmi)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		autoTable = new JTable();
		scrollPane.setViewportView(autoTable);
		contentPane.setLayout(gl_contentPane);
		
		AutoTableModel atm = new AutoTableModel();
		atm.osveziPodatke();
		autoTable.setModel(atm);
		
	}
}
