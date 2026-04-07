package model;

public class User {

    private int id;
    private String name;
    private String email;
    private String gender;
    private String dateofbirth;
    private double salary;
    private boolean isActive;

    public User(int id, String name, String email, String gender,String dateofbirth, double salary, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.salary = salary;
        this.isActive = isActive;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getGender() { return gender; }
    public String getdateofbirth() {return dateofbirth; }
    public double getSalary() { return salary; }
    public boolean isActive() { return isActive; }
}