package swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JTextField name;
	private JTextField city;
	private JTextField contact;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		userid = new JTextField();
		userid.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		
		city = new JTextField();
		city.setColumns(10);
		
		contact = new JTextField();
		contact.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserId");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel type = new JLabel("Type");
		type.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Contact");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JRadioButton vendor = new JRadioButton("vendor");
		
		JLabel lblNewLabel_5 = new JLabel("City");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JRadioButton customer = new JRadioButton("customer");
		
		pass = new JPasswordField();
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int id=Integer.parseInt(userid.getText());
				String nme = name.getText();
				int cont = Integer.parseInt(contact.getText());
				String cty=city.getText();
				String typ ="";
	 if(vendor.isSelected()) {
				typ="vendor";
				}
	 else if(customer.isSelected()) {
		 	typ="customer";
	 }
	 else {typ=" ";}
				String passwd = pass.getText();
				try {
					Connection c = null;
					Class.forName("org.postgresql.Driver");
					c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "postgres");
					PreparedStatement stmt = null;
				
					String sql = "insert into login "
							+ " (id, name, contact, city, type,password)" + " values (?,?,?,?,?,?)";
					stmt = c.prepareStatement(sql);
					stmt.setInt(1, id);
					stmt.setString(2, nme);
					stmt.setInt(3, cont);
					stmt.setString(4, cty);
					stmt.setString(5,typ);
					stmt.setString(6,passwd);
					stmt.executeUpdate();
					stmt.close();
					c.close();
					Home1 hom=new Home1();
					hom.setVisible(true);
				
				} catch (Exception ex) {
					ex.printStackTrace();
				
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home1 hom=new Home1();
				hom.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(type)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(vendor)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(customer))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(pass, Alignment.LEADING)
									.addComponent(name, Alignment.LEADING)
									.addComponent(userid, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
									.addComponent(city, Alignment.LEADING)
									.addComponent(contact, Alignment.LEADING))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(169)
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1)))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(type)
						.addComponent(vendor)
						.addComponent(customer))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(contact, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_4))))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_5)
							.addComponent(city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
