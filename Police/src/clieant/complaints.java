package clieant;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class complaints {
    private JPanel container;
    private CardLayout cards;

    public complaints(JPanel container, CardLayout cards) {
        this.container = container;
        this.cards = cards;
    }

    public JPanel getPanel() {
        JPanel reportCrimePanel = new JPanel();
        reportCrimePanel.setLayout(null);
        reportCrimePanel.setBounds(0, 0, 800, 800);
        reportCrimePanel.setBackground(Color.LIGHT_GRAY);

        JLabel headerLabel = new JLabel("Report a Crime");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBounds(20, 20, 300, 40);
        reportCrimePanel.add(headerLabel);

        JLabel nameLabel = new JLabel("Your Name:");
        nameLabel.setBounds(20, 80, 150, 30);
        reportCrimePanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 80, 250, 30);
        reportCrimePanel.add(nameField);

        JLabel contactLabel = new JLabel("Contact Info:");
        contactLabel.setBounds(20, 130, 150, 30);
        reportCrimePanel.add(contactLabel);

        JTextField contactField = new JTextField();
        contactField.setBounds(150, 130, 250, 30);
        reportCrimePanel.add(contactField);

        JLabel crimeTypeLabel = new JLabel("Type of Crime:");
        crimeTypeLabel.setBounds(20, 180, 150, 30);
        reportCrimePanel.add(crimeTypeLabel);

        JComboBox<String> crimeTypeCombo = new JComboBox<>(new String[]{"Theft", "Assault", "Vandalism", "Fraud", "Other"});
        crimeTypeCombo.setBounds(150, 180, 250, 30);
        reportCrimePanel.add(crimeTypeCombo);

        JLabel dateLabel = new JLabel("Date of Crime:");
        dateLabel.setBounds(20, 230, 150, 30);
        reportCrimePanel.add(dateLabel);

        JTextField dateField = new JTextField("YYYY-MM-DD");
        dateField.setBounds(150, 230, 250, 30);
        reportCrimePanel.add(dateField);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(20, 280, 150, 30);
        reportCrimePanel.add(locationLabel);

        JTextField locationField = new JTextField();
        locationField.setBounds(150, 280, 600, 30);
        reportCrimePanel.add(locationField);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(20, 330, 150, 30);
        reportCrimePanel.add(descriptionLabel);

        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setBounds(20, 370, 730, 150);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        reportCrimePanel.add(descriptionArea);

        JButton submitButton = new JButton("Submit Report");
        submitButton.setBounds(20, 600, 200, 40);
        reportCrimePanel.add(submitButton);

        JButton clearButton = new JButton("Clear Fields");
        clearButton.setBounds(240, 600, 200, 40);
        reportCrimePanel.add(clearButton);

        JLabel confirmationLabel = new JLabel("Report submitted successfully!");
        confirmationLabel.setForeground(Color.GREEN);
        confirmationLabel.setBounds(20, 660, 400, 30);
        confirmationLabel.setVisible(false);
        reportCrimePanel.add(confirmationLabel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String contact = contactField.getText().trim();
                String crimeType = (String) crimeTypeCombo.getSelectedItem();
                String date = dateField.getText().trim();
                String location = locationField.getText().trim();
                String description = descriptionArea.getText().trim();

                String dbUrl = "jdbc:mysql://localhost:3306/police";
                String dbUser = "root";
                String dbPassword = "root";

                String query = "INSERT INTO complaints (name, contact, crime, date, location, description) VALUES (?, ?, ?, ?, ?, ?)";

                try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                     PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, contact);
                    preparedStatement.setString(3, crimeType);
                    preparedStatement.setString(4, date);
                    preparedStatement.setString(5, location);
                    preparedStatement.setString(6, description);

                    int rowsInserted = preparedStatement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(reportCrimePanel, "Report submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        confirmationLabel.setVisible(true);

                        nameField.setText("");
                        contactField.setText("");
                        crimeTypeCombo.setSelectedIndex(0);
                        dateField.setText("YYYY-MM-DD");
                        locationField.setText("");
                        descriptionArea.setText("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(reportCrimePanel, "Error submitting the report!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(e -> {
            nameField.setText("");
            contactField.setText("");
            crimeTypeCombo.setSelectedIndex(0);
            dateField.setText("YYYY-MM-DD");
            locationField.setText("");
            descriptionArea.setText("");
            confirmationLabel.setVisible(false);
        });

        return reportCrimePanel;
    }
}

