import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LogIn {

	 JFrame loginframe;
	private JTextField emailtextField;
	private JPasswordField passwordField;
	private JLabel signinpanel;
	private JLabel logo;
	private JLabel signinlbl;
	private JLabel emailframe;
	private JLabel passwrodframe;
	private JLabel submitbtton;
	private JLabel signuptitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.loginframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginframe = new JFrame();
		loginframe.getContentPane().setBackground(new Color(173, 228, 219));
		loginframe.setBounds(100, 100, 1250, 600);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.getContentPane().setLayout(null);
		
		signuptitle = new JLabel("");
		signuptitle.setIcon(new ImageIcon(LogIn.class.getResource("/images/Sign Uptittle.png")));
		signuptitle.setBounds(775, 443, 74, 28);
		loginframe.getContentPane().add(signuptitle);
		
		submitbtton = new JLabel("");
		submitbtton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == submitbtton) {
					String Email;
					String password;
					Email = emailtextField.getText();
					password = passwordField.getText();
					if (isValidLogin(Email, password)) {
						JOptionPane.showMessageDialog(null, "Login Successful");

						Pets window = new Pets();
						window.petframe.setVisible(true);
						loginframe.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect username. Please try again.");

					}
				}
			}
		});
		submitbtton.setIcon(new ImageIcon(LogIn.class.getResource("/images/Group 10.png")));
		submitbtton.setBounds(608, 322, 122, 28);
		loginframe.getContentPane().add(submitbtton);
		
		passwrodframe = new JLabel("");
		passwrodframe.setIcon(new ImageIcon(LogIn.class.getResource("/images/Rectangle 11.png")));
		passwrodframe.setBounds(477, 280, 372, 28);
		loginframe.getContentPane().add(passwrodframe);
		
		emailframe = new JLabel("");
		emailframe.setIcon(new ImageIcon(LogIn.class.getResource("/images/Rectangle 11.png")));
		emailframe.setBounds(477, 236, 372, 28);
		loginframe.getContentPane().add(emailframe);
		
		signinlbl = new JLabel("");
		signinlbl.setIcon(new ImageIcon(LogIn.class.getResource("/images/Sign in.png")));
		signinlbl.setBounds(627, 193, 80, 29);
		loginframe.getContentPane().add(signinlbl);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(LogIn.class.getResource("/images/Frame 10 1.png")));
		logo.setBounds(502, 67, 322, 142);
		loginframe.getContentPane().add(logo);
		
		emailtextField = new JTextField();
		emailtextField.setBorder(null);
		emailtextField.setBackground(new Color(236, 233, 233));
		emailtextField.setBounds(489, 243, 337, 14);
		loginframe.getContentPane().add(emailtextField);
		emailtextField.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(236, 233, 233));
		passwordField.setBounds(489, 287, 353, 14);
		loginframe.getContentPane().add(passwordField);
		
		
		JLabel Signuplbl = new JLabel("");
		Signuplbl.setIcon(new ImageIcon(LogIn.class.getResource("/images/Signupbttn.png")));
		Signuplbl.setBounds(745, 443, 123, 32);
		loginframe.getContentPane().add(Signuplbl);
		Signuplbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp window = new SignUp();
				window.signupframe.setVisible(true);
				loginframe.dispose();
			}
		});
		Signuplbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		signinpanel = new JLabel("");
		signinpanel.setIcon(new ImageIcon(LogIn.class.getResource("/images/Rectangle 10.png")));
		signinpanel.setBounds(433, 50, 454, 447);
		loginframe.getContentPane().add(signinpanel);
	}
	private boolean isValidLogin(String Email, String password) {
		try {
			FileReader reader = new FileReader("user.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] parts = line.split(":");
				if (parts[0].equals(Email) && parts[1].equals(password)) {
					bufferedReader.close();
					return true;
				}
			}
			bufferedReader.close();
		} catch (IOException click) {
			click.printStackTrace();
		}
		return false;

	}
}
