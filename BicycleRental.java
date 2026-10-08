import java.util.Scanner;

public class BicycleRental {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter starting time (0-23): ");
        int start = input.nextInt();

        System.out.print("Enter ending time (1-24): ");
        int end = input.nextInt();

        int total = 0;

        for (int hour = start; hour < end; hour++) {

            int rate;

            if (hour < 7 || hour >= 21) {
                rate = 500;
            } else if (hour < 14 || hour >= 19) {
                rate = 1000;
            } else {
                rate = 1500;
            }

            total += rate;
        }

        System.out.println("Total rental cost: " + total + " RWF");

        input.close();
    }
}