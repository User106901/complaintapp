package notlogged;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clieant.article;

import javax.swing.JButton;
import javax.swing.JSeparator;

public class kreu {
    private JPanel container;
    private CardLayout cards;

    public kreu(JPanel container, CardLayout cards) {
        this.container = container;
        this.cards = cards;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JScrollPane getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(192, 192, 192)); 

        JLabel titleLabel = new JLabel("Complaints Information");
        titleLabel.setBounds(20, 20, 765, 40); 
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22)); 
        titleLabel.setForeground(new Color(50, 50, 50));
        panel.add(titleLabel);

        
        String complaintsText = "<html>"
                + "<div style='font-family: Arial; font-size: 14px; color: black;'>"
                + "<b>What is a Complaint?</b><br><br>"
                + "A complaint is a formal expression of dissatisfaction or grievance against a product, service, or situation. It is a way for individuals to voice their concerns and provide feedback on an issue that they believe requires attention or resolution. Complaints are common in all aspects of life, from consumer goods and services to workplace environments, and even in personal interactions.<br><br>"
                + "In the consumer world, a complaint can arise when a customer feels that a purchased product is defective, the service provided was unsatisfactory, or that the company has failed to meet the promised expectations. For example, if a customer buys a product online and it arrives damaged or is not as described, they may file a complaint to the company asking for a refund or a replacement.<br><br>"
                + "Complaints are an essential part of ensuring that businesses, governments, and other organizations remain accountable for their actions. Without complaints, organizations would have no way of knowing what needs improvement or what issues customers or citizens are facing. The act of making a complaint is a way for people to seek justice or better treatment when they feel wronged.<br><br>"
                + "<b>The Importance of Complaints:</b><br><br>"
                + "Complaints play a crucial role in improving products, services, and systems. When customers or clients voice their grievances, it provides valuable feedback that organizations can use to make necessary changes. This feedback loop helps ensure that issues are addressed and that improvements are made over time.<br><br>"
                + "</div></html>";

       
        JLabel complaintsTextLabel = new JLabel(complaintsText);
        complaintsTextLabel.setVerticalAlignment(JLabel.TOP);
        complaintsTextLabel.setBounds(10, 80, 765, 1500); 
        panel.add(complaintsTextLabel);

        
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 800, 600); 
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); 
        
        panel.setPreferredSize(new Dimension(800, 1000)); 
        panel.setSize(800, 1000); 

      
        JPanel pn = new JPanel();
        pn.setBackground(Color.gray);
        pn.setLayout(null); 

        
        pn.setPreferredSize(new Dimension(300, 500)); 

        
        JButton btnNewButton = new JButton("Our Website");
        btnNewButton.setBackground(Color.black);
        btnNewButton.setBounds(20, 20, 100, 30); 
        pn.add(btnNewButton);

        
        JButton btnNewButton_1 = new JButton("Facebook");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                article.openWebpage("https://www.facebook.com");
            }
        });
        btnNewButton_1.setBackground(new Color(0, 64, 128));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBounds(169, 20, 100, 30); 
        pn.add(btnNewButton_1);

       
        JButton btnNewButton_2 = new JButton("Instagram");
        btnNewButton_2.setBackground(new Color(88, 39, 70));
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        btnNewButton_2.setBounds(329, 20, 100, 30); 
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                article.openWebpage("https://www.instagram.com");
            }
        });
        pn.add(btnNewButton_2);

     
        JButton btnNewButton_3 = new JButton("Twitter");
        btnNewButton_3.setBackground(new Color(0, 128, 192));
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.setBounds(477, 20, 100, 30); 
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                article.openWebpage("https://www.twitter.com");
            }
        });
        pn.add(btnNewButton_3);

        
        JLabel lb = new JLabel("Connecting people, ideas, and solutions.");
        lb.setBounds(20, 70, 600, 30); 
        lb.setForeground(Color.white);
        pn.add(lb);

        JLabel lb1 = new JLabel(" Our complaint app provides a seamless platform for users to voice their concerns");
        lb1.setBounds(20, 120, 760, 30);
        lb1.setForeground(Color.white);
        pn.add(lb1);

        JLabel lb2 = new JLabel("\"Your most unhappy customers are your greatest source of learning");
        lb2.setBounds(20, 160, 760, 30);
        lb2.setForeground(Color.white);
        pn.add(lb2);

        

     

       
        pn.setBounds(0, 800, 800, 500); 
        panel.add(pn);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(209, 91, 549, 22);
        panel.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(297, 530, 461, 22);
        panel.add(separator_1);

        return scrollPane;
    }
}

