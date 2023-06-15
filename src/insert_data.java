import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class insert_data {
    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        try (
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement stmt = conn.createStatement();
            ) {
                System.out.print("Press Y To Input Values Or N To Exit: ");
                while (scanner.next().toUpperCase().charAt(0) == 'Y') {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    stmt.executeUpdate("INSERT INTO EMP VALUES (" + id + ", '" + name + "', " + age + ");");
                    System.out.println("Data inserted successfully...");
                    System.out.print("Press Y To Input Values Or N To Exit: ");
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
import java.sql.PreparedStatement;
class InsertApp {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String name, double capacity) {
        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("Raw Materials", 3000);
        app.insert("Semifinished Goods", 4000);
        app.insert("Finished Goods", 5000);
    }
}
*/