import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class Pet {
    private String name;
    private String breed;
    private int age;

    public Pet(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class PetRecordingSystem extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;
    private JTextArea petListArea;
    private JTextField petNameField;
    private JTextField petBreedField;
    private JTextField petAgeField;
    private JButton addPetButton;

    private User currentUser;
    private ArrayList<Pet> petList;

    public PetRecordingSystem() {
        super("Pet Recording System");

        // Initialize UI components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        signupButton = new JButton("Sign Up");
        petListArea = new JTextArea(10, 40);
        petNameField = new JTextField(20);
        petBreedField = new JTextField(20);
        petAgeField = new JTextField(20);
        addPetButton = new JButton("Add Pet");

        // Layout components
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(signupButton);

        JPanel petPanel = new JPanel(new FlowLayout());
        petPanel.add(new JLabel("Pet Name:"));
        petPanel.add(petNameField);
        petPanel.add(new JLabel("Pet Breed:"));
        petPanel.add(petBreedField);
        petPanel.add(new JLabel("Pet Age:"));
        petPanel.add(petAgeField);
        petPanel.add(addPetButton);

        setLayout(new BorderLayout());
        add(loginPanel, BorderLayout.NORTH);
        add(new JScrollPane(petListArea), BorderLayout.CENTER);
        add(petPanel, BorderLayout.SOUTH);

        // Attach event listeners
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signup();
            }
        });

        addPetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPet();
            }
        });

        // Set initial state
        updateUI(false);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        User user = loadUser(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            petList = loadPets(currentUser.getUsername());
            updateUI(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }

    private void signup() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        User user = loadUser(username);
        if (user == null) {
            saveUser(new User(username, password));
            currentUser = new User(username, password);
            petList = new ArrayList<>();
            updateUI(true);
        } else {
            JOptionPane.showMessageDialog(this, "Username already exists");
        }
    }

    private void addPet() {
        String petName = petNameField.getText();
        String petBreed = petBreedField.getText();
        int petAge = Integer.parseInt(petAgeField.getText());

        petList.add(new Pet(petName, petBreed, petAge));
        savePets(currentUser.getUsername(), petList);

        updatePetListArea();
        clearPetFields();
    }

    private void updateUI(boolean loggedIn) {
        usernameField.setEnabled(!loggedIn);
        passwordField.setEnabled(!loggedIn);
        loginButton.setEnabled(!loggedIn);
        signupButton.setEnabled(!loggedIn);
        petListArea.setEnabled(loggedIn);
        petNameField.setEnabled(loggedIn);
        petBreedField.setEnabled(loggedIn);
        petAgeField.setEnabled(loggedIn);
        addPetButton.setEnabled(loggedIn);

        if (loggedIn) {
            petListArea.setText("");
            updatePetListArea();
        } else {
            petListArea.setText("");
            clearPetFields();
        }
    }

    private void updatePetListArea() {
        petListArea.setText("");
        for (Pet pet : petList) {
            petListArea.append("Name: " + pet.getName() + ", Breed: " + pet.getBreed() + ", Age: " + pet.getAge() + "\n");
        }
    }

    private void clearPetFields() {
        petNameField.setText("");
        petBreedField.setText("");
        petAgeField.setText("");
    }

    private User loadUser(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(username + ".txt"))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(":");
                String loadedUsername = parts[0];
                String password = parts[1];
                return new User(loadedUsername, password);
            }
        } catch (IOException e) {
            // File not found or error reading file
        }
        return null;
    }

    private void saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(user.getUsername() + ".txt"))) {
            writer.write(user.getUsername() + ":" + user.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Pet> loadPets(String username) {
        ArrayList<Pet> pets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(username + "_pets.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String name = parts[0];
                String breed = parts[1];
                int age = Integer.parseInt(parts[2]);
                pets.add(new Pet(name, breed, age));
            }
        } catch (IOException e) {
            // File not found or error reading file
        }
        return pets;
    }

    private void savePets(String username, ArrayList<Pet> pets) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(username + "_pets.txt"))) {
            for (Pet pet : pets) {
                writer.write(pet.getName() + ":" + pet.getBreed() + ":" + pet.getAge() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PetRecordingSystem app = new PetRecordingSystem();
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.pack();
                app.setVisible(true);
            }
        });
    }
}
