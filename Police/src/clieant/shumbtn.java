package clieant;

import javax.swing.*;
import notlogged.DatabaseConnection;
import notlogged.login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class shumbtn {

    private JPanel clientcontainer;
    private CardLayout clientcards;
    private JTextField editNameField;
    private JTextField editEmailField;
    private JTextField editPhoneField;
    public String loggedInUsername;

   
    public shumbtn(JPanel clientcontainer, CardLayout clientcards, String loggedInUsername) {
        this.clientcontainer = clientcontainer;
        this.clientcards = clientcards;
        this.loggedInUsername = loggedInUsername; 
        System.out.println("shumbtn Constructor - loggedInUsername: " + loggedInUsername);
    }


    
    public JPanel getPanel() {
        JPanel panelpo = new JPanel();
        panelpo.setLayout(null);
        panelpo.setBackground(Color.white); 

        System.out.println("shumbtn is klassss ----> " + this.loggedInUsername);
        String lastLogin = getLastLoginTime(loggedInUsername);
        
        JLabel headerLabel = new JLabel("Welcome to the Dashboard");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBounds(200, 20, 300, 40);
        panelpo.add(headerLabel);

        
        JButton btn1 = new JButton("Safety & Tips");
        btn1.setBounds(50, 100, 150, 40);
        btn1.setFont(new Font("Arial", Font.PLAIN, 14));
        btn1.setBackground(Color.LIGHT_GRAY);
        btn1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        panelpo.add(btn1);

        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientcards.show(clientcontainer, "safetytips");
            }
        });

       


       
        JButton btn5q = new JButton("Police Stations");
        btn5q.setBounds(50, 260, 150, 40);
        btn5q.setFont(new Font("Arial", Font.PLAIN, 14));
        btn5q.setBackground(Color.LIGHT_GRAY);
        btn5q.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        panelpo.add(btn5q);

       
        btn5q.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientcards.show(clientcontainer, "locationpolicve");
            }
        });

 
        JSeparator separator = new JSeparator();
        separator.setBounds(50, 320, 350, 10);
        panelpo.add(separator);

        JLabel notificationLabel = new JLabel("Receive Notifications");
        notificationLabel.setFont(new Font("Arial", Font.BOLD, 14));
        notificationLabel.setBounds(50, 340, 200, 30);
        panelpo.add(notificationLabel);

      
        JCheckBox notificationCheckBox = new JCheckBox("Yes, I want notifications");
        notificationCheckBox.setBounds(50, 370, 200, 30);
        panelpo.add(notificationCheckBox);

        
        JLabel preferenceLabel = new JLabel("Notification Preference");
        preferenceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        preferenceLabel.setBounds(50, 400, 200, 30);
        panelpo.add(preferenceLabel);

        JRadioButton emailButton = new JRadioButton("Email");
        emailButton.setBounds(50, 430, 100, 30);
        JRadioButton smsButton = new JRadioButton("SMS");
        smsButton.setBounds(150, 430, 100, 30);
        ButtonGroup preferenceGroup = new ButtonGroup();
        preferenceGroup.add(emailButton);
        preferenceGroup.add(smsButton);
        panelpo.add(emailButton);
        panelpo.add(smsButton);

        
        JLabel serviceLabel = new JLabel("Select Service");
        serviceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        serviceLabel.setBounds(50, 470, 200, 30);
        panelpo.add(serviceLabel);

        String[] services = {"Customer Support", "Technical Assistance", "General Inquiry"};
        JComboBox<String> serviceComboBox = new JComboBox<>(services);
        serviceComboBox.setBounds(50, 500, 200, 30);
        panelpo.add(serviceComboBox);


        JLabel feedbackLabel = new JLabel("Feedback");
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 14));
        feedbackLabel.setBounds(50, 540, 200, 30);
        panelpo.add(feedbackLabel);

        JTextArea feedbackArea = new JTextArea();
        feedbackArea.setBounds(50, 570, 300, 100);
        panelpo.add(feedbackArea);

       
        JButton submitFeedbackButton = new JButton("Submit Feedback");
        submitFeedbackButton.setBounds(50, 680, 200, 40);

        
        submitFeedbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                boolean receiveNotifications = notificationCheckBox.isSelected();
                String notificationPreference = emailButton.isSelected() ? "Email" : smsButton.isSelected() ? "SMS" : "None";
                String selectedService = (String) serviceComboBox.getSelectedItem();
                String feedback = feedbackArea.getText();

               
                saveUserPreferences(receiveNotifications, notificationPreference, selectedService, feedback);
            }
        });

        panelpo.add(submitFeedbackButton);

        return panelpo;
    }

   
    private String getLastLoginTime(String username) {
        String lastLoginTime = "Never"; 
        String query = "SELECT login_time FROM login_history WHERE username = ? ORDER BY login_time DESC LIMIT 1";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                lastLoginTime = resultSet.getString("login_time");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return lastLoginTime; 
    }



	
    private void saveUserPreferences(boolean receiveNotifications, String notificationPreference, String selectedService, String feedback) {
        String dbUrl = "jdbc:mysql://localhost:3306/police";
        String dbUser = "root"; 
        String dbPassword = "root"; 

        String query = "INSERT INTO user_preferences (notifications, notification_preference, service, feedback) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

     
            preparedStatement.setBoolean(1, receiveNotifications);
            preparedStatement.setString(2, notificationPreference);
            preparedStatement.setString(3, selectedService);
            preparedStatement.setString(4, feedback);

          
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Saved user preferences successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    }

    public String getLoggedInUsername() {
        return loggedInUsername;
    }
}

