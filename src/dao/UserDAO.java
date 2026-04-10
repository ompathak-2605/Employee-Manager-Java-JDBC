package dao;

import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import model.User;

public class UserDAO {

    public static ArrayList<User> getAllUsers() {

        ArrayList<User> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();) {
            

            String sql = "SELECT * FROM users WHERE is_active = true";
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

            

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return list;
    }

    public static void addUser(User user) {

        try(Connection con = DBConnection.getConnection();) {
            

            String sql = "INSERT INTO users (name, email, gender,date_of_birth, salary, is_active) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getdateofbirth());
            ps.setDouble(5, user.getSalary());
            ps.setBoolean(6, user.isActive());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User inserted successfully ");
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    

    public static void updatesalary(int id, double salary) {

        try(Connection con = DBConnection.getConnection();) {
            String sql = "UPDATE users SET salary = ? WHERE id = ?";
            PreparedStatement p = con.prepareStatement(sql);

            p.setDouble(1, salary);
            p.setInt(2, id);

            int row = p.executeUpdate();
            if (row > 0) {
                System.out.println("Update sucessful");
            } else {
                System.out.println("Somthing went wrong");
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

    }

    public static void updateemail(int id, String email) {
        
        try(Connection con = DBConnection.getConnection();){
            
            String sql = "UPDATE users SET email = ? WHERE ID = ?";
            PreparedStatement p = con.prepareStatement(sql);

            p.setString(1, email);
            p.setInt(2, id);

            int row = p.executeUpdate();
            if(row>0){
                System.out.println("Update Sucessfull");
             }
             else System.out.println("Somthing went wrong");
             con.close();
        }
        
         catch (SQLException e){
            System.out.println("Database error: "+e.getMessage());
        }
    }
    public static void deleteUser(int id) {

    try(Connection con = DBConnection.getConnection();) {

        String sql = "UPDATE users SET is_active = false WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("User deleted (soft delete) ");
        } else {
            System.out.println("User not found ");
        }

        con.close();

    } catch (SQLException e) {
        System.out.println("Database error: " + e.getMessage());
    }
}
}
