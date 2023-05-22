
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ImmunizationsDeworming extends JFrame {
    private JTable table;

    public ImmunizationsDeworming() {
        // Set up JFrame properties
        setTitle("Table Export/Import Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250, 633);

        // Create sample data
        String[] columns = {"Date", "Weight","Againts", "Manufacturer","Lot Number","Veterinarian"};
        Object[][] data = {
                {"", "", "", "", "", "",},
                {"", "", "", "", "", ""},
                {"", "", "", "", "", ""}
        };

        // Create a table model with the data
        DefaultTableModel model = new DefaultTableModel(data, columns);
        getContentPane().setLayout(null);
        
                // Add the table to the frame
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                scrollPane.setBorder(null);
                scrollPane.setBounds(151, 233, 886, 184);
                getContentPane().add(scrollPane);
                
                        // Create the JTable using the model
                        table = new JTable(new DefaultTableModel(
                        	new Object[][] {
                        		{"", "", "", "", "", ""},
                        		{"", "", "", "", "", ""},
                        		{"", "", "", "", "", ""},
                        		{"", "","" , "", "", ""},
                        		{"", "","" , "", "", ""},
                        		{"", "","" , "", "", ""},
                        		{"", "","" , "", "", ""},
                        		{"", "","" , "", "", ""},
                        		{"", "","" , "", "", ""}
                        	},
                        	new String[] {
                        		"Date", "Weight", "Againts", "Manufacturer", "Lot Number", "Veterinarian"
                        	}
                        ));
                        table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
                        scrollPane.setViewportView(table);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(ImmunizationsDeworming.class.getResource("/images/Group 17.png")));
        lblNewLabel_1.setBounds(68, 112, 1107, 367);
        getContentPane().add(lblNewLabel_1);
        JButton importButton = new JButton("Import");
        importButton.setBounds(813, 435, 173, 23);
        getContentPane().add(importButton);
        
                // Add buttons for export and import
                JButton exportButton = new JButton("Export");
                exportButton.setBounds(279, 435, 173, 23);
                getContentPane().add(exportButton);
                
                JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setIcon(new ImageIcon(ImmunizationsDeworming.class.getResource("/images/Group 16.png")));
                lblNewLabel.setBounds(0, 0, 1234, 594);
                getContentPane().add(lblNewLabel);
                
                        // Action listener for the export button
                        exportButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                exportTableData();
                            }
                        });

        // Action listener for the import button
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importTableData();
            }
        });
    }

    private void exportTableData() {
        try {
            // Create a file chooser dialog
            JFileChooser fileChooser = new JFileChooser();
            int choice = fileChooser.showSaveDialog(this);

            if (choice == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                File file = fileChooser.getSelectedFile();

                // Open a file writer
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                // Write the table data to the file
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        writer.write(table.getValueAt(i, j).toString());
                        if (j < table.getColumnCount() - 1)
                            writer.write(",");
                    }
                    writer.newLine();
                }

                // Close the writer
                writer.close();

                JOptionPane.showMessageDialog(this, "Table data exported successfully.");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error exporting table data: " + ex.getMessage());
        }
    }

    private void importTableData() {
        try {
            // Create a file chooser dialog
            JFileChooser fileChooser = new JFileChooser();
            int choice = fileChooser.showOpenDialog(this);

            if (choice == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                File file = fileChooser.getSelectedFile();

                // Open a file reader
                BufferedReader reader = new BufferedReader(new FileReader(file));

                // Read the file line by line
                String line;
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Clear existing table data

                while ((line = reader.readLine()) != null) {
                    // Split the line by comma
                    String[] rowData = line.split(",");

                    // Add a new row to the table model
                    model.addRow(rowData);
                }

                // Close the reader
                reader.close();

                JOptionPane.showMessageDialog(this, "Table data imported successfully.");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error importing table data: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImmunizationsDeworming().setVisible(true);
            }
        });
    }
}
