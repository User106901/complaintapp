package notlogged;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clieant.Butonclient;
import clieant.ankesa;
import clieant.article;
import clieant.complain;
import clieant.complaints;
import clieant.locationpolicve;
import clieant.mainiclient;

import clieant.profile;
import clieant.safetytips;
import clieant.shumbtn;

import policepac.butonat;
import policepac.closecase;
import policepac.crimereported;


import policepac.officerassigment;
import policepac.pButona;


import policepac.vullnetaret2;

public class maini {
	/**
     * @wbp.parser.entryPoint
     */
	
	public static void main(String[] args) {
 
        JFrame frame = new JFrame("Zëri Qytetar");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon icona = new ImageIcon("ikonaa.png");
        frame.setIconImage(icona.getImage());

       
        CardLayout cards = new CardLayout();
        JPanel container = new JPanel(cards);
        container.setBounds(200, 50, 800, 750);  

        CardLayout sidecards = new CardLayout();
        JPanel sidebar = new JPanel(sidecards);
        sidebar.setBounds(0, 50, 200, 750);  
        
        
        top topi = new top(container, cards, null, null);
        JPanel top = topi.getPanel();
        
       String loggedInUsername = login.getLoggedInUsername();

        kreu kreu1 = new kreu(container, cards);
        JScrollPane kreu = kreu1.getPanel();

        mainiclient c = new mainiclient(container, cards);
        JPanel mainiclient = c.getPanel();

        Butonclient c1 = new Butonclient(container, cards, mainiclient, sidecards);
        JPanel Butonclient = c1.getPanel();

        faq faq1 = new faq(container, cards);
        JScrollPane faq = faq1.getPanel();

        vullnetar vullnetar1 = new vullnetar(container, cards);
        JPanel vullnetar = vullnetar1.getPanel();

        anonimet anonimet1 = new anonimet(container, cards);
        JPanel anonimet = anonimet1.getPanel();

        register cr = new register(container, cards);
        JPanel register = cr.getPanel();

        login login1 = new login(container, cards, sidebar, sidecards,loggedInUsername);
        JPanel login = login1.getPanel();

        article smsq = new article(container, cards);
        JPanel article = smsq.getPanel();
        
        complain cp = new complain(container, cards, loggedInUsername);
        JPanel com = cp.getPanel();

//        butonatlog sidebarInstance = new butonatlog(container, cards, sidebar, sidecards);
//        JPanel sidebarPanel = sidebarInstance.getPanel(); 


        top topPanelInstance = new top(container, cards, loggedInUsername, loggedInUsername);
        JPanel topPanel = topPanelInstance.getPanel();
        topPanel.setBounds(0, 0, 1000, 50);
        frame.add(topPanel);
        
       

        safetytips safetyPanel = new safetytips(container, cards);
        JPanel safetyContent = safetyPanel.getPanel();

        complaints complaintsPanel = new complaints(container, cards);
        JPanel complaintsContent = complaintsPanel.getPanel();

        profile profilePanel = new profile(container, cards, loggedInUsername);
        JPanel profileContent = profilePanel.getPanel();

        article articlePanel = new article(container, cards);
        JPanel articleContent = articlePanel.getPanel();

        shumbtn sh = new shumbtn(container, cards, loggedInUsername);
        JPanel sh1 = sh.getPanel();
        
        profile pr = new profile(container, cards, UserSession.getInstance().getUsername());
        JPanel pr1 = pr.getPanel();
        
        locationpolicve lc = new locationpolicve(container, cards);
        JPanel lc1 = lc.getPanel();
        
        ankesa ank = new ankesa(container, cards, loggedInUsername);
        JPanel ankes = ank.getPanel();
        
       pButona sidebar1 = new pButona(container, cards, sidebar, sidecards, frame);
         JPanel sd = (JPanel) sidebar.getParent();
       
       
      

        butonat p5 = new butonat(container, cards, frame);
        JPanel paneli5Panel = p5.getPanel();

     

       crimereported a11 = new crimereported(container, cards);
       JPanel crimereported = a11.getPanel();
      
       

        officerassigment rgcr = new officerassigment(container, cards);
        JPanel registercrime = rgcr.getPanel();
        
       
        
        closecase rsp = new closecase(container, cards);
        JPanel reportedcrime = rsp.getPanel();
        
        vullnetaret2 details = new vullnetaret2(container, cards);
        JPanel enterdetails = details.getPanel();
        
       
       

       
      
       butonatlog sidebarContent = new butonatlog(container, cards, sidebar, sidecards);
       JPanel butonatlogPanel = sidebarContent.getPanel();
       sidebar.add(butonatlogPanel, "butonatlog"); 

        
        container.add(kreu, "kreu");
     
       
        container.add(reportedcrime, "reportedcrime");
        container.add(registercrime, "registercrime");
       
        container.add(crimereported, "crimereported");
    
       
     
        container.add(paneli5Panel, "paneli5");
        container.add(enterdetails, "enterdetails");
        container.add(com, "complain");
        
        
        
        container.add(ankes, "ankesa");
        container.add(article, "article");
        container.add(register, "register");
        container.add(anonimet, "anonimet");
        container.add(vullnetar, "vullnetar");
        container.add(faq, "faq");
        container.add(login, "login");
        container.add(mainiclient, "mainiclient");
        container.add(Butonclient, "Butonclient");
        
        
       
        container.add(safetyContent, "safetytips");
        container.add(complaintsContent, "complaintsContent");
        container.add(profileContent, "profileContent");
        container.add(articleContent, "articleContent");
        container.add(sh1, "shumbtn");
        container.add(pr1, "profile");
        container.add(lc1, "locationpolicve");
       
        container.add(top, "top");
        
        
        container.setLayout(cards);
        sidebar.add(butonatlogPanel, "butonat");
 
       

        frame.revalidate();
        frame.repaint();
        frame.add(sidebar);
        frame.add(container);
        
        cards.show(container,"top");
        cards.show(container, "kreu");

        frame.setVisible(true);
   
	}
}

