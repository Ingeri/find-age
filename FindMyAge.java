import java.util.Scanner;

public class FindMyAge {
    public static void main(String[] args) {

        // Variables
        int birthDay = 15;
        int userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess for the birth day (1-31): ");
        userInput = scanner.nextInt();

        // Create an instance of FindMyAge
        FindMyAge ageFinder = new FindMyAge();
        ageFinder.findage(birthDay, userInput);

        scanner.close();
    }

    public void findage(int birthDay, int userInput) {

        if (userInput < 1 || userInput > 31) {
            System.out.println("Invalid input. Please enter a number between 1 and 31.");
        } else {
            if (userInput < birthDay) {
                System.out.println("Try upper number");
            } else if (userInput > birthDay) {
                System.out.println("Try lower number");
            } else {
                System.out.println("Correct guess!");
            }
        }
    }
}
