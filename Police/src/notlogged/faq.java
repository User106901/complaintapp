package notlogged;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class faq {
    private JPanel container;
    private CardLayout cards;

    public faq(JPanel container, CardLayout cards) {
        this.container = container;
        this.cards = cards;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JScrollPane getPanel() {
        
        JPanel panel = new JPanel();
        panel.setLayout(null); 
        panel.setBackground(new Color(235, 235, 235));
        panel.setPreferredSize(new Dimension(800, 1000)); 

       
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); 

     
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(70, 70, 70)); 
        titlePanel.setBounds(0, 0, 800, 50); 
        JLabel titleLabel = new JLabel("Frequently Asked Questions");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.white);
        titlePanel.add(titleLabel);
        panel.add(titlePanel);

        
        JLabel q1 = new JLabel("Q1: How do I file a complaint?");
        q1.setFont(new Font("Arial", Font.BOLD, 16));
        q1.setBounds(20, 60, 760, 30);
        panel.add(q1);

        JLabel a1 = new JLabel("A1: To file a complaint, go to the 'Submit Complaint' section in the app.");
        a1.setFont(new Font("Arial", Font.PLAIN, 14));
        a1.setBounds(20, 90, 590, 30);
        panel.add(a1);

        JLabel q2 = new JLabel("Q2: Can I remain anonymous when submitting a complaint?");
        q2.setFont(new Font("Arial", Font.BOLD, 16));
        q2.setBounds(20, 130, 760, 30);
        panel.add(q2);

        JLabel a2 = new JLabel("A2: Yes, you can submit a complaint anonymously by selecting the anonymous option.");
        a2.setFont(new Font("Arial", Font.PLAIN, 14));
        a2.setBounds(20, 160, 590, 30);
        panel.add(a2);

        JLabel q3 = new JLabel("Q3: What details should I include when filing a complaint?");
        q3.setFont(new Font("Arial", Font.BOLD, 16));
        q3.setBounds(20, 200, 760, 30);
        panel.add(q3);

        JLabel a3 = new JLabel("A3: Include information such as the nature of the complaint, location, date/time, and photos.");
        a3.setFont(new Font("Arial", Font.PLAIN, 14));
        a3.setBounds(20, 234, 590, 30);
        panel.add(a3);

        JLabel q4 = new JLabel("Q4: How do I track the status of my complaint?");
        q4.setFont(new Font("Arial", Font.BOLD, 16));
        q4.setBounds(20, 270, 760, 30);
        panel.add(q4);

        JLabel a4 = new JLabel("A4: You can track the status of your complaint in the 'My Complaints' section of the app.");
        a4.setFont(new Font("Arial", Font.PLAIN, 14));
        a4.setBounds(20, 300, 590, 30);
        panel.add(a4);

        JLabel q5 = new JLabel("Q5: How can I contact support for further help?");
        q5.setFont(new Font("Arial", Font.BOLD, 16));
        q5.setBounds(20, 340, 760, 30);
        panel.add(q5);

        JLabel a5 = new JLabel("A5: If you need further assistance, you can reach out via the 'Contact Support' section.");
        a5.setFont(new Font("Arial", Font.PLAIN, 14));
        a5.setBounds(20, 370, 590, 30);
        panel.add(a5);

        JLabel q6 = new JLabel("Q6: Can I edit or update my complaint after submitting?");
        q6.setFont(new Font("Arial", Font.BOLD, 16));
        q6.setBounds(20, 410, 760, 30);
        panel.add(q6);

        JLabel a6 = new JLabel("A6: Yes, you can update your complaint by visiting the 'My Complaints' section.");
        a6.setFont(new Font("Arial", Font.PLAIN, 14));
        a6.setBounds(20, 440, 590, 30);
        panel.add(a6);

        JLabel q7 = new JLabel("Q7: What should I do if I encounter issues with the app?");
        q7.setFont(new Font("Arial", Font.BOLD, 16));
        q7.setBounds(20, 480, 760, 30);
        panel.add(q7);

        JLabel a7 = new JLabel("A7: If you encounter any issues, please contact our support team using the 'Contact Support' section.");
        a7.setFont(new Font("Arial", Font.PLAIN, 14));
        a7.setBounds(20, 510, 652, 30);
        panel.add(a7);

      
        JLabel commentLabel = new JLabel("Your Comments/Suggestions:");
        commentLabel.setFont(new Font("Arial", Font.BOLD, 16));
        commentLabel.setBounds(20, 550, 300, 30);
        panel.add(commentLabel);

        JTextArea commentArea = new JTextArea();
        commentArea.setFont(new Font("Arial", Font.PLAIN, 14));
        commentArea.setBackground(new Color(240, 240, 240));
        commentArea.setBounds(20, 580, 671, 100);
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        commentArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(commentArea);

        
        JCheckBox helpfulCheckbox = new JCheckBox("Was this FAQ helpful?");
        helpfulCheckbox.setBounds(20, 700, 300, 30);
        helpfulCheckbox.setBackground(new Color(235, 235, 235));
        panel.add(helpfulCheckbox);

      
        JButton submitButton = new JButton("Submit Feedback");
        submitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		        String comment = commentArea.getText(); 
        		        boolean isHelpful = helpfulCheckbox.isSelected(); 
        		        insertFeedback(comment, isHelpful);
        		    }
        		});

        submitButton.setBounds(558, 716, 150, 30);
        panel.add(submitButton);
        
        JButton btnNewButton = new JButton("?");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 JOptionPane.showMessageDialog(null, "Learn more on our website", "Please Wait", JOptionPane.INFORMATION_MESSAGE);
        		    }
        });
        btnNewButton.setBounds(657, 96, 51, 21);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("?\r\n");
        btnNewButton_1.setBounds(657, 170, 51, 21);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 JOptionPane.showMessageDialog(null, "Learn more on our website", "Please Wait", JOptionPane.INFORMATION_MESSAGE);
        		    }
        });
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("?");
        btnNewButton_2.setBounds(657, 240, 51, 21);
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 JOptionPane.showMessageDialog(null, "Learn more on our website", "Please Wait", JOptionPane.INFORMATION_MESSAGE);
        		    }
        });
        panel.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("?");
        btnNewButton_3.setBounds(657, 306, 51, 21);
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 JOptionPane.showMessageDialog(null, "Learn more on our website", "Please Wait", JOptionPane.INFORMATION_MESSAGE);
        		    }
        });
        panel.add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("?");
        btnNewButton_4.setBounds(657, 380, 51, 21);
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 JOptionPane.showMessageDialog(null, "Learn more on our website", "Please Wait", JOptionPane.INFORMATION_MESSAGE);
        		    }
        });
        panel.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("?");
        btnNewButton_5.setBounds(657, 446, 51, 21);
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 JOptionPane.showMessageDialog(null, "Learn more on our website", "Please Wait", JOptionPane.INFORMATION_MESSAGE);
        		    }
        });
        panel.add(btnNewButton_5);
        
        JLabel importanceLabel = new JLabel("<html><p style='width: 400px;'>An FAQ (Frequently Asked Questions) section plays a crucial role in improving user experience by providing quick, accessible answers to common questions. It reduces the need for direct support, allowing users to solve issues independently, which enhances overall efficiency. A well-designed FAQ section also helps users navigate the app or website more confidently,..</p></html>");
        importanceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        importanceLabel.setBounds(20, 736, 590, 166);

        return scrollPane;
    }


   

    public void insertFeedback(String comment, boolean isHelpful) {
        String insertSQL = "INSERT INTO faq_feedback (comment, is_helpful) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            
           
            pstmt.setString(1, comment);
            pstmt.setBoolean(2, isHelpful);

            
            pstmt.executeUpdate();

        
            JOptionPane.showMessageDialog(null, "Feedback submitted successfully!");
        } catch (SQLException e) {
          
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error submitting feedback: " + e.getMessage());
        }
    }

}


