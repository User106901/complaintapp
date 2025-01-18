package notlogged;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class butonatlog {
    private  JPanel panel;
    private JPanel container;
    private CardLayout cards;
    private JFrame frame;

    public butonatlog(JPanel container, CardLayout cards, JPanel sidebar, CardLayout sidecards) {
        this.container = container;
        this.cards = cards;
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 200, 800); 
        panel.setBackground(new Color(34, 34, 34)); 

      
        JLabel titleLabel = new JLabel("Navigation");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(10, 20, 150, 25); 
        panel.add(titleLabel);

       
        JLabel mainLabel = new JLabel("Kreu :\r\n");
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setBounds(10, 60, 150, 25);  
        panel.add(mainLabel);

        JButton btnMain = createStyledButton("Home", 10, 85);  
        panel.add(btnMain);
        btnMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "kreu");
            }
        });

        
        JLabel reportLabel = new JLabel("Report Crime");
        reportLabel.setForeground(Color.WHITE);
        reportLabel.setBounds(10, 140, 150, 25);  
        panel.add(reportLabel);

        JButton btnReport = createStyledButton("Report a Crime", 10, 165);  
        panel.add(btnReport);
        btnReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "anonimet");
            }
        });

      
        JLabel articleLabel = new JLabel("Article / Safety\r\n");
        articleLabel.setForeground(Color.WHITE);
        articleLabel.setBounds(10, 230, 150, 25);  
        panel.add(articleLabel);

        JButton btnArticle = createStyledButton("Article", 10, 255);  
        panel.add(btnArticle);
        btnArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "article");
            }
        });

       
        JButton btn1 = createStyledButton("Safety & Tips", 10, 310); 
        panel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "safetytips");
            }
        });

       
        JLabel authLabel = new JLabel("Register :");
        authLabel.setForeground(Color.WHITE);
        authLabel.setBounds(10, 380, 150, 25);  
        panel.add(authLabel);

        JButton btnRegister = createStyledButton("Register", 10, 405);  
        panel.add(btnRegister);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "register");
            }
        });
    }

    private JButton createStyledButton(String text, int x, int y) {
        JButton btnDashbord = new JButton(text);
        btnDashbord.setBounds(x, y, 150, 40);  
        btnDashbord.setFont(new Font("Arial", Font.PLAIN, 12));
        btnDashbord.setForeground(Color.WHITE);
        btnDashbord.setBackground(new Color(50, 50, 50));
        btnDashbord.setFocusPainted(false);
        btnDashbord.setBorder(BorderFactory.createEmptyBorder());
        btnDashbord.setOpaque(true);
        btnDashbord.setHorizontalAlignment(SwingConstants.CENTER);
        btnDashbord.setVerticalAlignment(SwingConstants.CENTER);

       
        btnDashbord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDashbord.setBackground(new Color(70, 70, 70));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDashbord.setBackground(new Color(50, 50, 50));
            }
        });

        return btnDashbord;
    }

    public  JPanel getPanel() {
        return panel;
    }
}
