import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class Addpets extends JFrame {

	JFrame addpetframe;
	private JTextField petnamefield;
	private JTextField petagefield;
	private JTextField petgenderfield;
	private JTextField petbreedfield;
	private JTextField petfavoritefield;
	private ImageIcon picIcon;

	private JLabel addpetbg;
	private JLabel namepet;
	private JLabel agepet;
	private JLabel genderpet;
	private JLabel breedpet;
	private JLabel favoritepet;
	private JLabel submitbttn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addpets window = new Addpets();
					window.addpetframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Addpets() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addpetframe = new JFrame();
		addpetframe.setBounds(100, 100, 1250, 600);
		addpetframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addpetframe.getContentPane().setBackground(new Color(173, 228, 219));
		addpetframe.getContentPane().setLayout(null);

		submitbttn = new JLabel("");
		submitbttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = petnamefield.getText();
				String age = petagefield.getText();
				String gender = petgenderfield.getText();
				String breed = petbreedfield.getText();
				String fave = petfavoritefield.getText();
				Pet_Number_One petwindow = new Pet_Number_One();
				
				petwindow.nameDisplay.setText(name);
				petwindow.ageDisplay.setText(age);
				petwindow.genderDisplay.setText(gender);
				petwindow.breedDisplay.setText(breed);
				petwindow.favoritefoodDisplay.setText(fave);
				petwindow.Petnumber1frame.setVisible(true);
				addpetframe.dispose();

			}
		});
		
		
				
		submitbttn.setIcon(new ImageIcon(Addpets.class.getResource("/images/Group 10.png")));
		submitbttn.setBounds(713, 383, 122, 28);
		addpetframe.getContentPane().add(submitbttn);

		favoritepet = new JLabel("");
		favoritepet.setIcon(new ImageIcon(Addpets.class.getResource("/images/Rectangle 11.png")));
		favoritepet.setBounds(450, 318, 372, 28);
		addpetframe.getContentPane().add(favoritepet);

		breedpet = new JLabel("");
		breedpet.setIcon(new ImageIcon(Addpets.class.getResource("/images/Rectangle 11.png")));
		breedpet.setBounds(450, 275, 372, 28);
		addpetframe.getContentPane().add(breedpet);

		genderpet = new JLabel("");
		genderpet.setIcon(new ImageIcon(Addpets.class.getResource("/images/Rectangle 11.png")));
		genderpet.setBounds(450, 236, 372, 28);
		addpetframe.getContentPane().add(genderpet);

		agepet = new JLabel("");
		agepet.setIcon(new ImageIcon(Addpets.class.getResource("/images/Rectangle 11.png")));
		agepet.setBounds(450, 197, 372, 28);
		addpetframe.getContentPane().add(agepet);

		namepet = new JLabel("");
		namepet.setIcon(new ImageIcon(Addpets.class.getResource("/images/Rectangle 11.png")));
		namepet.setBounds(450, 146, 372, 28);
		addpetframe.getContentPane().add(namepet);

		petnamefield = new JTextField();
		petnamefield.setBorder(null);
		petnamefield.setBackground(new Color(236, 233, 233));
		petnamefield.setBounds(468, 152, 337, 14);
		addpetframe.getContentPane().add(petnamefield);
		petnamefield.setColumns(10);
		petnamefield.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (petnamefield.getText().equals("Pet Name")) {
					petnamefield.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (petnamefield.getText().equals("")) {
					petnamefield.setText("Pet Name");
				}
			}
		});

		petagefield = new JTextField();
		petagefield.setBorder(null);
		petagefield.setBackground(new Color(236, 233, 233));
		petagefield.setBounds(468, 204, 337, 14);
		addpetframe.getContentPane().add(petagefield);
		petagefield.setColumns(10);
		petagefield.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (petagefield.getText().equals("Pet Age")) {
					petagefield.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (petagefield.getText().equals("")) {
					petagefield.setText("Pet Age");
				}
			}
		});

		petgenderfield = new JTextField();
		petgenderfield.setBorder(null);
		petgenderfield.setBackground(new Color(236, 233, 233));
		petgenderfield.setBounds(468, 244, 337, 14);
		addpetframe.getContentPane().add(petgenderfield);
		petgenderfield.setColumns(10);
		petgenderfield.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (petgenderfield.getText().equals("Pet Gender")) {
					petgenderfield.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (petgenderfield.getText().equals("")) {
					petgenderfield.setText("Pet Gender");
				}
			}
		});

		petbreedfield = new JTextField();
		petbreedfield.setBorder(null);
		petbreedfield.setBackground(new Color(236, 233, 233));
		petbreedfield.setBounds(468, 283, 337, 14);
		addpetframe.getContentPane().add(petbreedfield);
		petbreedfield.setColumns(10);
		petbreedfield.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (petbreedfield.getText().equals("Pet Breed")) {
					petbreedfield.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (petbreedfield.getText().equals("")) {
					petbreedfield.setText("Pet Breed");
				}
			}
		});

		petfavoritefield = new JTextField();
		petfavoritefield.setBorder(null);
		petfavoritefield.setBackground(new Color(236, 233, 233));
		petfavoritefield.setBounds(468, 325, 337, 14);
		addpetframe.getContentPane().add(petfavoritefield);
		petfavoritefield.setColumns(10);
		petfavoritefield.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (petfavoritefield.getText().equals("Pet Favorite Food")) {
					petfavoritefield.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (petfavoritefield.getText().equals("")) {
					petfavoritefield.setText("Pet Favorite Food");
				}
			}
		});

		JLabel Addpet = new JLabel("Add Pet");
		Addpet.setBounds(574, 70, 88, 36);
		addpetframe.getContentPane().add(Addpet);
		Addpet.setFont(new Font("Times New Roman", Font.BOLD, 20));

		addpetbg = new JLabel("");
		addpetbg.setIcon(new ImageIcon(Addpets.class.getResource("/images/Rectangle 10.png")));
		addpetbg.setBounds(414, 47, 454, 447);
		addpetframe.getContentPane().add(addpetbg);

	}
}
