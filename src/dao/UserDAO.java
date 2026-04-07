package  dao;

import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import model.User;

public class UserDAO {

    public static ArrayList<User> getAllUsers() {

        ArrayList<User> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getString("Date_of_birth"),
                        rs.getDouble("salary"),
                        rs.getBoolean("is_active")
                );

                list.add(user);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public static void addUser(User user) {

    try {
        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO users (name, email, gender,date_of_birth, salary, is_active) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getGender());
        ps.setString(4,user.getdateofbirth());
        ps.setDouble(5, user.getSalary());
        ps.setBoolean(6, user.isActive());

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("User inserted successfully ");
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}