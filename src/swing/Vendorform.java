package swing;

import java.awt.EventQueue;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Vendorform extends JFrame {

	private JPanel contentPane;
	private JTextField servicename;
	private JTextField amount;
	private JTextField details;
	private JTextField location;
	private JTextField uid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendorform frame = new Vendorform();
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
	public Vendorform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Service Category");
		
		JLabel lblServiceName = new JLabel("Service Name");
		
		JLabel lblNewLabel_1 = new JLabel("Amout Estimation");
		
		JLabel lblNewLabel_2 = new JLabel("Details");
		
		JLabel lblLocation = new JLabel("Location");
		
		servicename = new JTextField();
		servicename.setColumns(10);
		
		amount = new JTextField();
		amount.setColumns(10);
		
		details = new JTextField();
		details.setColumns(10);
		
		location = new JTextField();
		location.setColumns(10);
		
		JRadioButton ofc = new JRadioButton("Official Events");
		
		JRadioButton mrge = new JRadioButton("Marriage");
		
		JRadioButton small = new JRadioButton("Small events");
		
		JRadioButton pub = new JRadioButton("Public events");
		
		JRadioButton Bdy = new JRadioButton("Birthday");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int id =Integer.parseInt(uid.getText());
				String servtype ="";
				 if(Bdy.isSelected()) {
							servtype="birthday";
							}
				 else if(mrge.isSelected()) {
					 	servtype="marriage";
				 }
				 else if (small.isSelected()) {
					 	servtype="smallevents";
					
				}else if (pub.isSelected()) {
						servtype="public ";
					
				}else if (ofc.isSelected()) {
						servtype="official";
					
				}
				 else {servtype=" ";}
				String amntest =amount.getText();
				String vdname = servicename.getText();
		 		String locn = location.getText();
		 		String info= details.getText();
		 
				try {
					Connection c = null;
					Class.forName("org.postgresql.Driver");
					c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "postgres");
					PreparedStatement stmt = null;
				
					String sql = "insert into service "
							+ " (ven_id,srv_type,ven_name,approxam,location,details)" + " values (?,?,?,?,?,?)";
					stmt = c.prepareStatement(sql);
					
					stmt.setInt(1,id);
					stmt.setString(2, servtype);
					stmt.setString(3, vdname);
					stmt.setString(4, amntest);
					stmt.setString(5, locn);
					stmt.setString(6,info);
					stmt.executeUpdate();
					stmt.close();
					c.close();
				
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home1 hom= new Home1();
				hom.setVisible(true);
			}
		});
		
		JLabel lblReEnterUr = new JLabel("Re enter ur ID");
		
		uid = new JTextField();
		uid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		uid.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Already");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cust dis = new cust();
				dis.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(239)
							.addComponent(small))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addComponent(lblNewLabel_1)
							.addGap(43)
							.addComponent(amount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addComponent(lblNewLabel_2)
							.addGap(94)
							.addComponent(details, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addComponent(lblLocation)
							.addGap(86)
							.addComponent(location, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(185)
							.addComponent(btnSubmit)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblServiceName)
									.addGap(61)
									.addComponent(servicename, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblReEnterUr))
									.addGap(37)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(uid, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(Bdy)
											.addGap(18)
											.addComponent(mrge))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(ofc)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(pub)))))))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(uid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblReEnterUr))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Bdy)
						.addComponent(mrge)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ofc)
						.addComponent(pub))
					.addGap(3)
					.addComponent(small)
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblServiceName))
						.addComponent(servicename, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(amount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2))
						.addComponent(details, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblLocation))
						.addComponent(location, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(67))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
