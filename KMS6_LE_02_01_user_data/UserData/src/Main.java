
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // Create Scanner Object for user input
        Scanner userScanner = new Scanner(System.in);

        // Prompt user for first name input
        System.out.println("Enter your first name: ");

        // Read the string input
        String firstName = userScanner.nextLine();

        // Prompt user for last name input
        System.out.println("Enter you last name: ");

        // Read the string input
        String lastName = userScanner.nextLine();

        // Prompt user for age input
        System.out.println("Enter your age: ");

        // Read the age input from user
        int age = userScanner.nextInt();

        // Create an object of the User class
        User user_1 = new User(firstName, lastName, age);

        // Output the modified data
        user_1.print_modified();



        // Close the scanner
        userScanner.close();

    }
}
