import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Homepage {

	 JFrame homepageframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage window = new Homepage();
					window.homepageframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Homepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homepageframe = new JFrame();
		homepageframe.getContentPane().setBackground(new Color(255, 235, 235));
		homepageframe.setBackground(new Color(255, 235, 235));
		homepageframe.setBounds(100, 100, 1250, 600);
		homepageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homepageframe.getContentPane().setLayout(null);
		
		JLabel homepagelbl = new JLabel("");
		homepagelbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp window = new SignUp();
				window.signupframe.setVisible(true);
				homepageframe.dispose();
			}
		});
		homepagelbl.setIcon(new ImageIcon(Homepage.class.getResource("/images/Frame 39.png")));
		homepagelbl.setBounds(1, 3, 1234, 557);
		homepageframe.getContentPane().add(homepagelbl);
		
		JLabel signuplabel = new JLabel("");
		signuplabel.setBounds(1043, 11, 122, 50);
		homepageframe.getContentPane().add(signuplabel);
		
		JLabel signinlbl = new JLabel("");
		signinlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp window = new SignUp();
				window.signupframe.setVisible(true);
				homepageframe.dispose();
			}
		});
		signinlbl.setBounds(938, 22, 86, 30);
		homepageframe.getContentPane().add(signinlbl);
	}
}
