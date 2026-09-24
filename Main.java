import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("This is a simple Java program.");


        // Variables
        int birthDay = 15; // Example birth day
        int userInput;// Example user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess for the birth day (1-31): ");
        userInput = scanner.nextInt();

        // Create an instance of FindMyAge
        FindMyAge ageFinder = new FindMyAge();
        ageFinder.findage(birthDay, userInput);

        scanner.close();
    }
}   