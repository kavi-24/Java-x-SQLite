import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class create_table {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:sample.db";
        String sql = "CREATE TABLE EMP (ID INT, NAME TEXT, AGE INT);";
        try (
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
        ) {
            stmt.execute(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.out.println(e);
        }  
    }
}
