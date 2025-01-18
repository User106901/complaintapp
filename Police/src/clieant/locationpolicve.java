package clieant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URI;
import java.awt.event.ActionEvent;

public class locationpolicve {
    private JPanel clientContainer;
    private CardLayout clientCards;

    public locationpolicve(JPanel clientContainer, CardLayout clientCards) {
        this.clientContainer = clientContainer;
        this.clientCards = clientCards;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JPanel getPanel() {
        JPanel policeStationPanel = new JPanel();
        policeStationPanel.setLayout(null);
        policeStationPanel.setBackground(Color.LIGHT_GRAY);

        JLabel headerLabel = new JLabel("Nearby Police Stations");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBounds(20, 10, 760, 40);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        policeStationPanel.add(headerLabel);

      
        JLabel stationLabel1 = new JLabel("Station Name:");
        stationLabel1.setBounds(20, 60, 150, 30);
        policeStationPanel.add(stationLabel1);

        JTextField stationNameField1 = new JTextField("Station 1 Name");
        stationNameField1.setBounds(150, 60, 250, 30);
        stationNameField1.setEditable(false);
        policeStationPanel.add(stationNameField1);

        JLabel emailLabel1 = new JLabel("Email:");
        emailLabel1.setBounds(20, 100, 150, 30);
        policeStationPanel.add(emailLabel1);

        JTextField emailField1 = new JTextField("station1@police.gov");
        emailField1.setBounds(150, 100, 250, 30);
        emailField1.setEditable(false);
        policeStationPanel.add(emailField1);

        JLabel locationLabel1 = new JLabel("Location:");
        locationLabel1.setBounds(20, 140, 150, 30);
        policeStationPanel.add(locationLabel1);

        JTextField locationField1 = new JTextField("Address of Station 1");
        locationField1.setBounds(150, 140, 250, 30);
        locationField1.setEditable(false);
        policeStationPanel.add(locationField1);

        ImageIcon ik1 = new ImageIcon("s.png");
        Image image1 = ik1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel il1 = new JLabel(new ImageIcon(image1));
        il1.setBounds(630, 60, 150, 120);
        policeStationPanel.add(il1);

        JLabel stationImage1 = new JLabel();
        stationImage1.setBounds(450, 60, 300, 120);
        ImageIcon stationIcon1 = new ImageIcon("path/to/station1.jpg");
        stationImage1.setIcon(new ImageIcon(stationIcon1.getImage().getScaledInstance(300, 120, Image.SCALE_SMOOTH)));
        policeStationPanel.add(stationImage1);

        JSeparator separator1 = new JSeparator();
        separator1.setBounds(20, 200, 760, 10);
        policeStationPanel.add(separator1);

   
        JLabel stationLabel2 = new JLabel("Station Name:");
        stationLabel2.setBounds(20, 210, 150, 30);
        policeStationPanel.add(stationLabel2);

        JTextField stationNameField2 = new JTextField("Station 2 Name");
        stationNameField2.setBounds(150, 210, 250, 30);
        stationNameField2.setEditable(false);
        policeStationPanel.add(stationNameField2);

        JLabel emailLabel2 = new JLabel("Email:");
        emailLabel2.setBounds(20, 250, 150, 30);
        policeStationPanel.add(emailLabel2);

        JTextField emailField2 = new JTextField("station2@police.gov");
        emailField2.setBounds(150, 250, 250, 30);
        emailField2.setEditable(false);
        policeStationPanel.add(emailField2);

        JLabel locationLabel2 = new JLabel("Location:");
        locationLabel2.setBounds(20, 290, 150, 30);
        policeStationPanel.add(locationLabel2);

        JTextField locationField2 = new JTextField("Address of Station 2");
        locationField2.setBounds(150, 290, 250, 30);
        locationField2.setEditable(false);
        policeStationPanel.add(locationField2);

        ImageIcon ik2 = new ImageIcon("ss.png");
        Image image2 = ik2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel il2 = new JLabel(new ImageIcon(image2));
        il2.setBounds(630, 220, 150, 120);
        policeStationPanel.add(il2);

        JLabel stationImage2 = new JLabel();
        stationImage2.setBounds(450, 210, 300, 120);
        ImageIcon stationIcon2 = new ImageIcon("path/to/station2.jpg");
        stationImage2.setIcon(new ImageIcon(stationIcon2.getImage().getScaledInstance(300, 120, Image.SCALE_SMOOTH)));
        policeStationPanel.add(stationImage2);

        JSeparator separator2 = new JSeparator();
        separator2.setBounds(20, 350, 760, 10);
        policeStationPanel.add(separator2);

    
        JLabel stationLabel3 = new JLabel("Station Name:");
        stationLabel3.setBounds(20, 360, 150, 30);
        policeStationPanel.add(stationLabel3);

        JTextField stationNameField3 = new JTextField("Station 3 Name");
        stationNameField3.setBounds(150, 360, 250, 30);
        stationNameField3.setEditable(false);
        policeStationPanel.add(stationNameField3);

        JLabel emailLabel3 = new JLabel("Email:");
        emailLabel3.setBounds(20, 400, 150, 30);
        policeStationPanel.add(emailLabel3);

        JTextField emailField3 = new JTextField("station3@police.gov");
        emailField3.setBounds(150, 400, 250, 30);
        emailField3.setEditable(false);
        policeStationPanel.add(emailField3);

        JLabel locationLabel3 = new JLabel("Location:");
        locationLabel3.setBounds(20, 440, 150, 30);
        policeStationPanel.add(locationLabel3);

        JTextField locationField3 = new JTextField("Address of Station 3");
        locationField3.setBounds(150, 440, 250, 30);
        locationField3.setEditable(false);
        policeStationPanel.add(locationField3);

        ImageIcon ik3 = new ImageIcon("ssss.png");
        Image image3 = ik3.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel il3 = new JLabel(new ImageIcon(image3));
        il3.setBounds(612, 370, 150, 120);
        policeStationPanel.add(il3);

        JLabel stationImage3 = new JLabel();
        stationImage3.setBounds(450, 360, 300, 120);
        ImageIcon stationIcon3 = new ImageIcon("path/to/station3.jpg");
        stationImage3.setIcon(new ImageIcon(stationIcon3.getImage().getScaledInstance(300, 120, Image.SCALE_SMOOTH)));
        policeStationPanel.add(stationImage3);

        JSeparator separator3 = new JSeparator();
        separator3.setBounds(20, 510, 760, 10);
        policeStationPanel.add(separator3);

    
        JLabel stationLabel4 = new JLabel("Station Name:");
        stationLabel4.setBounds(20, 520, 150, 30);
        policeStationPanel.add(stationLabel4);

        JTextField stationNameField4 = new JTextField("Station 4 Name");
        stationNameField4.setBounds(150, 520, 250, 30);
        stationNameField4.setEditable(false);
        policeStationPanel.add(stationNameField4);

        JLabel emailLabel4 = new JLabel("Email:");
        emailLabel4.setBounds(20, 560, 150, 30);
        policeStationPanel.add(emailLabel4);

        JTextField emailField4 = new JTextField("station4@police.gov");
        emailField4.setBounds(150, 560, 250, 30);
        emailField4.setEditable(false);
        policeStationPanel.add(emailField4);

        JLabel locationLabel4 = new JLabel("Location:");
        locationLabel4.setBounds(20, 600, 150, 30);
        policeStationPanel.add(locationLabel4);

        JTextField locationField4 = new JTextField("Address of Station 4");
        locationField4.setBounds(150, 600, 250, 30);
        locationField4.setEditable(false);
        policeStationPanel.add(locationField4);

        ImageIcon ik4 = new ImageIcon("sssss.png");
        Image image4 = ik4.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel il4 = new JLabel(new ImageIcon(image4));
        il4.setBounds(612, 530, 150, 130);
        policeStationPanel.add(il4);

        JLabel stationImage4 = new JLabel();
        stationImage4.setBounds(450, 520, 300, 120);
        ImageIcon stationIcon4 = new ImageIcon("path/to/station4.jpg");
        stationImage4.setIcon(new ImageIcon(stationIcon4.getImage().getScaledInstance(300, 120, Image.SCALE_SMOOTH)));
        policeStationPanel.add(stationImage4);

        JSeparator separator4 = new JSeparator();
        separator4.setBounds(20, 670, 760, 10);
        policeStationPanel.add(separator4);

        JLabel footerLabel = new JLabel("For emergencies, call 911.");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        footerLabel.setForeground(Color.RED);
        footerLabel.setBounds(20, 720, 760, 30);
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        policeStationPanel.add(footerLabel);
        
        JButton btnNewButton = new JButton("Maps");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton.setBackground(new Color(128, 128, 128));
        btnNewButton.addActionListener(new ActionListener() {
        	
        		 public void actionPerformed(ActionEvent e) {
                 	openWebpage("https://www.google.com/maps/search/Police+Station+No.+3,+Rr.+Mine+Peza,+Nr+10,+Tiran%C3%AB,+1016+Tirana-Tirana,+Albania/@41.3388766,19.8260177,15z/data=!3m1!4b1?entry=ttu&g_ep=EgoyMDI1MDExNC4wIKXMDSoASAFQAw%3D%3D");
                 }
             
        });
        btnNewButton.setBounds(460, 169, 85, 21);
        policeStationPanel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Maps");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton_1.setBackground(new Color(128, 128, 128));
        btnNewButton_1.setBounds(460, 322, 85, 21);
        btnNewButton_1.addActionListener(new ActionListener() {
        	
   		 public void actionPerformed(ActionEvent e) {
            	openWebpage("https://www.google.com/maps/search/Police+Station+No.+3,+Rr.+Mine+Peza,+Nr+10,+Tiran%C3%AB,+1016+Tirana-Tirana,+Albania/@41.3388766,19.8260177,15z/data=!3m1!4b1?entry=ttu&g_ep=EgoyMDI1MDExNC4wIKXMDSoASAFQAw%3D%3D");
            }
        
   });
        policeStationPanel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Maps");
        btnNewButton_2.setBackground(new Color(128, 128, 128));
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton_2.setBounds(460, 479, 85, 21);
        btnNewButton_2.addActionListener(new ActionListener() {
        	
      		 public void actionPerformed(ActionEvent e) {
               	openWebpage("https://www.google.com/maps/search/Police+Station+No.+3,+Rr.+Mine+Peza,+Nr+10,+Tiran%C3%AB,+1016+Tirana-Tirana,+Albania/@41.3388766,19.8260177,15z/data=!3m1!4b1?entry=ttu&g_ep=EgoyMDI1MDExNC4wIKXMDSoASAFQAw%3D%3D");
               }
           
      });
        policeStationPanel.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Maps");
        btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton_3.setBackground(new Color(128, 128, 128));
        btnNewButton_3.setBounds(460, 639, 85, 21);
        btnNewButton_3.addActionListener(new ActionListener() {
        	
      		 public void actionPerformed(ActionEvent e) {
               	openWebpage("https://www.google.com/maps/search/Police+Station+No.+3,+Rr.+Mine+Peza,+Nr+10,+Tiran%C3%AB,+1016+Tirana-Tirana,+Albania/@41.3388766,19.8260177,15z/data=!3m1!4b1?entry=ttu&g_ep=EgoyMDI1MDExNC4wIKXMDSoASAFQAw%3D%3D");
               }
           
      });
        policeStationPanel.add(btnNewButton_3);

        return policeStationPanel;
    
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


