public class BicycleRental {
    public static int culculateCost(int start, int end) {

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

        return total;
    }
}