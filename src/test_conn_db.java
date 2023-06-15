import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connect {
    public static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:sample.db";
            conn = DriverManager.getConnection(url);

            DatabaseMetaData meta = conn.getMetaData();
            
            System.out.println("Connection to SQLite has been established. Driver details: " + meta.getDriverName() + " " + meta.getDriverVersion());

            conn.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        connect();
    }
}