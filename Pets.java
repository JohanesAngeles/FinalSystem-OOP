import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pets extends JFrame{

	 JFrame petframe;
	 JPanel picpanel;
	 private ImageIcon picIcon;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pets window = new Pets();
					window.petframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pets() {
	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		petframe = new JFrame();
		petframe.setBounds(100, 100, 1250, 600);
		petframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		petframe.getContentPane().setBackground(new Color(255, 235, 235));
		petframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Pets.class.getResource("/images/Group 12.png")));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(493, 500, 225, 44);
		petframe.getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 1234, 51);
		petframe.getContentPane().add(panel);
		
		JPanel pet = new JPanel();
		pet.setBounds(93, 175, 281, 318);
		petframe.getContentPane().add(pet);
		pet.setLayout(null);
	
		
		JPanel pet1 = new JPanel();
		pet1.setBounds(455, 175, 311, 318);
		petframe.getContentPane().add(pet1);
		pet1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pets.class.getResource("/images/Group 12.png")));
		lblNewLabel.setBounds(116, 500, 225, 44);
		petframe.getContentPane().add(lblNewLabel);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Addpets window = new Addpets();
				window.addpetframe.setVisible(true);
				petframe.dispose();
			}
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel ownerprofilelbl = new JLabel("Owner Profile");
		ownerprofilelbl.setIcon(new ImageIcon(Pets.class.getResource("/images/Group 13.png")));
		ownerprofilelbl.setBounds(42, 75, 225, 44);
		petframe.getContentPane().add(ownerprofilelbl);
		ownerprofilelbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ownerprofile window = new Ownerprofile();
				window.ownerframe.setVisible(true);
				petframe.dispose();
			}
		});
		ownerprofilelbl.setForeground(new Color(255, 255, 255));
		ownerprofilelbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel framepet1 = new JLabel("");
		framepet1.setIcon(new ImageIcon(Pets.class.getResource("/images/Rectangle 27.png")));
		framepet1.setBounds(845, 159, 261, 335);
		petframe.getContentPane().add(framepet1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Pets.class.getResource("/images/Group 12.png")));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(855, 500, 225, 44);
		petframe.getContentPane().add(lblNewLabel_2_1);
	}
}
