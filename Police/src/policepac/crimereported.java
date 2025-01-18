package policepac;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Image;

public class crimereported {
    private JPanel container;
    private CardLayout cards;

    public crimereported(JPanel container, CardLayout cards) {
        this.container = container;
        this.cards = cards;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Reported Crimes");
        titleLabel.setBounds(20, 20, 760, 40);
        titleLabel.setFont(titleLabel.getFont().deriveFont(20f));
        panel.add(titleLabel);

       
        String[] complaintColumnNames = {"Complaint ID", "Username", "Complain Text", "Location", "Source Table"};
        DefaultTableModel complaintModel = new DefaultTableModel(complaintColumnNames, 0);
        JTable complaintTable = new JTable(complaintModel);
        JScrollPane complaintScrollPane = new JScrollPane(complaintTable);
        complaintScrollPane.setBounds(20, 70, 760, 200);
        panel.add(complaintScrollPane);

       
        JButton showDetailsButton = new JButton("Show Details");
        showDetailsButton.setBackground(new Color(128, 128, 128));
        showDetailsButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        showDetailsButton.setBounds(20, 290, 150, 30);
        panel.add(showDetailsButton);

        

        ImageIcon ik1 = new ImageIcon("an.png");
        Image image1 = ik1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel il1 = new JLabel(new ImageIcon(image1));
        il1.setBounds(526, 495, 185, 163);
        panel.add(il1);
        
        JLabel detailsLabel = new JLabel("Crime Report Details:");
        detailsLabel.setBounds(20, 330, 200, 30);
        panel.add(detailsLabel);

        JTextArea reportDetailsArea = new JTextArea();
        reportDetailsArea.setBounds(20, 360, 760, 100);
        reportDetailsArea.setEditable(false);
        panel.add(reportDetailsArea);
        
        JButton btnNewButton_1 = new JButton("Close Case--->");
        btnNewButton_1.setBackground(new Color(168, 168, 168));
        btnNewButton_1.setBounds(20, 498, 136, 30);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	      cards.show(container, "reportedcrime");
        	}
        });
        panel.add(btnNewButton_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(180, 304, 585, 30);
        panel.add(separator);
        
        JLabel lblNewLabel = new JLabel("<html>Track the status of your reported complaints.<br>Stay updated with the progress and resolution of each issue.</html>");
        lblNewLabel.setForeground(new Color(128, 128, 128));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(170, 547, 332, 68);
        panel.add(lblNewLabel);

        
        showDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = complaintTable.getSelectedRow();
                if (selectedRow != -1) {
                    
                    int complaintId = (int) complaintTable.getValueAt(selectedRow, 0);
                    String sourceTable = (String) complaintTable.getValueAt(selectedRow, 4); 

                    
                    loadDescriptionAndDisplay(complaintId, sourceTable, reportDetailsArea);
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select a complaint first.");
                }
            }
        });

     
        loadComplaintsDataFromDatabase(complaintModel);

        return panel;
    }

    private void loadComplaintsDataFromDatabase(DefaultTableModel model) {
        String url = "jdbc:mysql://localhost:3306/police"; 
        String user = "root";
        String password = "root"; 

        String query1 = "SELECT id, username, complain_text, location, 'complaints' AS source_table FROM complaints";
        String query2 = "SELECT id, name AS username, crime AS complain_text, location, 'complaint' AS source_table FROM complaint";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            model.setRowCount(0);

            ResultSet rs = stmt.executeQuery(query1);
            addComplaintsToModel(rs, model);

            rs = stmt.executeQuery(query2);
            addComplaintsToModel(rs, model);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading complaints data from the database.");
        }
    }

    private void addComplaintsToModel(ResultSet rs, DefaultTableModel model) throws Exception {
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username"); 
            String complainText = rs.getString("complain_text");
            String location = rs.getString("location"); 
            String sourceTable = rs.getString("source_table"); 

            model.addRow(new Object[]{id, username, complainText, location, sourceTable});
        }
    }

    private void loadDescriptionAndDisplay(int complaintId, String sourceTable, JTextArea reportDetailsArea) {
        String url = "jdbc:mysql://localhost:3306/police";
        String user = "root"; 
        String password = "root"; 

        String query;
        if ("complaints".equals(sourceTable)) {
            query = "SELECT complain_text FROM complaints WHERE id = " + complaintId;
        } else {
            query = "SELECT crime FROM complaint WHERE id = " + complaintId;
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                String description = rs.getString(1); 
                reportDetailsArea.setText(description);
            } else {
                reportDetailsArea.setText("No description available.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading description from the database.");
        }
    }
}
