package policepac; 

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import notlogged.maini;
import notlogged.butonatlog;
	

public class pButona {
    private JPanel panel;
    private JPanel container;
    private CardLayout cards;
    private JPanel sidebar;
    private CardLayout sidecards;
    private JFrame frame;
    public pButona(JPanel container, CardLayout cards, JPanel sidebar, CardLayout sidecards,JFrame frame) {
        this.container = container;
        this.cards = cards;
        this.sidebar = sidebar;
        this.sidecards = sidecards;
        this.frame= frame;
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 200, 800);
        panel.setBackground(new Color(34, 34, 34)); 


       
        JLabel titleLabel = new JLabel("Navigation");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(10, 20, 180, 30);
        panel.add(titleLabel);

        
        JLabel btn1Label = new JLabel("Home");
        btn1Label.setForeground(Color.WHITE);
        btn1Label.setBounds(10, 70, 180, 30); 
        panel.add(btn1Label);
        
        JButton btnCloseCase = new JButton("Close Case");
        btnCloseCase.setBounds(10, 310, 124, 30);
        styleButton(btnCloseCase);  
        btnCloseCase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "reportedcrime");
            }
        });
        panel.add(btnCloseCase);
       
        JButton btnReportedCrimes = new JButton("Reported Crimes");
        btnReportedCrimes.setBounds(10, 168, 124, 30); 
        styleButton(btnReportedCrimes); 
        btnReportedCrimes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "crimereported");
            }
        });
        panel.add(btnReportedCrimes);
        
        JButton btn1 = new JButton("Kreu 1");
        btn1.setBounds(10, 100, 124, 30);
        styleButton(btn1);  
        panel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "kreu");
            }
        });

        JLabel b3Label = new JLabel("Artikujt");
        b3Label.setForeground(Color.WHITE);
        b3Label.setBounds(10, 340, 180, 30);
        panel.add(b3Label);

        JButton b3 = new JButton("View Articles");
        b3.setBounds(10, 380, 124, 30); 
        styleButton(b3); 
        panel.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "article");
            }
        });

        JButton o1 = new JButton("Assign Officer");
        o1.setBounds(10, 231, 124, 30); 
        styleButton(o1);  
        panel.add(o1);
        o1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "registercrime");
            }
        });
        
        JButton btnEvidence = new JButton("Vullnetaret");
        btnEvidence.setBounds(10, 453, 124, 30); 
        styleButton(btnEvidence); 
        btnEvidence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "enterdetails");
            }
        });
        panel.add(btnEvidence);

        
        JLabel logoutLabel = new JLabel("Log Out");
        logoutLabel.setForeground(Color.WHITE);
        logoutLabel.setBounds(10, 505, 180, 30); 
        panel.add(logoutLabel);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(10, 559, 124, 30); 
        styleButton(logoutButton);  
        panel.add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                    frame.dispose();
                    System.exit(0); 
                }
            
        });

    }
   
    private void styleButton(JButton button) {
        button.setBackground(new Color(50, 50, 50)); 
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 12)); 
        button.setBorder(BorderFactory.createEmptyBorder());  
        button.setFocusPainted(false); 
        button.setHorizontalAlignment(SwingConstants.CENTER); 
        button.setVerticalAlignment(SwingConstants.CENTER); 

        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(70, 70, 70)); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(50, 50, 50)); 
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}

