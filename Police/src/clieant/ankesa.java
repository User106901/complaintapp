package clieant;

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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import notlogged.UserSession;

public class ankesa {
    private JPanel container;
    private CardLayout cards;
    private String username;

    public ankesa(JPanel container, CardLayout cards, String username) {
        this.container = container;
        this.cards = cards;
    }

    /**
     * @wbp.parser.entryPoint
     */
    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(200, 50, 800, 750);
        panel.setBackground(new Color(192, 192, 192));

        JButton viewComplaintsButton = new JButton("View Complaints");
        viewComplaintsButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        viewComplaintsButton.setBounds(34, 321, 168, 30);
        panel.add(viewComplaintsButton);

        DefaultTableModel complaintsTableModel = new DefaultTableModel(new String[]{"Complain Text", "Location", "Time", "Status"}, 0);
        JTable complaintsTable = new JTable(complaintsTableModel);
        complaintsTable.setFillsViewportHeight(true);
        complaintsTable.setRowHeight(25);
        complaintsTable.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane tableScrollPane = new JScrollPane(complaintsTable);
        tableScrollPane.setBounds(34, 86, 700, 200);
        panel.add(tableScrollPane);

        JLabel lblNewLabel = new JLabel("Ankesat Tuaja :");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(22, 20, 183, 30);
        panel.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(34, 60, 727, 10);
        panel.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(216, 333, 518, 10);
        panel.add(separator_1);
        
        JLabel lblNewLabel_1 = new JLabel("<html>Your complaints are securely stored and handled with the utmost confidentiality, ensuring your privacy. \r\n        We manage complaints efficiently to guarantee a swift and transparent resolution process. \r\n        By submitting a complaint, you help improve safety and accountability in our community.</html>");
        lblNewLabel_1.setForeground(new Color(128, 128, 128));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(34, 371, 700, 95);
        panel.add(lblNewLabel_1);

        DefaultTableModel doneTableModel = new DefaultTableModel(new String[]{"Case ID", "Status"}, 0);

        viewComplaintsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recentUsername = UserSession.getInstance().getUsername();
                if (recentUsername != null && !recentUsername.isEmpty()) {
                    String query = "SELECT complain_text, location, time, status FROM complaints WHERE username = ?";
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/police", "root", "root");
                         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, recentUsername);
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            complaintsTableModel.setRowCount(0);  // Clear the table before loading new data
                            boolean dataFound = false;
                            while (resultSet.next()) {
                                String complainText = resultSet.getString("complain_text");
                                String location = resultSet.getString("location");
                                String time = resultSet.getString("time");
                                String status = resultSet.getString("status");
                                if (status == null || status.isEmpty()) {
                                    status = "Pending";
                                }
                                complaintsTableModel.addRow(new Object[]{complainText, location, time, status});
                                dataFound = true;
                            }
                            if (!dataFound) {
                                JOptionPane.showMessageDialog(panel, "No complaints found for this user", "No Data", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(panel, "Error loading complaints!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "No recent login found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return panel;
    }
}

