package notlogged;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

import clieant.article;
public class vullnetar {
    private JPanel container;
    private CardLayout cards;

    public vullnetar(JPanel container, CardLayout cards) {
        this.container = container;
        this.cards = cards;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(192, 192, 192));

        JLabel headerLabel = new JLabel("Join Us in Making Our Community Safer!");
        headerLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        headerLabel.setForeground(new Color(50, 50, 50)); 
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setBounds(50, 10, 577, 40); 
        panel.add(headerLabel);

       
        JLabel quoteLabel = new JLabel("\"The best way to predict the future is to create it.\" - Abraham Lincoln");
        quoteLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        quoteLabel.setForeground(new Color(120, 120, 120));
        quoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quoteLabel.setBounds(50, 69, 500, 30); 
        panel.add(quoteLabel);

        
        JLabel subheaderLabel = new JLabel("<html>Your information can play a vital role in ensuring safety.<br>" +
                "By volunteering or reporting incidents, you help the police serve better.<br>" +
                "Every small detail matters. Together, we can make a difference!</html>");
        subheaderLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subheaderLabel.setForeground(new Color(100, 100, 100));
        subheaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        subheaderLabel.setBounds(50, 109, 500, 80); 
        panel.add(subheaderLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(50, 199, 500, 10);
        panel.add(separator);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameLabel.setBounds(50, 247, 150, 20); 
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 243, 250, 30); 
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField.setForeground(new Color(50, 50, 50)); 
        nameField.setBackground(new Color(240, 240, 240)); 
        nameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); 
        panel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailLabel.setBounds(50, 287, 150, 20);
        panel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(200, 283, 250, 30);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setForeground(new Color(50, 50, 50));
        emailField.setBackground(new Color(240, 240, 240));
        emailField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(emailField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        ageLabel.setBounds(50, 327, 150, 20);
        panel.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(200, 323, 250, 30);
        ageField.setFont(new Font("Arial", Font.PLAIN, 14));
        ageField.setForeground(new Color(50, 50, 50));
        ageField.setBackground(new Color(240, 240, 240));
        ageField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(ageField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        addressLabel.setBounds(50, 367, 150, 20);
        panel.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(200, 363, 250, 30);
        addressField.setFont(new Font("Arial", Font.PLAIN, 14));
        addressField.setForeground(new Color(50, 50, 50));
        addressField.setBackground(new Color(240, 240, 240));
        addressField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(addressField);

        JSeparator separator2 = new JSeparator();
        separator2.setBounds(50, 412, 500, 10);
        panel.add(separator2);

        JButton submitButton = new JButton("Submit Your Info-->");
        submitButton.setBounds(485, 363, 158, 30);
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String ageText = ageField.getText().trim();
                String address = addressField.getText().trim();

                if (name.isEmpty() || email.isEmpty() || ageText.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int age = Integer.parseInt(ageText);

                    Connection conn = DatabaseConnection.getConnection();
                    String sql = "INSERT INTO volunteers (name, email, age, address) VALUES (?, ?, ?, ?)";
                    PreparedStatement statement = conn.prepareStatement(sql);

                    statement.setString(1, name);
                    statement.setString(2, email);
                    statement.setInt(3, age);
                    statement.setString(4, address);

                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(panel, "Information submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        nameField.setText("");
                        emailField.setText("");
                        ageField.setText("");
                        addressField.setText("");
                    }

                    statement.close();
                    conn.close();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Age must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel, "Error saving data to the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        nameField.setToolTipText("Enter your full name.");
        emailField.setToolTipText("Enter a valid email address.");
        ageField.setToolTipText("Enter your age.");
        addressField.setToolTipText("Enter your full address.");

        JLabel infoHeader = new JLabel("Why Should You Volunteer?");
        infoHeader.setFont(new Font("Verdana", Font.BOLD, 18));
        infoHeader.setForeground(new Color(50, 50, 50)); 
        infoHeader.setHorizontalAlignment(SwingConstants.CENTER);
        infoHeader.setBounds(-61, 432, 500, 30);
        panel.add(infoHeader);

        JTextArea infoText = new JTextArea();
        infoText.setText("• Contribute to the safety of your community.\n" +
                         "• Help the police in crime prevention.\n" +
                         "• Be a part of a meaningful cause.\n" +
                         "• Make your neighborhood a better place.\n" +
                         "• Gain valuable experience and skills.\n");
        infoText.setFont(new Font("Arial", Font.PLAIN, 17));
        infoText.setForeground(new Color(80, 80, 80));
        infoText.setBackground(new Color(192, 192, 192));
        infoText.setEditable(false);
        infoText.setWrapStyleWord(true);
        infoText.setLineWrap(true);
        infoText.setBounds(36, 493, 363, 130);
        panel.add(infoText);

        
        JButton learnMoreButton = new JButton("Learn More");
        learnMoreButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		article.openWebpage("https://www.helpguide.com");
        	}
        });
        learnMoreButton.setFont(new Font("Arial", Font.PLAIN, 14));
        learnMoreButton.setForeground(Color.WHITE);
        learnMoreButton.setBackground(new Color(70, 130, 180)); 
        learnMoreButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); 
        learnMoreButton.setFocusPainted(false); 
        learnMoreButton.setBounds(36, 633, 150, 40); 
        panel.add(learnMoreButton);
        
          
                JButton facebookButton = new JButton("Facebook");
                facebookButton.setForeground(new Color(255, 255, 255));
                facebookButton.setBackground(new Color(0, 64, 128));
                facebookButton.setBounds(472, 583, 100, 30);
                panel.add(facebookButton);
                facebookButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	
                            	 
                		article.openWebpage("https://www.facebook.com"); }
                       
                });
                facebookButton.setFont(new Font("Arial", Font.PLAIN, 12));
                
                        JButton twitterButton = new JButton("Twitter");
                        twitterButton.setForeground(new Color(255, 255, 255));
                        twitterButton.setBackground(new Color(0, 64, 128));
                        twitterButton.setBounds(472, 639, 100, 30);
                        panel.add(twitterButton);
                        twitterButton.setFont(new Font("Arial", Font.PLAIN, 12));
                        twitterButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	
                       	 
                    		article.openWebpage("https://www.twitter.com"); }
    
                    });
                    
                                
                                JLabel contactLabel = new JLabel("Contact Us:");
                                contactLabel.setBounds(472, 454, 100, 20);
                                panel.add(contactLabel);
                                contactLabel.setFont(new Font("Arial", Font.BOLD, 14));
                                contactLabel.setForeground(new Color(50, 50, 50));
                                
                                        JTextArea contactInfo = new JTextArea();
                                        contactInfo.setBounds(460, 484, 300, 80);
                                        panel.add(contactInfo);
                                        contactInfo.setText("• Email: contact@volunteer.org\n" +
                                                            "• Phone: +123 456 789\n" +
                                                            "• Address: 123 Volunteer St.\n");
                                        contactInfo.setFont(new Font("Arial", Font.PLAIN, 16));
                                        contactInfo.setForeground(new Color(80, 80, 80));
                                        contactInfo.setBackground(new Color(192, 192, 192));
                                        contactInfo.setEditable(false);
                                        
                                        JSeparator separator_1 = new JSeparator();
                                        separator_1.setOrientation(SwingConstants.VERTICAL);
                                        separator_1.setBounds(414, 442, 10, 261);
                                        panel.add(separator_1);

        return panel;
    }
}

