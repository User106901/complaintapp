// Package Declaration
package clieant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import notlogged.DatabaseConnection;
import notlogged.UserSession;

public class profile {
    private JPanel clientcontainer;
    private CardLayout clientcards;
    public String loggedInUsername;
    private JTextField textField;
    private JTable table;
    private JTable task;
    private JTable table_1;
    private JPasswordField passwordField;
    private JLabel lblNewLabel_4;  
    private JLabel lblNewLabel_5;
    public profile(JPanel clientcontainer, CardLayout clientcards, String loggedInUsername) {
        this.clientcontainer = clientcontainer;
        this.clientcards = clientcards;
        this.loggedInUsername = loggedInUsername;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        String dbUrl = "jdbc:mysql://localhost:3306/police";
        String dbUser = "root";
        String dbPassword = "root";

        
        JLabel headerLabel = new JLabel("Citizen Profile");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBounds(50, 10, 200, 40);
        panel.add(headerLabel);

       
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(50, 80, 73, 30);
        panel.add(nameLabel);

     

       
     


        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 120, 56, 30);
        panel.add(emailLabel);

      
        JSeparator separator = new JSeparator();
        separator.setBounds(50, 230, 349, 10);
        panel.add(separator);

       
        DefaultTableModel complaintsTableModel = new DefaultTableModel(new String[]{"Complain Text", "Location"}, 0);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_6.setBounds(116, 89, 104, 21);  
        panel.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_7.setBounds(116, 120, 104, 21);  
        panel.add(lblNewLabel_7);

       
        JButton btnNewButton_3 = new JButton("Show User Info");
        btnNewButton_3.setBounds(50, 166, 63, 21); 
        panel.add(btnNewButton_3);

        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recentUsername = UserSession.getInstance().getUsername();
                if (recentUsername != null && !recentUsername.isEmpty()) {
                    
                    String query = "SELECT username, email FROM user_data WHERE username = ?";

                    try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                        preparedStatement.setString(1, recentUsername);  
                        System.out.println("Executing query: " + query);   

                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            if (resultSet.next()) {
                                String username = resultSet.getString("username");
                                String email = resultSet.getString("email");

                                
                                System.out.println(username);
                                System.out.println(email);

                                if (email != null) {
                                    lblNewLabel_7.setText(email); 
                                } else {
                                    lblNewLabel_7.setText("Email not available.");
                                }

                                lblNewLabel_6.setText(username);  
                            } else {
                                JOptionPane.showMessageDialog(panel, "No data found for the logged-in user.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(panel, "Database connection error!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "No recent login found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel lblNewLabel = new JLabel("Change Password");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(32, 250, 144, 30);
        panel.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(132, 290, 118, 30);
        panel.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Old Password:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(32, 287, 96, 31);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_4 = new JLabel();
        JLabel lblNewLabel_5 = new JLabel();
        
        
        lblNewLabel_4.setBounds(200, 10, 200, 30);
        lblNewLabel_5.setBounds(200, 40, 200, 30);
        
        JLabel lblNewLabel_2 = new JLabel("New Password:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(32, 332, 96, 21);
        panel.add(lblNewLabel_2);
        
        DefaultTableModel tableModel1 = new DefaultTableModel(new String[]{"Task", "Description"}, 0);

        ImageIcon pf = new ImageIcon("pfp.png");
        Image p1 = pf.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel pfp = new JLabel(new ImageIcon(p1));
        pfp.setBounds(495, 101, 168, 180);
        panel.add(pfp);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(new Color(128, 128, 128));
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setForeground(new Color(255, 255, 255));
        separator_1.setBounds(421, 80, 10, 282);
        panel.add(separator_1);
        
        JLabel lblNewLabel_3 = new JLabel("Vullnetar Notifications:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(32, 429, 168, 30);
        panel.add(lblNewLabel_3);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(32, 409, 700, 10);
        panel.add(separator_2);
        
       
        JTextField textFieldpar = new JTextField(); 
        textFieldpar.setBounds(132, 290, 118, 30);
        panel.add(textFieldpar);
     

        passwordField = new JPasswordField();
        passwordField.setBounds(132, 330, 118, 30);
        panel.add(passwordField);
        
       
        JButton btnNewButton_4 = new JButton("Change");
        btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_4.setBounds(278, 334, 104, 26);
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
            	String oldPassword = textField.getText().trim();
            	String newPassword = passwordField.getText().trim();

            	
            	System.out.println("Old Password: '" + oldPassword + "'");
            	System.out.println("New Password: '" + newPassword + "'");

            	
            	if (oldPassword.isEmpty() || newPassword.isEmpty()) {
            	    JOptionPane.showMessageDialog(panel, "Please fill in both fields.", "Error", JOptionPane.ERROR_MESSAGE);
            	    return;
            	}

               
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/police", "root", "root")) {
                    
                    String query = "SELECT * FROM user_data WHERE username = ? AND password = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, UserSession.getInstance().getUsername());
                        preparedStatement.setString(2, oldPassword);

                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                           
                            String updateQuery = "UPDATE user_data SET password = ? WHERE username = ?";
                            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                                updateStatement.setString(1, newPassword);
                                updateStatement.setString(2, UserSession.getInstance().getUsername());

                                int rowsUpdated = updateStatement.executeUpdate();
                                if (rowsUpdated > 0) {
                                    JOptionPane.showMessageDialog(panel, "Password updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(panel, "Failed to update password.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(panel, "Old password is incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel, "Database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(btnNewButton_4);
        
        JTable table = new JTable();
        table.setBounds(50, 100, 800, 200);
        panel.add(table);

        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(32, 474, 309, 180);
        panel.add(scrollPane);

        
        JButton btnShow = new JButton("Show Tasks");
        btnShow.setBounds(386, 624, 150, 30);
        panel.add(btnShow);

        
        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String loggedInUsername = UserSession.getInstance().getUsername();

                if (loggedInUsername == null || loggedInUsername.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "No user is currently logged in.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String emailQuery = "SELECT email FROM user_data WHERE username = ?";
                String taskQuery = "SELECT task, description FROM ivullnetar WHERE gmail = ?";

                try  (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                     PreparedStatement emailStatement = connection.prepareStatement(emailQuery)) {

                    emailStatement.setString(1, loggedInUsername);
                    ResultSet emailResultSet = emailStatement.executeQuery();

                    if (emailResultSet.next()) {
                        String userEmail = emailResultSet.getString("email");
                        System.out.println("Retrieved Gmail: " + userEmail);
                        try (PreparedStatement taskStatement = connection.prepareStatement(taskQuery)) {
                            taskStatement.setString(1, userEmail);
                            ResultSet taskResultSet = taskStatement.executeQuery();

                           
                            DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Task", "Description"}, 0);
                            table.setModel(tableModel);

                            boolean dataFound = false;
                            while (taskResultSet.next()) {
                                String task = taskResultSet.getString("task");
                                String description = taskResultSet.getString("description");
                                tableModel.addRow(new Object[]{task, description});
                                dataFound = true;
                            }

                            if (!dataFound) {
                                JOptionPane.showMessageDialog(panel, "No tasks found for this Gmail.", "No Data", JOptionPane.INFORMATION_MESSAGE);
                            }

                        } catch (SQLException taskEx) {
                            taskEx.printStackTrace();
                            JOptionPane.showMessageDialog(panel, "Error retrieving tasks!", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(panel, "No Gmail found for the logged-in user.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel, "Database connection error!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(btnShow);
        
        JLabel lblNewLabel_8 = new JLabel("<html>Your profile is where your voice begins.<br>Manage your details, track your complaints, and stay informed with every step of the process.</html>");
        lblNewLabel_8.setForeground(new Color(128, 128, 128));
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_8.setBounds(441, 312, 372, 63);
        panel.add(lblNewLabel_8);

        
            
        

        return panel;
    }
   
    
    public  JLabel getLblNewLabel_4() {
        return getLblNewLabel_4();  
    }

    public  JLabel getLblNewLabel_5() {
        return getLblNewLabel_5();  
    }

    public void setLoggedInUsername(String username) {
        this.loggedInUsername = username;
    }

    public String getLoggedInUsername() {
        return loggedInUsername;
    }
}
