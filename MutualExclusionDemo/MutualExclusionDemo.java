//package MutualExclusionDemo;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutualExclusionDemo {
    private static int sharedCounter = 0;
    private static final Lock mutex = new ReentrantLock();

    static class WorkerThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                mutex.lock(); // Acquire mutual exclusion lock
                try {
                    // Critical Region
                    sharedCounter++; 
                } finally {
                    mutex.unlock(); // Release lock
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new WorkerThread();
        Thread t2 = new WorkerThread();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Expected Counter: 2000");
        System.out.println("Actual Final Counter: " + sharedCounter);
    }
}