import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Company Z's Employee DataBase!");
        System.out.println("************************************************************");
        System.out.println("1.) Show Employee Table");
        System.out.println("2.) Add Employee");
        System.out.println("3.) Update Employee Information");
        System.out.println("4.) Delete Employee");
        System.out.println("************************************************************");
        System.out.print("Select an option to get started: ");

        int option = input.nextInt();

        switch (option) {
            case 1:
                ShowEmployees.show();
                break;
            case 2:
                AddEmployees.add();
                break;
            case 3:
                // Update Employee
                break;
            case 4:
                // Delete Employee
                break;
            default:
                System.out.println("That's not a valid option. Please read and try again.");
                break;
        }
    }
}