// Import Swing and AWT classes for GUI components and event handling
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main Calculator class extending JFrame (to create a GUI window)
// and implementing ActionListener (to handle button click events)
public class CalculatorGUI extends JFrame implements ActionListener {

    // Declare text fields and buttons as instance variables
    private JTextField num1Field, num2Field;
    private JButton addBtn, subBtn, mulBtn, divBtn;

    // Constructor — called when an object of CalculatorGUI is created
    public CalculatorGUI() {
        // Set window title
        setTitle("Swing Application");

        // Set layout: 5 rows, 2 columns, with gaps of 10 pixels
        setLayout(new GridLayout(5, 2, 10, 10));

        // Create labels and text fields
        JLabel label1 = new JLabel("Number 1");
        JLabel label2 = new JLabel("Number 2");
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);

        // Create buttons for four operations
        addBtn = new JButton("ADD");
        subBtn = new JButton("SUBTRACT");
        mulBtn = new JButton("MULTIPLY");
        divBtn = new JButton("DIVIDE");

        // Add ActionListeners (so when buttons are clicked, actionPerformed() runs)
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);

        // Add components to the frame (in the order they appear)
        add(label1);
        add(num1Field);
        add(label2);
        add(num2Field);
        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);

        // Set window size and position
        setSize(400, 250);
        setLocationRelativeTo(null); // Centers the window on the screen

        // Close the application when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        setVisible(true);
    }

    // This method runs when any button is clicked
    public void actionPerformed(ActionEvent e) {
        try {
            // Read and convert text from fields to numbers
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            String operation = "";

            // Check which button was clicked using e.getSource()
            if (e.getSource() == addBtn) {
                result = num1 + num2;
                operation = "Addition";
            } else if (e.getSource() == subBtn) {
                result = num1 - num2;
                operation = "Subtraction";
            } else if (e.getSource() == mulBtn) {
                result = num1 * num2;
                operation = "Multiplication";
            } else if (e.getSource() == divBtn) {
                // Handle division by zero error
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, 
                        "Cannot divide by zero!", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return; // Stop further execution
                }
                result = num1 / num2;
                operation = "Division";
            }

            // Show the result in a message dialog box
            JOptionPane.showMessageDialog(this, 
                operation + ": " + result, 
                "Message", 
                JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            // This runs if user enters non-numeric values
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numbers!", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method — program entry point
    public static void main(String[] args) {
        // Create and open the Calculator window
        new CalculatorGUI();
    }
}
