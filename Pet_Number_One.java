import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pet_Number_One extends JFrame{

	JFrame Petnumber1frame;
	JLabel nameDisplay,ageDisplay,genderDisplay,breedDisplay,favoritefoodDisplay;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pet_Number_One window = new Pet_Number_One();
					window.Petnumber1frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pet_Number_One() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Petnumber1frame = new JFrame();
		Petnumber1frame.setBounds(100, 100, 1250, 600);
		Petnumber1frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Petnumber1frame.getContentPane().setLayout(null);
		 
		 JLabel back = new JLabel("back");
		 back.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		Pets window = new Pets();
				window.petframe.setVisible(true);
				Petnumber1frame.dispose();
		 	}
		 });
		 back.setBounds(22, 213, 68, 39);
		 Petnumber1frame.getContentPane().add(back);
		
		 favoritefoodDisplay = new JLabel("");
		favoritefoodDisplay.setFont(new Font("Times New Roman", Font.BOLD, 16));
		favoritefoodDisplay.setBounds(984, 264, 205, 23);
		Petnumber1frame.getContentPane().add(favoritefoodDisplay);
		
		JLabel favoritefoodlbl = new JLabel("FAVORITE FOOD:");
		favoritefoodlbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		favoritefoodlbl.setBounds(835, 264, 127, 23);
		Petnumber1frame.getContentPane().add(favoritefoodlbl);
		
		 genderDisplay = new JLabel("");
		genderDisplay.setFont(new Font("Times New Roman", Font.BOLD, 16));
		genderDisplay.setBounds(660, 264, 160, 23);
		Petnumber1frame.getContentPane().add(genderDisplay);
		
		JLabel genderlbl = new JLabel("GENDER:");
		genderlbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		genderlbl.setBounds(576, 264, 90, 23);
		Petnumber1frame.getContentPane().add(genderlbl);
		
		 breedDisplay = new JLabel("");
		breedDisplay.setFont(new Font("Times New Roman", Font.BOLD, 16));
		breedDisplay.setBounds(267, 264, 126, 23);
		Petnumber1frame.getContentPane().add(breedDisplay);
		
		 nameDisplay = new JLabel("");
		nameDisplay.setFont(new Font("Times New Roman", Font.BOLD, 48));
		nameDisplay.setBounds(199, 203, 528, 49);
		Petnumber1frame.getContentPane().add(nameDisplay);
		
		 ageDisplay = new JLabel("");
		ageDisplay.setFont(new Font("Times New Roman", Font.BOLD, 16));
		ageDisplay.setBounds(440, 264, 108, 23);
		Petnumber1frame.getContentPane().add(ageDisplay);
		
		JLabel agelbl = new JLabel("AGE:");
		agelbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		agelbl.setBounds(403, 264, 68, 23);
		Petnumber1frame.getContentPane().add(agelbl);
		
		JLabel Breedlbl = new JLabel("BREED:");
		Breedlbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Breedlbl.setBounds(209, 264, 68, 23);
		Petnumber1frame.getContentPane().add(Breedlbl);
		
		
		
		JLabel petnumber1background = new JLabel("");
		petnumber1background.setIcon(new ImageIcon(Pet_Number_One.class.getResource("/images/Frame 29.png")));
		petnumber1background.setBounds(0, 0, 1234, 562);
		Petnumber1frame.getContentPane().add(petnumber1background);
		
		JLabel immunizationsdewormingbttn = new JLabel("");
		immunizationsdewormingbttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImmunizationsDeworming window = new ImmunizationsDeworming();
				window.dewormingframe.setVisible(true);
				Petnumber1frame.dispose();
				
			}
		});
		immunizationsdewormingbttn.setBounds(95, 328, 521, 195);
		Petnumber1frame.getContentPane().add(immunizationsdewormingbttn);getContentPane().setLayout(null);
	}
}
