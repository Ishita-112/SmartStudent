import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "$alambagh@567"; // Replace with your actual password

    // Method to get database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Main method to test the connection
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.out.println(" Connected to the database successfully!");
            conn.close(); // Close connection after test
        } catch (SQLException e) {
            System.out.println(" Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}





