package policepac;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import clieant.article;

import java.awt.Font;

public class closecase {
    private JPanel container;
    private CardLayout cards;

    public closecase(JPanel container, CardLayout cards) {
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

      
        JLabel titleLabel = new JLabel("Assigned Officers to Complaints");
        titleLabel.setBounds(20, 20, 760, 40);
        titleLabel.setFont(titleLabel.getFont().deriveFont(20f));
        panel.add(titleLabel);

      
        String[] officerColumnNames = {"Assignment ID", "Case ID", "Officer ID",};
        DefaultTableModel officerModel = new DefaultTableModel(officerColumnNames, 0);
        JTable officerTable = new JTable(officerModel);
        JScrollPane officerScrollPane = new JScrollPane(officerTable);
        officerScrollPane.setBounds(20, 70, 760, 200);
        panel.add(officerScrollPane);

       
        JButton loadDataButton = new JButton("Load Assigned Officers");
        loadDataButton.setBounds(230, 300, 200, 30);
        panel.add(loadDataButton);

       
        loadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadAssignedOfficersDataFromDatabase(officerModel);
            }
        });

       
        JButton deleteButton = new JButton("Delete Assigned Officer");
        deleteButton.setBounds(20, 300, 200, 30);
        panel.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = officerTable.getSelectedRow();
                if (selectedRow != -1) {
                    int assignmentId = (int) officerTable.getValueAt(selectedRow, 0);
                    deleteAssignedOfficer(assignmentId);
                    loadAssignedOfficersDataFromDatabase(officerModel);
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select an officer first.");
                }
            }
        });

       
        loadAssignedOfficersDataFromDatabase(officerModel);

       

        
        JTextArea quotesArea = new JTextArea();
        quotesArea.setBackground(new Color(192, 192, 192));
        quotesArea.setBounds(20, 385, 760, 80);
        quotesArea.setText("“The police officer is not just a job; it is a commitment to serve and protect the community.”\n“Justice is not a one-time event; it is a continuous process of service and responsibility.”");
        quotesArea.setLineWrap(true);
        quotesArea.setWrapStyleWord(true);
        quotesArea.setEditable(false);
        panel.add(quotesArea);
        
        JLabel lblNewLabel = new JLabel("Follow Us");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(28, 574, 144, 40);
        panel.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Facebook\r\n");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 128, 192));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(28, 644, 124, 30);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		article.openWebpage("https://www.facebook.com");
        	}
        });
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Instagram");
        btnNewButton_1.setBackground(new Color(88, 39, 70));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_1.setBounds(178, 644, 124, 30);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		article.openWebpage("https://www.instagram.com");
        	}
        });
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Twitter");
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        btnNewButton_2.setBackground(new Color(0, 128, 192));
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_2.setBounds(324, 644, 124, 30);
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		article.openWebpage("https://www.twitter.com");
        	}
        });
        panel.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Gmail");
        btnNewButton_3.setBackground(new Color(132, 204, 142));
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_3.setBounds(488, 644, 124, 30);
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		article.openWebpage("https://www.gmail.com");
        	}
        });
        panel.add(btnNewButton_3);
        
        JLabel lblNewLabel_1 = new JLabel("Email Us");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(488, 583, 108, 31);
        panel.add(lblNewLabel_1);
        
        JButton btnNewButton_4 = new JButton("Outlook");
        btnNewButton_4.setForeground(new Color(255, 255, 255));
        btnNewButton_4.setBackground(new Color(141, 198, 207));
        btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_4.setBounds(622, 645, 117, 28);
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		article.openWebpage("https://www.outlook.com");
        	}
        });
        panel.add(btnNewButton_4);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(20, 550, 813, 14);
        panel.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(458, 574, 20, 121);
        panel.add(separator_1);

        return panel;
    }

    private void loadAssignedOfficersDataFromDatabase(DefaultTableModel model) {
        String url = "jdbc:mysql://localhost:3306/police";
        String user = "root";
        String password = "root";

        String query = "SELECT assignment_id, case_id, officer_id FROM officer_assignments";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            model.setRowCount(0);

            while (rs.next()) {
                int assignmentId = rs.getInt("assignment_id");
                int caseId = rs.getInt("case_id");
                int officerId = rs.getInt("officer_id");
               

                model.addRow(new Object[]{assignmentId, caseId, officerId});
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading assigned officers data from the database.");
        }
    }

    private void deleteAssignedOfficer(int assignmentId) {
        String url = "jdbc:mysql://localhost:3306/police";
        String user = "root";
        String password = "root";

        String insertDoneQuery = "INSERT INTO done (case_id, statusi) " +
                "SELECT case_id, 'Addressed' FROM officer_assignments WHERE assignment_id = ?";
String deleteQuery = "DELETE FROM officer_assignments WHERE assignment_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement insertStmt = conn.prepareStatement(insertDoneQuery);
             PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {

            insertStmt.setInt(1, assignmentId);
            int rowsInserted = insertStmt.executeUpdate();

            if (rowsInserted > 0) {
                deleteStmt.setInt(1, assignmentId);
                deleteStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Done");
            } else {
                JOptionPane.showMessageDialog(null, "No assignment found with the given ID.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error deleting assigned officer.");
        }
    }
}