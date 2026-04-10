
import dao.UserDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("\n =========Menu========");
            System.out.println("1. Enter User");
            System.out.println("2. View User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");

            System.out.print("Enter choice : ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter gender(Male/Female/others): ");
                    String gender = sc.nextLine();
                    System.out.print("Enter dob(YYYY/MM/DD): ");
                    String dob = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    Double salary = sc.nextDouble();
                    User user = new User(0, name, email, gender, dob, salary, true);
                    UserDAO.addUser(user);
                }

                case 2 -> {
                    ArrayList<User> users = UserDAO.getAllUsers();
                    for (User u : users) {
                        System.out.println(
                                u.getId() + "|"
                                + u.getName() + "|"
                                + u.getEmail() + "|"
                                + u.getGender() + "|"
                                + u.getdateofbirth() + "|"
                                + u.getSalary()
                        );
                    }
                }
                case 3 -> {
                    System.out.println("Fields available for update: ");
                    System.out.println("1. Salary");
                    System.out.println("2. Email");
                    System.out.println("Enter your choice");
                    int c = sc.nextInt();
                    switch (c) {
                        case 1: {
                            System.out.println("Enter user id");
                            int id = sc.nextInt();
                            System.out.println("Enter updated salary");
                            double salary = sc.nextDouble();

                            UserDAO.updatesalary(id, salary);
                            break;
                        }
                        case 2: {
                            System.out.println("Enter user id");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter updated email");
                            String email = sc.nextLine();

                            UserDAO.updateemail(id, email);
                            break;
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Enter user id to delete:");
                    int id = sc.nextInt();

                    UserDAO.deleteUser(id);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default ->
                    System.out.println("Invalid choice!");
            }
        }

    }
}
