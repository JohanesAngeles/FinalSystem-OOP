import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ownerinfo extends JFrame{

	JFrame ownerinfoframe;
	private JTextField nameJTextfield;
	private JTextField numberJTextfield;
	private JTextField adressJTextfield;
	private JLabel logo;
	private JLabel nameframe;
	private JLabel numberframe;
	private JLabel adressframe;
	private JLabel submitbttn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ownerinfo window = new Ownerinfo();
					window.ownerinfoframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ownerinfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ownerinfoframe = new JFrame();
		ownerinfoframe.getContentPane().setBackground(new Color(173, 228, 219));
		ownerinfoframe.setBounds(100, 100, 636, 485);
		ownerinfoframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ownerinfoframe.getContentPane().setLayout(null);
		
		nameJTextfield = new JTextField();
		nameJTextfield.setBorder(null);
		nameJTextfield.setBackground(new Color(236, 233, 233));
		nameJTextfield.setBounds(143, 197, 337, 14);
		ownerinfoframe.getContentPane().add(nameJTextfield);
		nameJTextfield.setColumns(10);
		nameJTextfield.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (nameJTextfield.getText().equals("Name")) {
					nameJTextfield.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (nameJTextfield.getText().equals("")) {
					nameJTextfield.setText("Name");
				}
			}
		});
		
		numberJTextfield = new JTextField();
		numberJTextfield.setBorder(null);
		numberJTextfield.setBackground(new Color(236, 233, 233));
		numberJTextfield.setColumns(10);
		numberJTextfield.setBounds(143, 229, 337, 14);
		ownerinfoframe.getContentPane().add(numberJTextfield);
		numberJTextfield.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (numberJTextfield.getText().equals("Phone Number")) {
					numberJTextfield.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (numberJTextfield.getText().equals("")) {
					numberJTextfield.setText("Phone Number");
				}
			}
		});
		
		adressJTextfield = new JTextField();
		adressJTextfield.setBorder(null);
		adressJTextfield.setBackground(new Color(236, 233, 233));
		adressJTextfield.setColumns(10);
		adressJTextfield.setBounds(143, 261, 337, 14);
		ownerinfoframe.getContentPane().add(adressJTextfield);
		
		adressJTextfield.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (adressJTextfield.getText().equals("Adress")) {
					adressJTextfield.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (adressJTextfield.getText().equals("")) {
					adressJTextfield.setText("Adress");
				}
			}
		});
		
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(Ownerinfo.class.getResource("/images/Frame 10 1.png")));
		logo.setBounds(135, 11, 332, 142);
		ownerinfoframe.getContentPane().add(logo);
		
		nameframe = new JLabel("");
		nameframe.setIcon(new ImageIcon(Ownerinfo.class.getResource("/images/Rectangle 11.png")));
		nameframe.setBounds(118, 190, 372, 28);
		ownerinfoframe.getContentPane().add(nameframe);
		
		numberframe = new JLabel("");
		numberframe.setIcon(new ImageIcon(Ownerinfo.class.getResource("/images/Rectangle 11.png")));
		numberframe.setBounds(118, 222, 372, 28);
		ownerinfoframe.getContentPane().add(numberframe);
		
		adressframe = new JLabel("");
		adressframe.setIcon(new ImageIcon(Ownerinfo.class.getResource("/images/Rectangle 11.png")));
		adressframe.setBounds(118, 254, 372, 28);
		ownerinfoframe.getContentPane().add(adressframe);
		
		submitbttn = new JLabel("");
		submitbttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String inputname = nameJTextfield.getText();
				String inputadress = adressJTextfield.getText();
				String inputnumber = numberJTextfield.getText();
				Ownerprofile window = new Ownerprofile();
				window.ownerframe.setVisible(true);
				window.nameLabel.setText(inputname);
				window.adressLabel.setText(inputadress);
				window.phoneLabel.setText(inputnumber);
				window.ownerframe.setVisible(true);
				ownerinfoframe.dispose();
			}
		});
		submitbttn.setIcon(new ImageIcon(Ownerinfo.class.getResource("/images/Group 10.png")));
		submitbttn.setBounds(238, 306, 122, 28);
		ownerinfoframe.getContentPane().add(submitbttn);
	}

}
