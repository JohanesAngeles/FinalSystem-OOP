import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingHashMapExampe extends JFrame {
	JFrame hash;
    private JTextField keyField;
    private JTextField valueField;
    private JButton saveButton;
    private JTextArea displayArea;

    private Map<String, String> dataMap;
    private JLabel lblNewLabel;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            
                SwingHashMapExampe window = new SwingHashMapExampe();
				window.hash.setVisible(true);
				
            }
        });
    }

    public SwingHashMapExampe() {
        setTitle("Swing HashMap Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel keyLabel = new JLabel("Key:");
        keyLabel.setBounds(78, 8, 22, 14);
        keyField = new JTextField(20);
        keyField.setBounds(105, 5, 166, 20);

        JLabel valueLabel = new JLabel("Value:");
        valueLabel.setBounds(276, 8, 30, 14);
        valueField = new JTextField(20);
        valueField.setBounds(78, 31, 166, 20);

        saveButton = new JButton("Save");
        saveButton.setBounds(249, 30, 57, 23);

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = keyField.getText();
                String value = valueField.getText();

                if (key.isEmpty() || value.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both a key and a value.");
                } else {
                    dataMap.put(key, value);
                    displayArea.setText(getDataMapAsString());
                    keyField.setText("");
                    valueField.setText("");
                }
            }
        });
        getContentPane().setLayout(null);

        getContentPane().add(keyLabel);
        getContentPane().add(keyField);
        getContentPane().add(valueLabel);
        getContentPane().add(valueField);
        getContentPane().add(saveButton);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(69, 58, 246, 186);
        getContentPane().add(scrollPane);
        
        lblNewLabel = new JLabel("back");
        lblNewLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Pets window = new Pets();
				window.petframe.setVisible(true);
				hash.dispose();
        	}
        });
        lblNewLabel.setBounds(0, 8, 46, 14);
        getContentPane().add(lblNewLabel);

        dataMap = new HashMap<>();

        setVisible(true);
    }

    private String getDataMapAsString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            sb.append("Key: ").append(entry.getKey()).append("\tValue: ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    
}
