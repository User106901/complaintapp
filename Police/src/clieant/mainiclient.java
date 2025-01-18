package clieant;

import javax.swing.*;
import java.awt.*;

public class mainiclient {
    private JPanel container;
    private CardLayout cards;

    public mainiclient(JPanel container, CardLayout cards) {
        this.container = container;
        this.cards = cards;
    }

    public JPanel getPanel() {
     
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new CardLayout()); 

    
      
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
      
        return mainPanel; 
    }
}

