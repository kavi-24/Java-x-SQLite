import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class select_data {
    public static void main(String[] args) {
        try (
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID, NAME, AGE FROM EMP;")
            ) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
