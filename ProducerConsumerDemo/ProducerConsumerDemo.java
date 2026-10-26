import java.util.concurrent.Semaphore;

public class ProducerConsumerDemo {
    private static final int BUFFER_SIZE = 5;
    private static final int[] buffer = new int[BUFFER_SIZE];
    private static int in = 0, out = 0;
    private static final int TARGET_ITEMS = 10; // Limit for items to produce & consume

    // Semaphores matching Chapter 4 specifications
    private static final Semaphore mutex = new Semaphore(1);
    private static final Semaphore empty = new Semaphore(BUFFER_SIZE);
    private static final Semaphore full = new Semaphore(0);

    static class Producer extends Thread {
        @Override
        public void run() {
            int item = 0;
            try {
                // Stop producing once we reach the target
                while (item < TARGET_ITEMS) {
                    empty.acquire(); 
                    mutex.acquire(); 
                    
                    buffer[in] = ++item;
                    System.out.println("Produced: " + buffer[in] + " at index " + in);
                    in = (in + 1) % BUFFER_SIZE;
                    
                    mutex.release();  
                    full.release();  
                    
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            int consumedCount = 0;
            try {
                // Stop consuming once we reach the target
                while (consumedCount < TARGET_ITEMS) {
                    full.acquire();  
                    mutex.acquire(); 
                    
                    int item = buffer[out];
                    consumedCount++;
                    System.out.println("Consumed: " + item + " from index " + out);
                    out = (out + 1) % BUFFER_SIZE;
                    
                    mutex.release();  
                    empty.release(); 
                    
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        producer.start();
        consumer.start();

        // Wait for both threads to finish their execution
        producer.join();
        consumer.join();

        System.out.println("All items produced and consumed. Program finished successfully!");
    }
}