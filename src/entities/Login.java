package entities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    private Connection con;
    private Scanner sc;
	public Login(Connection conn, Scanner scanner) {
		this.con=conn;
		this.sc=scanner;
	}
	public void signup(String userType) {
    	System.out.println("Lets create account");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        String insertQuery;
        if ("user".equalsIgnoreCase(userType)) {
            insertQuery = "insert into user (user_name,user_mail, password) VALUES (?, ?, ?)";
        }
        else if ("analyst".equalsIgnoreCase(userType)) {
            insertQuery = "insert into analyst (analyst_name,analyst_mail, password) VALUES (?, ?, ?)";
        }
        else {
            System.out.println("Invalid user type.");
            return;
        }
        try (PreparedStatement statement = con.prepareStatement(insertQuery)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(userType + "signup successful");
                boolean loginstatus = login(userType);
                if (!loginstatus) {
                    System.out.println("Automatic login after signup failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean login(String userType) {
    	System.out.println("enter credentials to login");
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        String selectQuery;
        if ("user".equalsIgnoreCase(userType)) {
            selectQuery = "select*from user where user_mail=? and password=?";
        }
        else if ("analyst".equalsIgnoreCase(userType)) {
            selectQuery = "select*from analyst where analyst_mail=?AND password =?";
        }
        else {
            System.out.println("Invalid user type.");
            return false;
        }
        try (PreparedStatement statement = con.prepareStatement(selectQuery)){
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()){
                    System.out.println("login successful" + "welcome"+resultSet.getString("name"));
                    return true;
                }else {
                    System.out.println("Login failed. Incorrect email or password.");
                    return false;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
