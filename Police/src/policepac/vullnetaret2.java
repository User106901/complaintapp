package policepac;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Image;

public class vullnetaret2 {
    private JPanel container;
    private CardLayout cards;
    private JTextField textField_1;
    private JTextField textField_2;

    public vullnetaret2(JPanel container, CardLayout cards) {
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

        panel.setBounds(200, 0, 800, 800);

        JLabel headerLabel = new JLabel("Volunteer Management System");
        headerLabel.setBounds(10, 10, 300, 30);
        panel.add(headerLabel);

        JLabel volunteerLabel = new JLabel("Volunteer Data:");
        volunteerLabel.setBounds(10, 50, 150, 20);
        panel.add(volunteerLabel);

        DefaultTableModel volunteerModel = new DefaultTableModel(
            new String[] { "ID", "Name", "Email", "Age", "Address" }, 0);
        JTable volunteerTable = new JTable(volunteerModel);
        JScrollPane volunteerScrollPane = new JScrollPane(volunteerTable);
        volunteerScrollPane.setBounds(10, 80, 760, 200);
        panel.add(volunteerScrollPane);

        JButton loadVolunteerDataButton = new JButton("Load Volunteer Data");
        loadVolunteerDataButton.setBounds(10, 300, 200, 30);
        panel.add(loadVolunteerDataButton);

        loadVolunteerDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadVolunteerData(volunteerModel);
            }
        });

        JButton addVolunteerButton = new JButton("Export ");
        addVolunteerButton.setBounds(220, 300, 200, 30);
        panel.add(addVolunteerButton);
        
        textField_1 = new JTextField();
        textField_1.setBounds(54, 482, 124, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(54, 538, 124, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Gmail:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 474, 46, 30);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Task:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 529, 52, 30);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Description:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(10, 604, 100, 30);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Notify:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(28, 419, 162, 33);
        panel.add(lblNewLabel_3);
        

        ImageIcon ik1 = new ImageIcon("sd.png");
        Image image1 = ik1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel il1 = new JLabel(new ImageIcon(image1));
        il1.setBounds(473, 438, 182, 154);
        panel.add(il1);
        
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 392, 765, 13);
        panel.add(separator);
       
        JTextPane jtext3 = new JTextPane();
        jtext3.setBounds(120, 611, 209, 75);
        panel.add(jtext3);
        
        JButton btnNewButton = new JButton("Send-->");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(371, 653, 100, 33);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textField_1.getText();  
                String task = textField_2.getText();  
                String description = jtext3.getText();  

               
                if (email.isEmpty() || task.isEmpty() || description.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }

                
                String url = "jdbc:mysql://localhost:3306/police";
                String user = "root";
                String password = "root";

               
                String query = "INSERT INTO ivullnetar (gmail, task, description) VALUES (?, ?, ?)";

                try (Connection conn = DriverManager.getConnection(url, user, password);
                     PreparedStatement stmt = conn.prepareStatement(query)) {

                    stmt.setString(1, email); 
                    stmt.setString(2, task);  
                    stmt.setString(3, description);  

                   
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(panel, "Task assigned successfully.");
                        textField_1.setText("");  
                        textField_2.setText("");  
                        jtext3.setText("");  
                    } else {
                        JOptionPane.showMessageDialog(panel, "Failed to assign task.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error assigning task.");
                }
            }
        });
        

        panel.add(btnNewButton);
        
        JLabel lblNewLabel_4 = new JLabel("<html>Empower volunteers by assigning meaningful tasks.<br>Together, we make a difference in the community.</html>");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4.setForeground(new Color(128, 128, 128));
        lblNewLabel_4.setBounds(241, 485, 257, 86);
        panel.add(lblNewLabel_4);
        
        


        return panel;
    }

   
    private void loadVolunteerData(DefaultTableModel volunteerModel) {
        String url = "jdbc:mysql://localhost:3306/police"; 
        String user = "root"; 
        String password = "root"; 

        String query = "SELECT id, name, email, age, address FROM volunteers"; 

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            volunteerModel.setRowCount(0);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                String address = rs.getString("address");

                volunteerModel.addRow(new Object[] { id, name, email, age, address });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading volunteer data.");
        }
    }
}

