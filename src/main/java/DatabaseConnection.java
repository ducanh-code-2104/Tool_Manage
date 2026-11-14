
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/tool_management";

    private static final String USER = "root";

    private static final String PASSWORD =
        System.getenv("TOOL_DB_PASSWORD");;

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL, USER, PASSWORD);
    }
    public static void main(String[] args) {System.out.println(
    "Password configured: " +
    (PASSWORD != null && !PASSWORD.isEmpty())
);
        try (Connection conn = getConnection()) {
            System.out.println("KET NOI MYSQL THANH CONG!");
        } catch (SQLException e) {
            System.out.println("KET NOI THAT BAI!");
            System.out.println(e.getMessage());
        }
    }

}
