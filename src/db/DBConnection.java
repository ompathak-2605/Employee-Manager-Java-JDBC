package db;
import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/startersql";
    private static final String USER = "om";
    private static final String PASSWORD = "Ompathak@18";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}