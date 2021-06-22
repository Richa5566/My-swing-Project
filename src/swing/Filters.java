package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Filters extends JFrame {
	private int sessionid;
	public int getSessionid() {
		return sessionid;
	}

	public void setSessionid(int sessionid) {
		this.sessionid = sessionid;
	}

	private JPanel lab;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filters frame = new Filters();
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
	public Filters() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 552);
		lab = new JPanel();
		lab.setBackground(new Color(255, 240, 245));
		lab.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(lab);
		  JTable t1=new JTable();
	        DefaultTableModel dm=new DefaultTableModel();
	 
		JComboBox type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] {"birthday", "marriage", "official", "public", "smallevents"}));
		type.setFont(new Font("Tahoma", Font.BOLD, 11));
		type.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent arg0) {
				String val = type.getSelectedItem().toString();
				Connection c = null;
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "postgres");
					Statement stmt = null;
					String sql = "select ven_name,location,approxam,details from service WHERE srv_type='" + val + "';";
					stmt = c.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception ex) {
				}
			}
		});
		type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent birthday) {
				
			}
		});
		
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home1 hom = new Home1();
				hom.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		table = new JTable();
		
		JButton req = new JButton("REQUEST");
		req.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reqform req= new Reqform();
				req.setVisible(true);
			}
		});
		GroupLayout gl_lab = new GroupLayout(lab);
		gl_lab.setHorizontalGroup(
			gl_lab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lab.createSequentialGroup()
					.addGroup(gl_lab.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_lab.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_lab.createParallelGroup(Alignment.TRAILING)
								.addComponent(table, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
								.addGroup(gl_lab.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
									.addComponent(type, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_lab.createSequentialGroup()
							.addGap(181)
							.addComponent(req)))
					.addContainerGap())
		);
		gl_lab.setVerticalGroup(
			gl_lab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lab.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_lab.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(req)
					.addGap(22))
		);
		lab.setLayout(gl_lab);
	}
}
