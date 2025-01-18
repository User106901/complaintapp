package notlogged;

import javax.swing.*;
import clieant.Butonclient;
import clieant.complain;
import clieant.mainiclient;
import clieant.shumbtn;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import policepac.pButona;

public class login {
    private JPanel panel;
    private JPanel container;
    private CardLayout cards;
    private JPanel sidebar;
    private CardLayout sideCards;
    private JButton btnLogin; 
   
    public static String loggedInUsername;

    public login(JPanel container, CardLayout cards, JPanel sidebar, CardLayout sideCards, String loggedInUsername2) {
        this.container = container;
        this.cards = cards;
        this.sidebar = sidebar;
        this.sideCards = sideCards;
        this.loggedInUsername = loggedInUsername2;
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(200, 0, 840, 800); 
        panel.setBackground(new Color(255, 255, 255));

        JLabel titleLabel = new JLabel("Login Portal");
        titleLabel.setFont(new Font("Segoe UI", Font.ITALIC, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(114, 20, 223, 56);
        titleLabel.setForeground(new Color(50, 50, 50));
        panel.add(titleLabel);

        
        ImageIcon imageIcon = new ImageIcon("log1.png");
        Image image = imageIcon.getImage().getScaledInstance(400, 750, Image.SCALE_SMOOTH); 
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(422, -22, 408, 790); 
        panel.add(imageLabel);
                                                                                
        ImageIcon myImageIcon = new ImageIcon("logu.jpg"); 
        Image scaledImage = myImageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon = new ImageIcon(scaledImage); 

        JLabel myImageLabel = new JLabel(); 
        myImageLabel.setIcon(scaledIcon);   
        myImageLabel.setBounds(24, 20, 80, 63); 

        panel.add(myImageLabel); 
                                                           
                                        JLabel quoteLabel = new JLabel("\"Your security is our priority!\"");
                                        quoteLabel.setBounds(74, 510, 200, 30);
                                         panel.add(quoteLabel);
                                             quoteLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
                                                  quoteLabel.setForeground(new Color(100, 100, 100));
                                                                                        
         JTextField userText = new JTextField();
            userText.setBounds(100, 161, 136, 31);
            panel.add(userText);
                                                                                                userText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                                                                                                userText.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
                                                                                                userText.setBackground(Color.WHITE);
                                                                                                
                                                                                                        JPasswordField passwordText = new JPasswordField();
                                                                                                        passwordText.setBounds(100, 241, 136, 30);
                                                                                                        panel.add(passwordText);
                                                                                                        passwordText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                                                                                                        passwordText.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
                                                                                                        passwordText.setBackground(Color.WHITE);
                                                                                                        
                                                                                                                JTextField pinText = new JTextField();
                                                                                                                pinText.setBounds(100, 391, 136, 30);
                                                                                                                panel.add(pinText);
                                                                                                                pinText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                                                                                                                pinText.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
                                                                                                                pinText.setBackground(Color.WHITE);
                                                                                                                
                                                                                                                        
                                                                                                                        JButton loginButton = new JButton("Login");
                                                                                                                        loginButton.setBounds(284, 412, 128, 30);
                                                                                                                        panel.add(loginButton);
                                                                                                                        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
                                                                                                                        loginButton.setBackground(new Color(169, 169, 169)); 
                                                                                                                        loginButton.setForeground(Color.WHITE);
                                                                                                                        loginButton.setBorder(BorderFactory.createLineBorder(new Color(140, 140, 140)));
                                                                                                                        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                                                                                                        loginButton.setFocusPainted(false);
                                                                                                                        
                                                                                                                                JTextField roleText = new JTextField();
                                                                                                                                roleText.setBounds(100, 311, 136, 30);
                                                                                                                                panel.add(roleText);
                                                                                                                                roleText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                                                                                                                                roleText.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
                                                                                                                                roleText.setBackground(Color.WHITE);
                                                                                                                                
                                                                                                                                        
                                                                                                                                        JLabel pinLabel = new JLabel("4-digit PIN:");
                                                                                                                                        pinLabel.setBounds(100, 361, 80, 30);
                                                                                                                                        panel.add(pinLabel);
                                                                                                                                        pinLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                                                                                                                                        pinLabel.setForeground(new Color(80, 80, 80));
                                                                                                                                        
                                                                                                                                               
                                                                                                                                                JLabel roleLabel = new JLabel("Role :");
                                                                                                                                                roleLabel.setBounds(100, 283, 63, 30);
                                                                                                                                                panel.add(roleLabel);
                                                                                                                                                roleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                                                                                                                                                roleLabel.setForeground(new Color(80, 80, 80));
                                                                                                                                                
                                                                                                                                                
                                                                                                                                                JLabel userLabel = new JLabel("Username:");
                                                                                                                                                userLabel.setBounds(100, 129, 80, 30);
                                                                                                                                                panel.add(userLabel);
                                                                                                                                                userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                                                                                                                                                userLabel.setForeground(new Color(80, 80, 80));
                                                                                                                                                
                                                                                                                                                      
                                                                                                                                                        JLabel passwordLabel = new JLabel("Password:");
                                                                                                                                                        passwordLabel.setBounds(100, 212, 85, 30);
                                                                                                                                                        panel.add(passwordLabel);
                                                                                                                                                        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                                                                                                                                                        passwordLabel.setForeground(new Color(80, 80, 80));
                                                                                                                                                        
                                                                                                                                                        JButton btnNewButton = new JButton("Register?");
                                                                                                                                                        btnNewButton.setBackground(new Color(168, 168, 168));
                                                                                                                                                        btnNewButton.addActionListener(new ActionListener() {
                                                                                                                                                        	public void actionPerformed(ActionEvent e) {
                                                                                                                                                        	      cards.show(container, "register");
                                                                                                                                                        	}
                                                                                                                                                        });
                                                                                                                                                        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
                                                                                                                                                        btnNewButton.setBounds(284, 464, 128, 30);
                                                                                                                                                        panel.add(btnNewButton);
                loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        loginButton.setBackground(new Color(150, 150, 150));
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        loginButton.setBackground(new Color(169, 169, 169)); 
                    }
                });
                loginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        String username = userText.getText();
                        String password = new String(passwordText.getPassword());
                        String role = roleText.getText().trim().toLowerCase();
                        String pin = pinText.getText().trim();

                        try (Connection connection = DatabaseConnection.getConnection()) {
                            PreparedStatement stmt;
                            ResultSet resultSet;

                        
                            if (role.equals("police") && pin.equals("1111")) {
                                String sql = "SELECT * FROM user_data WHERE username = ? AND password = ?";
                                stmt = connection.prepareStatement(sql);
                                stmt.setString(1, username);
                                stmt.setString(2, password);
                                resultSet = stmt.executeQuery();
                            } else {
                               
                                String sql = "SELECT * FROM user_data WHERE username = ? AND password = ?";
                                stmt = connection.prepareStatement(sql);
                                stmt.setString(1, username);
                                stmt.setString(2, password);
                                resultSet = stmt.executeQuery();
                            }

                            if (resultSet.next()) {
                               
                                UserSession.getInstance().setUsername(username); 
                                System.out.println("Logged in as: " + username);
                                userText.setText("");  
                                passwordText.setText(""); 
                                roleText.setText("");  
                                pinText.setText(""); 
                                
                                saveLoginToDatabase(username);  

                                
                                if (role.equals("police") && pin.equals("1111")) {
                                    kreu kreuPanel = new kreu(container, cards);
                                    JScrollPane kreuPanelComponent = kreuPanel.getPanel();

                                    container.add(kreuPanelComponent, "kreu");

                                    pButona policeSidebar = new pButona(container, cards, null, sideCards, null);
                                    JPanel policeSidebarPanel = policeSidebar.getPanel();

                                    sidebar.add(policeSidebarPanel, "pButona");
                                    sideCards.show(sidebar, "pButona");
                                    cards.show(container, "kreu");
                                } else {
                                    Butonclient clientSidebar = new Butonclient(container, cards, sidebar, sideCards);
                                    JPanel clientSidebarPanel = clientSidebar.getPanel();

                                    mainiclient mainClient = new mainiclient(container, cards);
                                    JPanel mainClientPanel = mainClient.getPanel();
                                
                                    complain complainPanel = new complain(container, cards, UserSession.getInstance().getUsername());
                                    JPanel complainPanelComponent = complainPanel.getPanel();
                                   
                                    shumbtn shumbtnPanel = new shumbtn(container, sideCards, UserSession.getInstance().getUsername());  // Use getUsername() to fetch the username
                                    container.add(shumbtnPanel.getPanel(), "Shumbtn"); 
                                    cards.show(container, "Shumbtn"); 

                                    sidebar.add(clientSidebarPanel, "Butonclient");
                                    container.add(mainClientPanel, "mainiclient");
                                    container.add(complainPanelComponent, "complain");
                          
                                    sideCards.show(sidebar, "Butonclient");
                                    cards.show(container, "kreu");
                                    
                                    top topi = new top(container, cards, null, loggedInUsername2); 
                                }
                            } else {
                                JOptionPane.showMessageDialog(panel, "Invalid username or password.");
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(panel, "Error connecting to the database.");
                        }
                    }

                    
                    private void saveLoginToDatabase(String username) {
                        String query = "INSERT INTO login_history (username, login_time) VALUES (?, NOW())";
                        try (Connection connection = DatabaseConnection.getConnection();
                             PreparedStatement stmt = connection.prepareStatement(query)) {

                            stmt.setString(1, username);
                            stmt.executeUpdate();
                            System.out.println("Login history saved for user: " + username);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }

                });
    }

    public JPanel getPanel() {
        return panel;
    }


    public static String getLoggedInUsername() {
        return loggedInUsername;
    }
}

