import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification extends JFrame {
    private JTextField dateField;
    private JTextField timeField;

    public Notification() {
        setTitle("Notification");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel dateLabel = new JLabel("Date (yyyy-MM-dd):");
        dateField = new JTextField();
        JLabel timeLabel = new JLabel("Time (HH:mm):");
        timeField = new JTextField();
        JButton setButton = new JButton("Set Notification");

        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateText = dateField.getText();
                String timeText = timeField.getText();

                LocalDateTime notificationDateTime = LocalDateTime.parse(dateText + "T" + timeText);
                LocalDateTime currentDateTime = LocalDateTime.now();

                long daysUntilNotification = currentDateTime.until(notificationDateTime, java.time.temporal.ChronoUnit.DAYS);

                if (daysUntilNotification <= 3 && daysUntilNotification >= 0) {
                    JOptionPane.showMessageDialog(null, "Notification: Date approaching in " + daysUntilNotification + " days!");
                } else {
                    JOptionPane.showMessageDialog(null, "Notification: Date is not within 3 days!");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(timeLabel);
        panel.add(timeField);
        panel.add(setButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Notification();
            }
        });
    }
}
