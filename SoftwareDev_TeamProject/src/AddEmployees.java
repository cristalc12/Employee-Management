import java.sql.*;
import java.util.Scanner;

public class AddEmployees {

    private static String url = "jdbc:mysql://loalhost:3306/employeedata";
    private static String user = "root";
    private static String password = "@Asc987654321";

    private static void add() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String fname = input.nextLine();
        System.out.print("Ener Last Name: ");
        String lname = input.nextLine();
        System.out.print("Enter email: ");
        String email = input.nextLine();
        System.out.print("Enter hire date (YYYY-MM-DD): ");
        String hireDate = input.nextLine();
        System.out.print("Enter Salary: ");
        double salary = input.nextDouble();
        System.out.print("Enter Employee SSN (no dashes): ");
        String ssn = input.nextLine();

        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection(url, user, password);
            myConn.setAutoCommit(false);

            String SQLemployee = "INSERT INTO employees (Fname, Lname, email, HireDate, Salary, ssn) VALUES (?, ?, ?, ?, ?, ?)";
        }
    }
}