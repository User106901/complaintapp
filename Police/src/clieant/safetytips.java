package clieant;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class safetytips {
    private JPanel container;
    private CardLayout cards;

    public safetytips(JPanel container, CardLayout cards) {
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


        JLabel headerLabel = new JLabel("Safety and Tips");
        headerLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setBounds(20, 10, 446, 50);
        headerLabel.setForeground(new Color(50, 50, 50));
        panel.add(headerLabel);

      
        
        ImageIcon imageIcon = new ImageIcon("safety.png"); // Replace with your image path
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        // Create a JLabel and set the image
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(485, 362, 142, 148);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(imageLabel);
        
        JLabel quoteLabel = new JLabel(
            "<html><center>“Your voice matters. Speak up to create a better tomorrow.”</center></html>"
        );
        quoteLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        quoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quoteLabel.setBounds(50, 60, 700, 50);
        quoteLabel.setForeground(new Color(80, 80, 80));
        panel.add(quoteLabel);

    
        JLabel tipsHeader = new JLabel("Reporting Safely:");
        tipsHeader.setFont(new Font("Verdana", Font.BOLD, 22));
        tipsHeader.setBounds(20, 120, 300, 30);
        tipsHeader.setForeground(new Color(60, 60, 60));
        panel.add(tipsHeader);

        String[] safetyTips = {
            "1. Avoid sharing personal information unless necessary.",
            "2. Ensure your location is secure when reporting.",
            "3. Keep a record of any supporting evidence.",
            "4. Use secure devices to submit complaints.",
            "5. Familiarize yourself with local laws and resources."
        };

        int tipYPosition = 160;
        for (String tip : safetyTips) {
            JLabel tipLabel = new JLabel(tip);
            tipLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            tipLabel.setBounds(40, tipYPosition, 700, 30);
            tipLabel.setForeground(new Color(70, 70, 70));
            panel.add(tipLabel);
            tipYPosition += 30;
        }

       
        JLabel emergencyHeader = new JLabel("In Case of Emergencies:");
        emergencyHeader.setFont(new Font("Verdana", Font.BOLD, 22));
        emergencyHeader.setBounds(20, 345, 341, 30);
        emergencyHeader.setForeground(new Color(60, 60, 60));
        panel.add(emergencyHeader);

        JTextArea emergencySteps = new JTextArea(
            "- Call emergency services if you're in immediate danger.\n" +
            "- Avoid confrontation; report incidents anonymously if needed.\n" +
            "- Share evidence securely and responsibly.\n" +
            "- Notify trusted authorities for guidance."
        );
        emergencySteps.setFont(new Font("Arial", Font.PLAIN, 16));
        emergencySteps.setBounds(20, 405, 440, 80);
        emergencySteps.setBackground(new Color(192, 192, 192));
        emergencySteps.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        emergencySteps.setEditable(false);
        panel.add(emergencySteps);

        
        JLabel quizHeader = new JLabel("Know Your Rights:");
        quizHeader.setFont(new Font("Verdana", Font.BOLD, 22));
        quizHeader.setBounds(486, 120, 300, 30);
        quizHeader.setForeground(new Color(60, 60, 60));
        panel.add(quizHeader);

        JLabel quizQuestion = new JLabel("What  if  complaint is ignored?");
        quizQuestion.setFont(new Font("Arial", Font.PLAIN, 16));
        quizQuestion.setBounds(519, 175, 700, 30);
        panel.add(quizQuestion);

       
        JRadioButton option1 = new JRadioButton("File a follow-up complaint.");
        option1.setBounds(519, 220, 400, 30);
        option1.setFont(new Font("Arial", Font.PLAIN, 16));
        option1.setBackground(new Color(192, 192, 192)); // Panel background
        panel.add(option1);

        JRadioButton option2 = new JRadioButton("Post it publicly on social media.");
        option2.setBounds(519, 321, 400, 30);
        option2.setFont(new Font("Arial", Font.PLAIN, 16));
        option2.setBackground(new Color(192, 192, 192)); 
        panel.add(option2);

        JRadioButton option3 = new JRadioButton("Take no action.");
        option3.setBounds(519, 268, 400, 30);
        option3.setFont(new Font("Arial", Font.PLAIN, 16));
        option3.setBackground(new Color(192, 192, 192)); 
        panel.add(option3);

       
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        JButton submitButton = new JButton("Submit!");
        submitButton.setBackground(new Color(112, 117, 143));
        submitButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
        submitButton.setBounds(650, 402, 100, 30);
        panel.add(submitButton);

        JLabel quizResult = new JLabel("");
        quizResult.setFont(new Font("Arial", Font.ITALIC, 16));
        quizResult.setBounds(40, 520, 700, -16);
        quizResult.setForeground(Color.DARK_GRAY);
        panel.add(quizResult);

        submitButton.addActionListener(e -> {
            if (option1.isSelected()) {
                quizResult.setText("Correct! Persistence ensures accountability.");
            } else {
                quizResult.setText("Incorrect. Always follow up to seek justice.");
            }
        });

        
        JLabel helplineHeader = new JLabel("Need Help?");
        helplineHeader.setFont(new Font("Verdana", Font.BOLD, 22));
        helplineHeader.setBounds(20, 542, 300, 30);
        helplineHeader.setForeground(new Color(60, 60, 60));
        panel.add(helplineHeader);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(20, 521, 710, 2);
        panel.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(475, 121, 11, 383);
        panel.add(separator_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(128, 128, 128));
        panel_1.setBounds(0, 591, 902, 182);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Your voice matters—submit your complaint and make a difference!");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(23, 86, 628, 33);
        panel_1.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Our Website\r\n");
        btnNewButton.setBackground(new Color(98, 96, 159));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(23, 44, 113, 30);
        panel_1.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Facebook");
        btnNewButton_1.setBounds(298, 46, 100, 30);
        panel_1.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		article.openWebpage("https://www.facebook.com");
        	}
        });
        btnNewButton_1.setBackground(new Color(0, 64, 128));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        
        JButton btnNewButton_2 = new JButton("Instagram");
        btnNewButton_2.setBounds(431, 46, 100, 30);
        panel_1.add(btnNewButton_2);
        btnNewButton_2.setBackground(new Color(88, 39, 70));
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        
        JButton btnNewButton_3 = new JButton("Twiter");
        btnNewButton_3.setBounds(571, 46, 100, 30);
        panel_1.add(btnNewButton_3);
        btnNewButton_3.setBackground(new Color(0, 128, 192));
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        
        JLabel lblNewLabel_1 = new JLabel("Socials:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(263, 10, 119, 24);
        panel_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Contact Us!");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(22, 10, 107, 24);
        panel_1.add(lblNewLabel_2);
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		article.openWebpage("https://www.tiwter.com");
        	}
        });
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		article.openWebpage("https://www.instagram.com");
        	}
        });

        return panel;
    }
}

