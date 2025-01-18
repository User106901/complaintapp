package notlogged;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class anonimet {
    private JPanel container;
    private CardLayout cards;

    public anonimet(JPanel container, CardLayout cards) {
        this.container = container;
        this.cards = cards;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setForeground(new Color(255, 255, 255));
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 800);
        panel.setBackground(new Color(192, 192, 192)); 

   
        JLabel titleLabel = new JLabel("Anonymous Tips Submission");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(50, 50, 50)); 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(50, 20, 700, 40);
        panel.add(titleLabel);

        
        ImageIcon imageIcon = new ImageIcon("an.png"); // Replace with your image path
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        // Create a JLabel and set the image
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(515, 417, 189, 175);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(imageLabel);
        
        
        JLabel tipLabel = new JLabel("Enter Tip:");
        tipLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        tipLabel.setBounds(50, 70, 100, 30);
        panel.add(tipLabel);

      
        JTextArea tipArea = new JTextArea();
        tipArea.setBounds(50, 100, 700, 120);
        tipArea.setLineWrap(true);
        tipArea.setWrapStyleWord(true);
        tipArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tipArea.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(tipArea);

        JLabel locationLabel = new JLabel("Enter Location:");
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        locationLabel.setBounds(50, 230, 150, 30);
        panel.add(locationLabel);

       
        JTextField locationField = new JTextField();
        locationField.setBounds(50, 260, 159, 30);
        locationField.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(locationField);

        
        JLabel typeLabel = new JLabel("Select the Type of Tip:");
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        typeLabel.setBounds(403, 369, 200, 30);
        panel.add(typeLabel);

       
        JRadioButton crimeRadio = new JRadioButton("Crime");
        crimeRadio.setBackground(new Color(192, 192, 192));
        JRadioButton safetyRadio = new JRadioButton("Safety Concern");
        safetyRadio.setBackground(new Color(192, 192, 192));

        
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(crimeRadio);
        typeGroup.add(safetyRadio);

        crimeRadio.setBounds(403, 417, 150, 30);
        safetyRadio.setBounds(403, 467, 150, 30);

        panel.add(crimeRadio);
        panel.add(safetyRadio);

       
        JCheckBox option1 = new JCheckBox("Option 1: Urgent");
        JCheckBox option2 = new JCheckBox("Option 2: Moderate priority");
        JCheckBox option3 = new JCheckBox("Option 3: Low priority");

        
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

       
        option1.setFont(new Font("Arial", Font.PLAIN, 14));
        option1.setBounds(50, 429, 200, 30);
        option1.setBackground(new Color(192, 192, 192));
        panel.add(option1);

        option2.setFont(new Font("Arial", Font.PLAIN, 14));
        option2.setBounds(50, 481, 200, 30);
        option2.setBackground(new Color(192, 192, 192));
        panel.add(option2);

        option3.setFont(new Font("Arial", Font.PLAIN, 14));
        option3.setBounds(50, 535, 200, 30);
        option3.setBackground(new Color(192, 192, 192));
        panel.add(option3);

        
        JButton submitButton = new JButton("Submit Tip");
        submitButton.setBounds(50, 594, 150, 40);
        submitButton.setBackground(new Color(112, 117, 143));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(submitButton);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(50, 319, 700, 18);
        panel.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(new Color(192, 192, 192));
        separator_1.setForeground(new Color(255, 255, 255));
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(366, 347, 17, 273);
        panel.add(separator_1);
        
        JLabel lblNewLabel = new JLabel("Condition:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(51, 367, 128, 30);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setForeground(new Color(0, 128, 0));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(403, 562, 311, 30);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1 = new JLabel("<html>Your silence could be the key to someone else's safety.<br>Every tip matters, stay anonymous and help make a difference.</html>");
        lblNewLabel_1.setForeground(new Color(128, 128, 128));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
        lblNewLabel_1.setBounds(403, 619, 347, 56);
        panel.add(lblNewLabel_1);
        
       

        submitButton.addActionListener((ActionEvent e) -> {
            String tipText = tipArea.getText().trim();
            String location = locationField.getText().trim();
            String tipType = crimeRadio.isSelected() ? "Crime" : 
                             safetyRadio.isSelected() ? "Safety Concern" : null;
            String priority = option1.isSelected() ? "Urgent" : 
                              option2.isSelected() ? "Moderate Priority" : 
                              option3.isSelected() ? "Low Priority" : null;

            tipArea.setText("");
            locationField.setText("");
            typeGroup.clearSelection();
            group.clearSelection();

            
            if (tipText.isEmpty() || location.isEmpty() || tipType == null || priority == null) {
                JOptionPane.showMessageDialog(panel, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            saveTipToDatabase(tipText, location, tipType, priority, lblNewLabel_2);
        });

        return panel;
    }

    private void saveTipToDatabase(String tipText, String location, String tipType, String priority,JLabel lblNewLabel_2) {
        String query = "INSERT INTO complaint (name, crime, location, tipType, priority) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "Anonymous");
            stmt.setString(2, tipText);
            stmt.setString(3, location);
            stmt.setString(4, tipType);
            stmt.setString(5, priority);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
            	lblNewLabel_2.setText("Complaint submitted successfully! ");} 
            else {
                JOptionPane.showMessageDialog(null, "Failed to submit tip.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            lblNewLabel_2.revalidate();
            lblNewLabel_2.repaint();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
