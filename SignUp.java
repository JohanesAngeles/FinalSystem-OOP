import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.*;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;

public class SignUp extends JFrame {

	JFrame signupframe;
	private JTextField fullname;
	private JTextField adresstextfield;
	private JTextField emailtxtfield;
	private JPasswordField passwordsignin;
	private File file;
	private JTextField contacttextfield;
	private JLabel panelsignup;
	private JLabel signinlogo;
	private JLabel signintitle;
	private JLabel nameframe;
	private JLabel adressframe;
	private JLabel contactframe;
	private JLabel emailframe;
	private JLabel passwordframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.signupframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		signupframe = new JFrame();
		signupframe.setBounds(100, 100, 1250, 600);
		signupframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signupframe.getContentPane().setBackground(new Color(173, 228, 219));
		signupframe.getContentPane().setLayout(null);
		file = new File("user.txt");
		
		passwordframe = new JLabel("");
		passwordframe.setIcon(new ImageIcon(SignUp.class.getResource("/images/Rectangle 11.png")));
		passwordframe.setBounds(471, 384, 372, 28);
		signupframe.getContentPane().add(passwordframe);
		
		emailframe = new JLabel("");
		emailframe.setIcon(new ImageIcon(SignUp.class.getResource("/images/Rectangle 11.png")));
		emailframe.setBounds(471, 345, 372, 28);
		signupframe.getContentPane().add(emailframe);
		
		contactframe = new JLabel("");
		contactframe.setIcon(new ImageIcon(SignUp.class.getResource("/images/Rectangle 11.png")));
		contactframe.setBounds(471, 306, 372, 28);
		signupframe.getContentPane().add(contactframe);
		
		adressframe = new JLabel("");
		adressframe.setIcon(new ImageIcon(SignUp.class.getResource("/images/Rectangle 11.png")));
		adressframe.setBounds(471, 267, 372, 28);
		signupframe.getContentPane().add(adressframe);
		
		nameframe = new JLabel("");
		nameframe.setIcon(new ImageIcon(SignUp.class.getResource("/images/Rectangle 11.png")));
		nameframe.setBounds(471, 228, 372, 28);
		signupframe.getContentPane().add(nameframe);

		signintitle = new JLabel("");
		signintitle.setIcon(new ImageIcon(SignUp.class.getResource("/images/Sign up.png")));
		signintitle.setBounds(621, 183, 89, 29);
		signupframe.getContentPane().add(signintitle);

		fullname = new JTextField();
		fullname.setBorder(null);
		fullname.setBackground(new Color(236, 233, 233));
		fullname.setBounds(495, 234, 337, 14);
		signupframe.getContentPane().add(fullname);
		fullname.setColumns(10);
		fullname.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (fullname.getText().equals("Full Name")) {
					fullname.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fullname.getText().equals("")) {
					fullname.setText("Full Name");
				}
			}
		});

		adresstextfield = new JTextField();
		adresstextfield.setBorder(null);
		adresstextfield.setBackground(new Color(236, 233, 233));
		adresstextfield.setBounds(493, 275, 337, 14);
		signupframe.getContentPane().add(adresstextfield);
		adresstextfield.setColumns(10);
		adresstextfield.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (adresstextfield.getText().equals("Adress")) {
					adresstextfield.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (adresstextfield.getText().equals("")) {
					adresstextfield.setText("Adress");
				}
			}
		});

		contacttextfield = new JTextField();
		contacttextfield.setBorder(null);
		contacttextfield.setBackground(new Color(236, 233, 233));
		contacttextfield.setBounds(493, 318, 337, 14);
		signupframe.getContentPane().add(contacttextfield);
		contacttextfield.setColumns(10);
		contacttextfield.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (contacttextfield.getText().equals("Contact Number")) {
					contacttextfield.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (contacttextfield.getText().equals("")) {
					contacttextfield.setText("Contact Number");
				}
			}
		});

		emailtxtfield = new JTextField();
		emailtxtfield.setBorder(null);
		emailtxtfield.setBackground(new Color(236, 233, 233));
		emailtxtfield.setBounds(495, 357, 337, 14);
		signupframe.getContentPane().add(emailtxtfield);
		emailtxtfield.setColumns(10);
		emailtxtfield.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (emailtxtfield.getText().equals("Email")) {
					emailtxtfield.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (emailtxtfield.getText().equals("")) {
					emailtxtfield.setText("Email");
				}
			}
		});


		passwordsignin = new JPasswordField();
		passwordsignin.setBackground(new Color(236, 233, 233));
		passwordsignin.setBorder(null);
		passwordsignin.setBounds(495, 395, 337, 14);
		signupframe.getContentPane().add(passwordsignin);
		passwordsignin.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (passwordsignin.getText().equals("Password")) {
					passwordsignin.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (passwordsignin.getText().equals("")) {
					passwordsignin.setText("Password");
				}
			}
		});


		JLabel submitbttn = new JLabel("");
		submitbttn.setIcon(new ImageIcon(SignUp.class.getResource("/images/Group 10.png")));
		submitbttn.setBounds(743, 438, 122, 28);
		signupframe.getContentPane().add(submitbttn);
		submitbttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				
				String Email = emailtxtfield.getText();
				String password = new String(passwordsignin.getPassword());

				if (Email.isEmpty() || password.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Registration Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						FileWriter writer = new FileWriter(file, true);
						writer.write(Email + ":" + password + "\n");
						writer.close();
						JOptionPane.showMessageDialog(null, "Registration successful.", "Registration Success",
								JOptionPane.INFORMATION_MESSAGE);
						LogIn window = new LogIn();
						window.loginframe.setVisible(true);
						signupframe.dispose();

					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Error registering user.", "Registration Error",
								JOptionPane.ERROR_MESSAGE);

					}
				}
			}
		});
		submitbttn.setBackground(new Color(30, 144, 255));

		signinlogo = new JLabel("");
		signinlogo.setIcon(new ImageIcon(SignUp.class.getResource("/images/Frame 10 1.png")));
		signinlogo.setBounds(483, 60, 322, 142);
		signupframe.getContentPane().add(signinlogo);

		panelsignup = new JLabel("");
		panelsignup.setIcon(new ImageIcon(SignUp.class.getResource("/images/Rectangle 10.png")));
		panelsignup.setBounds(429, 45, 454, 447);
		signupframe.getContentPane().add(panelsignup);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
			writer.write(fullname + "," + adresstextfield + "," + contacttextfield + "," + emailtxtfield + ","
					+ passwordsignin + "\n");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error saving user data.");
		}
	}
}
