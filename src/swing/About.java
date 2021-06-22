package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home1 hom= new Home1();
				hom.setVisible(true);
			}
		});
		
		JTextPane txtpnToProvideYou = new JTextPane();
		txtpnToProvideYou.setBackground(new Color(240, 255, 255));
		txtpnToProvideYou.setText("To provide you ease for organizing events and helping you out to explore without moving places  planning and executing any event just at home through our website application.\r\n\tWe provide you premium taste of service for any memorable event or precious celebration the way you desire. \r\n\tWe are basically here to provide an effortless experience of  managing any event any gathering you wish to do. Hiring event professionals carry out of any event, right from selecting the location to the catering. Stage management, floor management, event coordination, fashion and lifestyle events, wedding services and corporate is the broad classification of the types of services event management organizations cater to From extravagant weddings with the choicest of requests to corporate events where even a pen shouldn't be out of place, event management companies in India have one of the toughest jobs in the world when they have to bring their client's vision to life, literally.\r\n");
		txtpnToProvideYou.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addComponent(txtpnToProvideYou, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnToProvideYou, GroupLayout.PREFERRED_SIZE, 288, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
