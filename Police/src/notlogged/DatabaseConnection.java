package notlogged;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/police";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

	
		

		public static boolean authenticateUser(String username, String password2) {
			try (Connection connection = DatabaseConnection.getConnection()) {
	            String sql = "SELECT * FROM user_data WHERE username = ? AND password = ?";
	            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	                stmt.setString(1, username);
	                stmt.setString(2, PASSWORD);
	                ResultSet resultSet = stmt.executeQuery();
	                if (resultSet.next()) {
	                    return true; 
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return false;
		}

		
}

