//package DiningPhilosophers;
import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    private static final int NUM_PHILOSOPHERS = 5;
    private static final int MEALS_TO_EAT = 2; // Number of times each philosopher eats before stopping
    private static final Semaphore[] chopsticks = new Semaphore[NUM_PHILOSOPHERS];

    static class Philosopher extends Thread {
        private final int id;
        private final Semaphore leftChopstick;
        private final Semaphore rightChopstick;

        public Philosopher(int id) {
            this.id = id;
            // Resource hierarchy: pick lower numbered chopstick first to prevent deadlock
            if (id == NUM_PHILOSOPHERS - 1) {
                this.leftChopstick = chopsticks[0];
                this.rightChopstick = chopsticks[id];
            } else {
                this.leftChopstick = chopsticks[id];
                this.rightChopstick = chopsticks[id + 1];
            }
        }

        @Override
        public void run() {
            int mealsEaten = 0;
            try {
                while (mealsEaten < MEALS_TO_EAT) {
                    System.out.println("Philosopher " + id + " is thinking.");
                    Thread.sleep((long) (Math.random() * 1000));

                    System.out.println("Philosopher " + id + " is hungry.");
                    leftChopstick.acquire();
                    rightChopstick.acquire();

                    // Eating
                    System.out.println("Philosopher " + id + " is eating." + " (Meal " + (mealsEaten + 1) + ")");
                    Thread.sleep((long) (Math.random() * 1000));

                    rightChopstick.release();
                    leftChopstick.release();
                    System.out.println("Philosopher " + id + " finished eating and put down chopsticks.");
                    mealsEaten++;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            philosophers[i] = new Philosopher(i);
            philosophers[i].start();
        }

        // Wait for all philosophers to finish their meals
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            philosophers[i].join();
        }

        System.out.println("All philosophers have finished eating. Simulation ended successfully!");
    }
}