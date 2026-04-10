package service;

import dao.UserDAO;
import java.util.*;
import model.User;

public class UserService {
    public static void addUser(User user) {
        if(user.getSalary()<0){
            System.out.println("Salary cannot be negaive");
            return;
        }
        if(!user.getEmail().contains("@")) {
        System.out.println("Invalid Email");
            return;
        }
        UserDAO.addUser(user);
    }
    public static void updateSalary(int id, double salary) {
        if(salary<0){
            System.out.println("Salary cannot be negaive");
            return;
        }
        UserDAO.updatesalary(id,salary);
    }
    public static void updateEmail(int id, String email) {
        if(!email.contains("@")){
            System.out.println("Invalid email");
            return;
        }
        UserDAO.updateemail(id,email);
    }
    public static ArrayList<User> getAllUsers() {
        return UserDAO.getAllUsers();
    }
    public static void delete(int id) {
        UserDAO.deleteUser(id);
    }
}
