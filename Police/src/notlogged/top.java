package notlogged;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clieant.profile;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
public class top {
    private JPanel container;
    private CardLayout cards;
    private String username;
    
    private String loggedInUsername;
    private String getUserData;
    public top(JPanel container, CardLayout cards, String username,String loggedInUsername) {
        this.container = container;
        this.cards = cards;
        this.loggedInUsername = loggedInUsername; 
    }

    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    public String[] getUserData(String username) {
        String[] userData = new String[2]; 
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
               connection = DatabaseConnection.getConnection();

            String query = "SELECT username, email FROM user_data WHERE username = ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                userData[0] = rs.getString("username");  
                userData[1] = rs.getString("email");  
            } else {
                userData[0] = "Name not found"; 
                userData[1] = "Email not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            userData[0] = "Error";
            userData[1] = "Error";
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return userData;
    }
        /**
         * @wbp.parser.entryPoint
         */
        public JPanel getPanel() {
      JPanel top = new JPanel();
      top.setBorder(null);
        
     top.setBounds(0, 0, 1000, 50);
     top.setBackground(new Color(128, 128, 128));
    top.setLayout(null);
     JButton profileButton = new JButton();
     profileButton.setForeground(new Color(128, 128, 128));
     profileButton.setBackground(new Color(128, 128, 128));
     profileButton.setBounds(912, 0, 54, 50);
     profileButton.setPreferredSize(new Dimension(30, 30));
     profileButton.setContentAreaFilled(false);
     profileButton.setFocusPainted(false);
     profileButton.setBorder(null);


    
     
     ImageIcon icon = new ImageIcon("po1.png");
     Image img = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
     profileButton.setIcon(new ImageIcon(img));

     profileButton.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	     
    	        
    	        cards.show(container, "profile");
    	    }
    	});


     
     JLabel faqLabel = new JLabel("FAQ");
     faqLabel.setForeground(Color.WHITE);
     faqLabel.setBounds(10, 380, 150, 25);
     top.add(faqLabel);

     JButton btnFAQ = new JButton("FAQ");
     btnFAQ.setForeground(new Color(0, 0, 0));
     btnFAQ.setBackground(new Color(113, 113, 113));
     btnFAQ.setFont(new Font("Tahoma", Font.ITALIC, 15));
     btnFAQ.setBounds(684, 13, 76, 30);
     top.add(btnFAQ);
     btnFAQ.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             cards.show(container, "faq");
         }
     });
     
     
     JButton btnLogin = new JButton("Log-in");
    
     btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 16));
     btnLogin.setBackground(new Color(113, 113, 113));
     btnLogin.setBounds(790, 13, 95, 30);
     btnLogin.setFocusable(false);

     top.add(btnLogin);
     btnLogin.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             cards.show(container, "login");
         }
     });
 
     
     top.add(profileButton);
     
     JLabel lblNewLabel = new JLabel("Citizen's Corner");
     lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
     lblNewLabel.setBounds(105, 10, 200, 31);
     top.add(lblNewLabel);
     ImageIcon ikona = new ImageIcon("po.png");
     Image ikona1 = ikona.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 

     JLabel lblNewLabel_1 = new JLabel();
     lblNewLabel_1.setIcon(new ImageIcon(ikona1)); 

     lblNewLabel_1.setBounds(30, 10, 95, 50);

     top.add(lblNewLabel_1);

     return top;
     
    }
}
