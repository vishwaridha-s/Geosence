package interfaces;

import entities.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/eventmanagement";
    private static final String USER = "root";
    private static final String PASSWORD = "IamGroot3007#";
    static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {
        boolean isAuthenticated = false; // Declare the boolean variable
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("=========================================");
            System.out.println("================GEOSENCE=================");
            System.out.println("=========================================");
            System.out.println("Enter choice:");
            System.out.println("1. Signup");
            System.out.println("2. Login");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter user type (user or analyst):");
            String userType = scanner.nextLine();
            Login log = new Login(conn,scanner);
            if (choice == 1) {
                log.signup(userType);
                isAuthenticated = true;
            }
            else if (choice == 2) {
                isAuthenticated = log.login(userType);
            }
            else {
                System.out.println("Invalid option selected.");
            }
            if (isAuthenticated) {
                displayMenu(userType);
            }
            else {
                System.out.println("Authentication failed. Please try again.");
            }

        }catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
    public static void displayMenu(String userType){
    	if(userType.equalsIgnoreCase("user")) {
    		System.out.println("1.checkWhether");
    		System.out.println("2.viewReport");
    		int operation=scanner.nextInt();
    		switch(operation) {
	    		case 1:
	    			break;
	    		case 2:
	    			break;
	    		default:
	    			System.out.println("enter valid choice");
	    			displayMenu(userType);
    		}
    	}
    	else if(userType.equalsIgnoreCase("analyst")) {
    		System.out.println("1.generatewhetherreport");
    		System.out.println("2.generateresourcereport");
    		System.out.println("3.addwhether data");
    		System.out.println("4.addresourcedata");
    		int operation=scanner.nextInt();
    		switch(operation) {
	    		case 1:
	    			break;
	    		case 2:
	    			break;
	    		case 3:
	    			break;
	    		case 4:
	    			break;
	    		default:
	    			System.out.println("enter valid choice");
	    			displayMenu(userType);
    		}
    	}
    }
}
