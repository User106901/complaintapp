package policepac;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class butonat {
    private JPanel container;
    private CardLayout cards;

    public butonat(JPanel container, CardLayout cards, JFrame frame) {
        this.container = container;
        this.cards = cards;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);

      
        JLabel titleLabel = new JLabel("Police Operations Dashboard");
        titleLabel.setBounds(160, 20, 500, 50);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);


        ImageIcon logoIcon = new ImageIcon("logo.png"); 
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(20, 20, 100, 100);
        panel.add(logoLabel);

    
        JLabel statusLabel = new JLabel("Select an operation to proceed:");
        statusLabel.setBounds(200, 80, 400, 30);
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        statusLabel.setForeground(Color.LIGHT_GRAY);
        panel.add(statusLabel);

    
        JButton btnCriminalCheck = new JButton("Criminal Background Check");
        btnCriminalCheck.setBounds(200, 150, 400, 40);
        styleButton(btnCriminalCheck);
        btnCriminalCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "criminalbackcheck");
            }
        });
        panel.add(btnCriminalCheck);

        JButton btnReportedCrimes = new JButton("Reported Crimes");
        btnReportedCrimes.setBounds(200, 210, 400, 40);
        styleButton(btnReportedCrimes);
        btnReportedCrimes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "crimereported");
            }
        });
        panel.add(btnReportedCrimes);

       

        JButton btnInformantInfo = new JButton("Informant Info");
        btnInformantInfo.setBounds(200, 330, 400, 40);
        styleButton(btnInformantInfo);
        btnInformantInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "crimetype");
            }
        });
        panel.add(btnInformantInfo);

        JButton btnCloseCase = new JButton("Close Case");
        btnCloseCase.setBounds(200, 390, 400, 40);
        styleButton(btnCloseCase);
        btnCloseCase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(container, "reportedcrime");
            }
        });
        panel.add(btnCloseCase);

        
        JLabel footerLabel = new JLabel("Police Dashboard © 2024 - Secure Operations");
        footerLabel.setBounds(200, 750, 400, 30);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        footerLabel.setForeground(Color.GRAY);
        panel.add(footerLabel);

        return panel;
    }

 
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }
}

