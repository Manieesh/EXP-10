// Import required Swing and AWT classes for GUI components and events
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main class that starts the program
public class StudentRegistration {
    public static void main(String[] args) {
        // Creates and opens the registration frame when the program starts
        new RegisterFrame();
    }
}

// Class for the registration form window
class RegisterFrame extends JFrame implements ActionListener {

    // Declare GUI components
    JTextField nameField;
    JRadioButton male, female;
    JCheckBox apple, samsung, redmi, oneplus;
    JComboBox<String> colorBox;
    JButton saveBtn;

    // Constructor for the RegisterFrame class
    RegisterFrame() {
        // Set title and size of the window
        setTitle("Register");
        setSize(400, 300);

        // Set close operation to exit the program when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use a grid layout: 6 rows, 2 columns, and small gaps between components
        setLayout(new GridLayout(6, 2, 5, 5));

        // ---- Name Section ----
        add(new JLabel("Name:"));                // Label for name
        nameField = new JTextField();            // Text field for user input
        add(nameField);                          // Add text field to the frame

        // ---- Gender Section ----
        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();       // A panel to group radio buttons
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        // ButtonGroup ensures only one radio button can be selected
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        genderPanel.add(male);
        genderPanel.add(female);
        add(genderPanel);

        // ---- Model Section (Checkboxes) ----
        add(new JLabel("Model:"));
        JPanel modelPanel = new JPanel();

        // Create checkboxes for different phone models
        apple = new JCheckBox("Apple");
        samsung = new JCheckBox("Samsung");
        redmi = new JCheckBox("Redmi");
        oneplus = new JCheckBox("OnePlus");

        // Add all checkboxes to the panel
        modelPanel.add(apple);
        modelPanel.add(samsung);
        modelPanel.add(redmi);
        modelPanel.add(oneplus);
        add(modelPanel);

        // ---- Color Section (Combo Box) ----
        add(new JLabel("Color:"));
        String[] colors = {"Black", "White", "Blue", "Red"}; // Options for color
        colorBox = new JComboBox<>(colors);                   // Drop-down box
        add(colorBox);

        // ---- Save Button ----
        saveBtn = new JButton("Save");
        add(new JLabel());            // Empty label for spacing
        add(saveBtn);

        // Add action listener to handle button clicks
        saveBtn.addActionListener(this);

        // Make the window visible
        setVisible(true);
    }

    // This method is called when the "Save" button is clicked
    public void actionPerformed(ActionEvent e) {
        // Get the entered name
        String name = nameField.getText();

        // Determine gender based on selected radio button
        String gender = male.isSelected() ? "Male" :
                        (female.isSelected() ? "Female" : "Not Selected");

        // Collect selected phone models
        StringBuilder models = new StringBuilder();
        if (apple.isSelected()) models.append("Apple ");
        if (samsung.isSelected()) models.append("Samsung ");
        if (redmi.isSelected()) models.append("Redmi ");
        if (oneplus.isSelected()) models.append("OnePlus ");

        // Get selected color from combo box
        String color = (String) colorBox.getSelectedItem();

        // Open a new window to display the collected information
        new DisplayFrame(name, gender, models.toString(), color);
    }
}

// Class for the display window that shows user input
class DisplayFrame extends JFrame {
    // Constructor for display frame
    DisplayFrame(String name, String gender, String models, String color) {
        setTitle("Display");
        setSize(350, 200);
        setLayout(new BorderLayout());

        // Create a text area to show registration details
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false); // Make text area read-only

        // Set the text to show entered information
        displayArea.setText("Name: " + name + "\n"
                + "Gender: " + gender + "\n"
                + "Model: " + models + "\n"
                + "Color: " + color);

        // Add text area to center of frame
        add(displayArea, BorderLayout.CENTER);

        // Add "OK" button to close the window
        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(e -> dispose()); // dispose() closes this frame
        add(okBtn, BorderLayout.SOUTH);

        // Make the display window visible
        setVisible(true);
    }
}
