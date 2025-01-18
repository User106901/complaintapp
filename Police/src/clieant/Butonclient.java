package clieant;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import notlogged.butonatlog;

public class Butonclient {
    private JPanel panel;
    private JPanel container;
    private CardLayout cards;
    private JPanel sidebar;
    private CardLayout sidecards;

    public Butonclient(JPanel container, CardLayout cards, JPanel sidebar, CardLayout sidecards) {
        this.container = container;
        this.cards = cards;
        this.sidebar = sidebar;
        this.sidecards = sidecards;

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 200, 800); 
        panel.setBackground(new Color(34, 34, 34)); 

        JLabel titleLabel = new JLabel("Navigation");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(10, 20, 150, 30); 
        panel.add(titleLabel);

        
        JLabel kreuLabel = new JLabel("Ankesat e tuaja :");
        kreuLabel.setForeground(Color.WHITE);
        kreuLabel.setBounds(10, 130, 150, 30); 
        panel.add(kreuLabel);

        JButton btnKreu = createStyledButton("Kreu", 10, 80);
        panel.add(btnKreu);
        btnKreu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "kreu");
            }
        });

        
        JLabel vullnetarLabel = new JLabel("Vullnetar");
        vullnetarLabel.setForeground(Color.WHITE);
        vullnetarLabel.setBounds(10, 220, 150, 30);  
        panel.add(vullnetarLabel);

        JButton btnVullnetar = createStyledButton("Vullnetar", 10, 245);  
        panel.add(btnVullnetar);
        btnVullnetar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "vullnetar");
            }
        });

       
        JLabel articlesLabel = new JLabel("Articles");
        articlesLabel.setForeground(Color.WHITE);
        articlesLabel.setBounds(10, 280, 150, 30);
        panel.add(articlesLabel);

        JButton btnArticles = createStyledButton("View Articles", 10, 310); 
        panel.add(btnArticles);
        btnArticles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "article");
            }
        });

        
        JButton btn1 = createStyledButton("Safety & Tips", 10, 380); 
        panel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "safetytips");
            }
        });

       
        JLabel complainLabel = new JLabel("Complain");
        complainLabel.setForeground(Color.WHITE);
        complainLabel.setBounds(10, 430, 150, 30);  
        panel.add(complainLabel);

        JButton btnComplain = createStyledButton("Complain", 10, 460);  
        panel.add(btnComplain);
        btnComplain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "complain");
            }
        });

        
        JButton btn5q = createStyledButton("Police Stations", 10, 540);  
        panel.add(btn5q);
        btn5q.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "locationpolicve");
            }
        });

        JButton ankesa = createStyledButton("Ankesa", 10, 160);  
        panel.add(ankesa);
        ankesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "ankesa");
            }
        });
        
       
        JLabel logoutLabel = new JLabel("Log Out");
        logoutLabel.setForeground(Color.WHITE);
        logoutLabel.setBounds(10, 600, 150, 30); 
        panel.add(logoutLabel);

        JButton btnLogout = createStyledButton("Log Out", 10, 630); 
        panel.add(btnLogout);
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log Out button clicked");
                

                butonatlog sidebarContent = new butonatlog(container, cards, sidebar, sidecards);
                JPanel sidebarPanel = sidebarContent.getPanel();

                
                sidebar.add(sidebarPanel, "butonatlog");

                sidecards.show(sidebar, "butonatlog");
                cards.show(container, "kreu");
            }
        });
    }

    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 40);  
        button.setFont(new Font("Arial", Font.PLAIN, 12));  
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(50, 50, 50));  
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder()); 
        button.setOpaque(true);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);

        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 70, 70));  
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(50, 50, 50)); 
            }
        });

        return button;
    }

    public JPanel getPanel() {
        return panel;
    }
}

