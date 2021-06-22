package swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		id = new JTextField();
		id.setColumns(10);

		JLabel lblUserid = new JLabel("UserId");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 15));

		pass = new JPasswordField();

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection c = null;

					int i_d = Integer.parseInt(id.getText());
					String paswd = pass.getText();
					Class.forName("org.postgresql.Driver");
					c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "postgres");
					Statement stmt = null;

					String sql = "SELECT * FROM login WHERE id=" + i_d + " AND password='" + paswd + "';";
					stmt = c.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String type = rs.getString("type");
						String pass = rs.getString("password");
						// HttpSession session = request.getSession(true);
						// session.putValue("user_id", Id);
						// session.putValue("name", name);
						// session.putValue("type", type);
						if ("customer".equals(type)) {
							Filters filt = new Filters();
							filt.setSessionid(id);
							filt.setVisible(true);
						} else {
							Vendorform vend = new Vendorform();
							vend.setVisible(true);
						}

					} else {
						Login log = new Login();
						log.setVisible(true);
					}

				} catch (Exception ex) {

				}
			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home1 hom = new Home1();
				hom.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(78)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblPassword).addComponent(lblUserid)))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(93).addComponent(btnNewButton)))
						.addGap(31)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnBack)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(pass, Alignment.LEADING).addComponent(id, Alignment.LEADING)))
						.addContainerGap(146, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(40)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUserid))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword))
						.addGap(18).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton).addComponent(btnBack))
						.addContainerGap(111, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
