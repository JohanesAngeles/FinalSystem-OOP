import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;



import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ownerprofile extends JFrame {
	JFrame ownerframe;

	JLabel nameLabel, phoneLabel, adressLabel;
	
	private ArrayList<String> data;
	private JLabel ProfilePicture;
	private ImageIcon image;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ownerprofile window = new Ownerprofile();
					window.ownerframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ownerprofile() {

		initialize();
	}

	private void initialize() {
		data = new ArrayList<>();
		ownerframe = new JFrame();
		ownerframe.getContentPane().setBackground(new Color(173, 228, 219));
		ownerframe.setBounds(100, 100, 1250, 633);
		ownerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ownerframe.getContentPane().setLayout(null);
				
				JButton btnNewButton = new JButton("");
				btnNewButton.setIcon(new ImageIcon(Ownerprofile.class.getResource("/images/SelectProPic.png")));
				btnNewButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						
						JFileChooser fileChooser = new JFileChooser();
		                int option = fileChooser.showOpenDialog(Ownerprofile.this);
		                if (option == JFileChooser.APPROVE_OPTION) {
		                    File file = fileChooser.getSelectedFile();
		                    ImageIcon imageIcon = new ImageIcon(file.getPath());
		                    Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		                    ProfilePicture.setIcon(new ImageIcon(image));
		                    
		                
		                }
		                
					}
						
						
		
				});
				
				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.setIcon(new ImageIcon(Ownerprofile.class.getResource("/images/AddOwnersInfo.png")));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Ownerinfo ownerinfo = new Ownerinfo();
						ownerinfo.ownerinfoframe.setVisible(true);
						ownerframe.dispose();
						
					}
				});
				
				btnNewButton_2 = new JButton("save");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				     
						saveData();
						
					}
				});
				
				lblNewLabel = new JLabel("");
				lblNewLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						Pets pets = new Pets();
						pets.petframe.setVisible(true);
						ownerframe.dispose();
					}
				});
				lblNewLabel.setIcon(new ImageIcon(Ownerprofile.class.getResource("/images/returnBUTTON (2).png")));
				lblNewLabel.setBounds(1100, 37, 44, 55);
				ownerframe.getContentPane().add(lblNewLabel);
				btnNewButton_2.setBounds(999, 481, 89, 23);
				ownerframe.getContentPane().add(btnNewButton_2);
				btnNewButton_1.setBounds(109, 468, 266, 36);
				ownerframe.getContentPane().add(btnNewButton_1);
				btnNewButton.setBounds(109, 421, 266, 36);
				ownerframe.getContentPane().add(btnNewButton);
				
				ProfilePicture = new JLabel("");
				ProfilePicture.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(109, 169, 255)));
				ProfilePicture.setBounds(161, 243, 152, 149);
				ownerframe.getContentPane().add(ProfilePicture);
		
				adressLabel = new JLabel("");
				adressLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
				adressLabel.setBounds(451, 399, 280, 36);
				ownerframe.getContentPane().add(adressLabel);

		phoneLabel = new JLabel("");
		phoneLabel.setFont(new Font("Segoe UI", Font.BOLD, 23));
		phoneLabel.setBounds(808, 301, 280, 36);
		ownerframe.getContentPane().add(phoneLabel);

		nameLabel = new JLabel("");
		nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 23));
		nameLabel.setBounds(451, 301, 280, 36);
		ownerframe.getContentPane().add(nameLabel);

		JLabel ownerlbl = new JLabel("");
		ownerlbl.setIcon(new ImageIcon(Ownerprofile.class.getResource("/images/Owner Profile.png")));
		ownerlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ownerlbl.setBounds(0, 0, 1234, 600);
		ownerframe.getContentPane().add(ownerlbl);
	}
	 private void saveData() {
		 
	        String input = adressLabel.getText();
	        String input2 = phoneLabel .getText();
	        String input3 = nameLabel.getText();
	        if (!input.isEmpty() || input2.isEmpty() || input3.isEmpty()) {
	            data.add(input);
	            data.add(input2);
	            data.add(input3);
	            displayData();
	           
	        }
	    }

	    private void displayData() {
	        StringBuilder sb = new StringBuilder();
	        for (String item : data) {
	            sb.append(item);
	            sb.append("\n");
	        }
	        
	    }
}
