package clieant;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.net.URI;
import java.awt.event.ActionEvent;
import java.net.URI;
import javax.swing.JSeparator;

public class article {
    private JPanel container;
    private CardLayout cards;

    public article(JPanel container, CardLayout cards) {
        this.container = container;
        this.cards = cards;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JPanel getPanel() {
        JPanel articlePanel = new JPanel();
        articlePanel.setLayout(null);
        articlePanel.setBounds(0, 0, 800, 800);
        articlePanel.setBackground(new Color(192, 192, 192));

        JLabel titleLabel = new JLabel("Available Articles");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(20, 20, 300, 30);
        articlePanel.add(titleLabel);

        String[] columnNames = {"Title", "Author", "Date", "Category"};
        Object[][] data = {
            {"Why Complaints Matter", "John Doe", "2024-01-15", "Civic Engagement"},
            {"The Power of Citizen Feedback", "Jane Smith", "2024-02-10", "Government"},
            {"Impact of Reporting Issues", "Mike Ross", "2024-03-05", "Social Change"},
            {"How Complaints Shape Public Policy", "Emily Clark", "2024-04-20", "Policy"},
            {"Complaints: A Tool for Accountability", "Chris Evans", "2024-05-10", "Governance"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable articleTable = new JTable(model);
        articleTable.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(articleTable);
        scrollPane.setBounds(20, 70, 600, 175);
        articlePanel.add(scrollPane);

        JLabel footerLabel = new JLabel("Tip: Click the icon to download an article.");
        footerLabel.setBounds(20, 273, 760, 30);
        footerLabel.setForeground(Color.GRAY);
        articlePanel.add(footerLabel);

        JButton downloadButton1 = new JButton("↓");
        downloadButton1.setFont(new Font("Arial", Font.PLAIN, 18));
        downloadButton1.setBackground(new Color(240, 240, 240));
        downloadButton1.setFocusPainted(false);
        downloadButton1.setBounds(648, 101, 42, 19);
        downloadButton1.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Downloading 'Why Complaints Matter' PDF.");
        });
        articlePanel.add(downloadButton1);

        JButton downloadButton2 = new JButton("↓");
        downloadButton2.setFont(new Font("Arial", Font.PLAIN, 18));
        downloadButton2.setBackground(new Color(240, 240, 240));
        downloadButton2.setFocusPainted(false);
        downloadButton2.setBounds(648, 131, 42, 19);
        downloadButton2.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Downloading 'The Power of Citizen Feedback' PDF.");
        });
        articlePanel.add(downloadButton2);

        JButton downloadButton3 = new JButton("↓");
        downloadButton3.setFont(new Font("Arial", Font.PLAIN, 18));
        downloadButton3.setBackground(new Color(240, 240, 240));
        downloadButton3.setFocusPainted(false);
        downloadButton3.setBounds(648, 161, 42, 19);
        downloadButton3.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Downloading 'Impact of Reporting Issues' PDF.");
        });
        articlePanel.add(downloadButton3);

        JButton downloadButton4 = new JButton("↓");
        downloadButton4.setFont(new Font("Arial", Font.PLAIN, 18));
        downloadButton4.setBackground(new Color(240, 240, 240));
        downloadButton4.setFocusPainted(false);
        downloadButton4.setBounds(648, 191, 42, 19);
        downloadButton4.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Downloading 'How Complaints Shape Public Policy' PDF.");
        });
        articlePanel.add(downloadButton4);

        JButton downloadButton5 = new JButton("↓");
        downloadButton5.setFont(new Font("Arial", Font.PLAIN, 18));
        downloadButton5.setBackground(new Color(240, 240, 240));
        downloadButton5.setFocusPainted(false);
        downloadButton5.setBounds(648, 221, 42, 19);
        downloadButton5.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Downloading 'Complaints: A Tool for Accountability' PDF.");
        });
        articlePanel.add(downloadButton5);

        JLabel infoTitleLabel = new JLabel("Why Citizens Should File Complaints");
        infoTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        infoTitleLabel.setBounds(10, 313, 350, 30);
        articlePanel.add(infoTitleLabel);

        JLabel infoLabel = new JLabel("<html><p style='font-size:14px; color:#333333;'>"
                + "Complaints are not just about expressing dissatisfaction; they are a vital tool in holding organizations, businesses, and governments accountable. "
                + "When citizens voice their concerns, they help bring attention to issues that may otherwise be ignored. Complaints drive improvements in services, ensure safety, and foster positive change in society.</p></html>");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        infoLabel.setBounds(20, 353, 760, 100);
        articlePanel.add(infoLabel);

        JButton complaintButton = new JButton("File a Complaint");
        complaintButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	 cards.show(container, "anonimet");
        	}
        });
        complaintButton.setFont(new Font("Arial", Font.BOLD, 14));
        complaintButton.setBackground(new Color(80, 80, 80));
        complaintButton.setForeground(Color.WHITE);
        complaintButton.setFocusPainted(false);
        complaintButton.setBounds(530, 476, 160, 40);
        articlePanel.add(complaintButton);

        JLabel socialTitle = new JLabel("Follow Us:");
        socialTitle.setFont(new Font("Arial", Font.BOLD, 16));
        socialTitle.setBounds(20, 480, 150, 30);
        articlePanel.add(socialTitle);

        JButton facebookButton = new JButton("Facebook");
        facebookButton.setForeground(new Color(255, 255, 255));
        facebookButton.setBackground(new Color(0, 128, 255));
        facebookButton.setFont(new Font("Arial", Font.ITALIC, 14));
        facebookButton.setBounds(20, 548, 109, 30);
        facebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	openWebpage("https://www.facebook.com");
            }
        });
        articlePanel.add(facebookButton);

        JButton twitterButton = new JButton("Twitter");
        twitterButton.setForeground(new Color(255, 255, 255));
        twitterButton.setBackground(new Color(0, 64, 128));
        twitterButton.setFont(new Font("Arial", Font.ITALIC, 14));
        twitterButton.setBounds(152, 548, 109, 30);
        twitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	openWebpage("https://www.twitter.com");
            }
        });
        articlePanel.add(twitterButton);

        JButton instagramButton = new JButton("Instagram");
        instagramButton.setForeground(new Color(255, 255, 255));
        instagramButton.setBackground(new Color(210, 174, 210));
        instagramButton.setFont(new Font("Arial", Font.ITALIC, 14));
        instagramButton.setBounds(286, 548, 109, 30);
        instagramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	openWebpage("https://www.instagram.com");
            }
        });
        articlePanel.add(instagramButton);

        JLabel disclaimerLabel = new JLabel("<html><p style='font-size:12px; color:#777777;'>"
                + "Disclaimer: This platform is dedicated to promoting civic engagement through complaints and feedback. "
                + "All submitted complaints are processed with the utmost attention and respect for privacy.</p></html>");
        disclaimerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        disclaimerLabel.setBounds(20, 602, 760, 60);
        articlePanel.add(disclaimerLabel);

        JLabel contactLabel = new JLabel("Contact Us: support@citizensvoice.org");
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        contactLabel.setBounds(20, 670, 300, 30);
        articlePanel.add(contactLabel);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(117, 491, 406, 19);
        articlePanel.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(345, 325, 417, 13);
        articlePanel.add(separator_1);

        return articlePanel;
    
    }

    public static void openWebpage(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(url));
            } else {
                JOptionPane.showMessageDialog(null, "Desktop is not supported on this system.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to open webpage.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

