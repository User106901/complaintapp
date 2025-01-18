package policepac;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class officerassigment {
    private JPanel container;
    private CardLayout cards;

    public officerassigment(JPanel container, CardLayout cards) {
        this.container = container;
        this.cards = cards;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JPanel getPanel() {
        JPanel assignmentOfficersPanel = new JPanel();
        assignmentOfficersPanel.setLayout(null);
        assignmentOfficersPanel.setBounds(0, 0, 800, 800);
        assignmentOfficersPanel.setBackground(Color.LIGHT_GRAY);

        
        JLabel titleLabel = new JLabel("Assignment Officers");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(20, 20, 300, 30); 
        assignmentOfficersPanel.add(titleLabel);

        JLabel officerListLabel = new JLabel("Available Officers:");
        officerListLabel.setBounds(20, 100, 200, 30); 
        assignmentOfficersPanel.add(officerListLabel);

        DefaultTableModel officerTableModel = new DefaultTableModel(
            new String[] {"ID", "Name", "Specialization"}, 0);
        JTable officerTable = new JTable(officerTableModel);
        JScrollPane officerScrollPane = new JScrollPane(officerTable);
        officerScrollPane.setBounds(20, 140, 740, 200); 
        assignmentOfficersPanel.add(officerScrollPane);

        JLabel complaintsLabel = new JLabel("Complaints:");
        complaintsLabel.setBounds(20, 360, 200, 30);
        assignmentOfficersPanel.add(complaintsLabel);

        DefaultTableModel complaintTableModel = new DefaultTableModel(
            new String[] {"ID", "Name", "Specialization"}, 0); 
        JTable complaintTable = new JTable(complaintTableModel);
        JScrollPane complaintScrollPane = new JScrollPane(complaintTable);
        complaintScrollPane.setBounds(20, 400, 740, 200);
        assignmentOfficersPanel.add(complaintScrollPane);

        JLabel caseIDLabel = new JLabel("Case ID:");
        caseIDLabel.setBounds(20, 620, 100, 30);
        assignmentOfficersPanel.add(caseIDLabel);

        JTextField caseIDField = new JTextField();
        caseIDField.setBounds(100, 620, 200, 30);
        assignmentOfficersPanel.add(caseIDField);

        JLabel officerNameLabel = new JLabel("Officer Name:");
        officerNameLabel.setBounds(320, 620, 100, 30);
        assignmentOfficersPanel.add(officerNameLabel);

        JComboBox<String> officerComboBox = new JComboBox<>();
        officerComboBox.setBounds(420, 620, 200, 30);
        assignmentOfficersPanel.add(officerComboBox);

        
        JButton assignButton = new JButton("Assign Officer");
        assignButton.setBounds(20, 670, 150, 30);
        assignmentOfficersPanel.add(assignButton);

        fetchOfficers(officerTableModel, officerComboBox);
        
       
       JLabel quoteLabel = new JLabel("<html>Each complaint is a call for justice, and every officer's assignment is an opportunity to make a difference. By addressing concerns with diligence, we uphold trust and accountability.</html>");
       quoteLabel.setFont(new Font("Arial", Font.ITALIC, 14));
       quoteLabel.setForeground(Color.DARK_GRAY); 
       quoteLabel.setBounds(20, 50, 740, 51);
       quoteLabel.setVerticalAlignment(SwingConstants.TOP); 
       quoteLabel.setHorizontalAlignment(SwingConstants.LEFT); 
       assignmentOfficersPanel.add(quoteLabel);
       
       JButton btnNewButton = new JButton("Load Complaints\r\n");
      
       		btnNewButton.addActionListener(new ActionListener() {
       		    @Override
       		    public void actionPerformed(ActionEvent e) {
       		       
       		        complaintTableModel.setRowCount(0); 
       		        fetchComplaints(complaintTableModel); 
       		    }
       		});

       	
       
       btnNewButton.setBounds(194, 670, 150, 30);
       assignmentOfficersPanel.add(btnNewButton);



        
        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String caseId = caseIDField.getText();  
                String officerName = (String) officerComboBox.getSelectedItem();

                if (caseId.isEmpty() || officerName == null) {
                    JOptionPane.showMessageDialog(null, "Please select a case and officer.");
                    return;
                }

                assignOfficerToCase(caseId, officerName);  
                }
        });

        return assignmentOfficersPanel;
    }

    private void assignOfficerToCase(String caseId, String officerName) {
        String dbUrl = "jdbc:mysql://localhost:3306/police"; 
        String dbUser = "root"; 
        String dbPassword = "root"; 

        
        String officerQuery = "SELECT officer_id FROM officers WHERE name = ?";
        
        int officerId = -1;

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement officerStatement = connection.prepareStatement(officerQuery)) {

            officerStatement.setString(1, officerName); 
            ResultSet officerResultSet = officerStatement.executeQuery();

            if (officerResultSet.next()) {	
                officerId = officerResultSet.getInt("officer_id");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (officerId == -1) {
            JOptionPane.showMessageDialog(null, "Officer not found.");
            return;
        }

      
        String insertQuery = "INSERT INTO officer_assignments (case_id, officer_id) VALUES (?, ?)";
        String updateQuery = "UPDATE complaints SET status = 'Working' WHERE id = ?";



        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

           
            insertStatement.setInt(1, Integer.parseInt(caseId)); 
            insertStatement.setInt(2, officerId);  

            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Officer assigned successfully.");

                updateStatement.setInt(1, Integer.parseInt(caseId)); 
                int statusUpdateRows = updateStatement.executeUpdate();
                
                if (statusUpdateRows > 0) {
                    JOptionPane.showMessageDialog(null, "Status updated to 'Working' for the case.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update status.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed to assign officer.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while assigning officer and updating status.");
        }
    }

  
    private void fetchOfficers(DefaultTableModel officerTableModel, JComboBox<String> officerComboBox) {
        String dbUrl = "jdbc:mysql://localhost:3306/police";
        String dbUser = "root"; 
        String dbPassword = "root"; 

        String officerQuery = "SELECT officer_id, name, specialization FROM officers";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(officerQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int officerId = resultSet.getInt("officer_id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                officerTableModel.addRow(new Object[]{officerId, name, specialization});
                officerComboBox.addItem(name);  
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

 
    private void fetchComplaints(DefaultTableModel complaintTableModel) {
        String dbUrl = "jdbc:mysql://localhost:3306/police"; 
        String dbUser = "root";
        String dbPassword = "root"; 

        
        String complaintQuery1 = "SELECT id, username, complain_text, location FROM complaints";
        String complaintQuery2 = "SELECT id, name AS username, crime AS complain_text, location FROM complaint";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet1 = statement.executeQuery(complaintQuery1);
            while (resultSet1.next()) {
                int caseId = resultSet1.getInt("id");
                String username = resultSet1.getString("username");
                String complain_text = resultSet1.getString("complain_text");
                String location = resultSet1.getString("location");

                complaintTableModel.addRow(new Object[]{caseId, username, complain_text, location});
            }

            ResultSet resultSet2 = statement.executeQuery(complaintQuery2);
            while (resultSet2.next()) {
                int caseId = resultSet2.getInt("id");
                String username = resultSet2.getString("username");
                String complain_text = resultSet2.getString("complain_text");
                String location = resultSet2.getString("location");

                complaintTableModel.addRow(new Object[]{caseId, username, complain_text, location});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

    