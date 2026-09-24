public class FindMyAge {
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
