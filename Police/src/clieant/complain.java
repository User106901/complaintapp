package clieant;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class complain {
    private JPanel container;
    private CardLayout cards;
    private String username;

    public complain(JPanel container, CardLayout cards, String username) {
        this.container = container;
        this.cards = cards;

        if (username == null || username.isEmpty()) {
            this.username = "defaultUser";
        } else {
            this.username = username;
        }
    }

    public JPanel getPanel() {
        JPanel complainPanel = new JPanel();
        complainPanel.setLayout(null);
        complainPanel.setBounds(200, 50, 800, 750);
        complainPanel.setBackground(new Color(192, 192, 192));

        JLabel titleLabel = new JLabel("Submit a Complaint");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(0, 0, 0));
        titleLabel.setBounds(70, 22, 400, 50);
        complainPanel.add(titleLabel);

        JLabel complainLabel = new JLabel("Complaint:");
        complainLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        complainLabel.setBounds(47, 94, 96, 30);
        complainPanel.add(complainLabel);

        JTextField complainText = new JTextField();
        complainText.setBounds(170, 96, 269, 30);
        complainText.setFont(new Font("Arial", Font.PLAIN, 14));
        complainPanel.add(complainText);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setBounds(47, 168, 108, 30);
        complainPanel.add(descriptionLabel);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        locationLabel.setBounds(50, 295, 96, 30);
        complainPanel.add(locationLabel);

        JTextField locationText = new JTextField();
        locationText.setBounds(170, 297, 193, 30);
        locationText.setFont(new Font("Arial", Font.PLAIN, 14));
        complainPanel.add(locationText);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timeLabel.setBounds(47, 359, 66, 30);
        complainPanel.add(timeLabel);

        JTextField timeText = new JTextField();
        timeText.setBounds(170, 361, 200, 30);
        timeText.setFont(new Font("Arial", Font.PLAIN, 14));
        complainPanel.add(timeText);

        JLabel imageLabel = new JLabel("Attach an Image:");
        imageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        imageLabel.setBounds(47, 423, 120, 30);
        complainPanel.add(imageLabel);

        JButton uploadImageButton = new JButton("->");
        uploadImageButton.setBounds(170, 419, 66, 40);
        uploadImageButton.setFont(new Font("Arial", Font.BOLD, 14));
        uploadImageButton.setBackground( Color.gray);
        uploadImageButton.setForeground(Color.WHITE);
        complainPanel.add(uploadImageButton);

        JLabel imagePathLabel = new JLabel("No file selected");
        imagePathLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        imagePathLabel.setBounds(170, 480, 280, 30);
        imagePathLabel.setForeground(Color.DARK_GRAY);
        complainPanel.add(imagePathLabel);

        uploadImageButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(complainPanel);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                imagePathLabel.setText(selectedFile.getName());
            }
        });

        JButton submitButton = new JButton("Submit Complaint");
        submitButton.setBounds(47, 660, 138, 30);
        submitButton.setBackground(new Color(73, 83, 86));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        complainPanel.add(submitButton);
        
        JButton clearButton = new JButton("Clear Fields");
        clearButton.setBounds(282, 660, 146, 30);
        clearButton.setBackground(new Color(73, 83, 86));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        complainPanel.add(clearButton);

        JLabel statusLabel = new JLabel("");
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        statusLabel.setForeground(new Color(0, 0, 0));
        statusLabel.setBounds(10, 507, 232, 30);
        complainPanel.add(statusLabel);
                
        JCheckBox chckbxNewCheckBox = new JCheckBox("High");
        chckbxNewCheckBox.setBackground(new Color(192, 192, 192));
        chckbxNewCheckBox.setBounds(506, 366, 93, 21);
        complainPanel.add(chckbxNewCheckBox);
                
        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Medium");
        chckbxNewCheckBox_1.setBackground(new Color(192, 192, 192));
        chckbxNewCheckBox_1.setBounds(506, 404, 93, 21);
        complainPanel.add(chckbxNewCheckBox_1);
                
        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Low");
        chckbxNewCheckBox_2.setBackground(new Color(192, 192, 192));
        chckbxNewCheckBox_2.setBounds(506, 447, 93, 21);
        complainPanel.add(chckbxNewCheckBox_2);
                
        JLabel lblNewLabel = new JLabel("Importent Notice\r\n");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel.setBounds(506, 306, 179, 40);
        complainPanel.add(lblNewLabel);
                
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setForeground(new Color(73, 83, 86));
        separator.setBackground(new Color(73, 83, 86));
        separator.setBounds(462, 295, 8, 241);
        complainPanel.add(separator);
                
        JLabel complaintImportanceLabel = new JLabel("<html>Complaining is important because it helps highlight issues that need attention, fosters communication, and can lead to positive change. By expressing concerns, individuals ensure that problems are addressed, leading to better solutions, improved services, and a stronger sense of accountability in various systems.</html>");
        complaintImportanceLabel.setForeground(new Color(73, 83, 86));
        complaintImportanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        complaintImportanceLabel.setBounds(30, 534, 620, 100);
        complainPanel.add(complaintImportanceLabel);
                
        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(new Color(73, 83, 86));
        separator_1.setBounds(30, 631, 705, 18);
        complainPanel.add(separator_1);
                
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setBounds(170, 173, 280, 100);
        complainPanel.add(descriptionArea);
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String complain = null;
                if (chckbxNewCheckBox.isSelected()) {
                    complain = "High";
                } else if (chckbxNewCheckBox_1.isSelected()) {
                    complain = "Medium";
                } else if (chckbxNewCheckBox_2.isSelected()) {
                    complain = "Low";
                }

                String description = descriptionArea.getText();
                String location = locationText.getText();
                String time = timeText.getText();

                if (complain != null && !complain.isEmpty() && !description.isEmpty() && !location.isEmpty() && !time.isEmpty()) {
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/police", "root", "root")) {
                        String sql = "INSERT INTO complaints (type, complain_text, description, location, time, username) VALUES (?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                            stmt.setString(1, complain);
                            stmt.setString(2, complainText.getText());
                            stmt.setString(3, description);
                            stmt.setString(4, location);
                            stmt.setString(5, time);
                            stmt.setString(6, username);

                            int rowsInserted = stmt.executeUpdate();
                            if (rowsInserted > 0) {
                                statusLabel.setText("Complaint submitted successfully!");
                                complainText.setText("");
                                descriptionArea.setText("");
                                locationText.setText("");
                                timeText.setText("");
                                imagePathLabel.setText("No file selected");
                            }
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(complainPanel, "Error: " + ex.getMessage());
                    }
                } else {
                    statusLabel.setText("Please fill all the fields correctly.");
                }
            }
        });

        clearButton.addActionListener(e -> {
            complainText.setText("");
            descriptionArea.setText("");
            locationText.setText("");
            timeText.setText("");
            imagePathLabel.setText("No file selected");
            statusLabel.setText("");
        });

        return complainPanel;
    }
}


