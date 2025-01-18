package notlogged;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class register {
    private JPanel container;
    private CardLayout cards;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;

    public register(JPanel container, CardLayout cards) {
        this.container = container;
        this.cards = cards;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null); 
        panel.setBackground(new Color(113, 113, 113)); 
        panel.setPreferredSize(new Dimension(1002, 698)); 

        
        JLabel titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setBounds(32, 20, 200, 50); 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(50, 50, 50));
        panel.add(titleLabel);

        
        ImageIcon imageIcon = new ImageIcon("sw.jpg");
        Image image = imageIcon.getImage().getScaledInstance(400, 750, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(297, 0, 587, 713); 
        panel.add(imageLabel);
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBackground(new Color(128, 128, 128));
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        usernameLabel.setForeground(new Color(0, 0, 0));
        usernameLabel.setBounds(50, 126, 100, 30); 
        panel.add(usernameLabel);

        
        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameField.setBounds(71, 166, 160, 30); 
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        usernameField.setBackground(Color.WHITE);
        panel.add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        emailLabel.setForeground(new Color(0, 0, 0));
        emailLabel.setBounds(50, 206, 100, 30); 
        panel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setBounds(71, 246, 160, 30); 
        emailField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        emailField.setBackground(Color.WHITE);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passwordLabel.setForeground(new Color(0, 0, 0));
        passwordLabel.setBounds(50, 286, 100, 30); 
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setBounds(71, 326, 160, 30);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        passwordField.setBackground(Color.WHITE);
        panel.add(passwordField);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        registerButton.setBounds(172, 388, 115, 30); 
        registerButton.setBackground(new Color(169, 169, 169)); 
        registerButton.setForeground(new Color(0, 0, 0));
        registerButton.setBorder(BorderFactory.createLineBorder(new Color(140, 140, 140)));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setFocusPainted(false);
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButton.setBackground(new Color(150, 150, 150)); 
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerButton.setBackground(new Color(169, 169, 169));
            }
        });
        panel.add(registerButton);

        
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        loginButton.setBounds(172, 441, 115, 30); 
        loginButton.setBackground(new Color(200, 200, 200));
        loginButton.setForeground(Color.BLACK);
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setFocusPainted(false);
        panel.add(loginButton);
        
        JLabel lblNewLabel = new JLabel("Register now to access exclusive features!");
        lblNewLabel.setForeground(new Color(153, 153, 153));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(61, 523, 270, 30);
        panel.add(lblNewLabel);

      
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                String username = usernameField.getText();
                String email = emailField.getText();  
                String password = new String(passwordField.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean userAdded = addUserToDatabase(username, password, email);
                    if (userAdded) {
                        JOptionPane.showMessageDialog(panel, "Registration successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                        usernameField.setText("");  
                        emailField.setText("");     
                        passwordField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(panel, "User registration failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "login");
            }
        });

        return panel;
    }

    private boolean addUserToDatabase(String username, String password, String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
        	 connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO user_data (username, password, email) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password); 
            preparedStatement.setString(3, email);

           
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true; 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false; 
    }

}
