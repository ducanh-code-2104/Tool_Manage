
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ToolManager {

    public static void main(String[] args) {

        String sql = """
            SELECT
                t.tool_name,
                p.part_number,
                s.serial_number,
                s.status
            FROM tools t
            JOIN part_numbers p
                ON t.tool_id = p.tool_id
            JOIN serial_numbers s
                ON p.part_id = s.part_id
            ORDER BY t.tool_name, p.part_number
            """;

        try (Connection conn =
                    DatabaseConnection.getConnection();
             PreparedStatement stmt =
                    conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println(
                "===== DANH SACH DUNG CU =====");

            while (rs.next()) {

                System.out.println("-------------------");

                System.out.println(
                    "Tool Name: " +
                    rs.getString("tool_name"));

                System.out.println(
                    "Part Number: " +
                    rs.getString("part_number"));

                System.out.println(
                    "Serial Number: " +
                    rs.getString("serial_number"));

                System.out.println(
                    "Status: " +
                    rs.getString("status"));
            }

        } catch (SQLException e) {
            System.out.println(
                "LOI DOC DU LIEU MYSQL:");
            System.out.println(e.getMessage());
        }
    }
}
