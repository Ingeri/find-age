//package MonitorDemo;
class BoundedBufferMonitor {
    private final int[] buffer = new int[5];
    private int count = 0, head = 0, tail = 0;
    private final int capacity = 5;

    // Synchronized methods enforce mutual exclusion (Monitor behavior)
    public synchronized void produce(int item) throws InterruptedException {
        while (count == capacity) {
            wait(); // Equivalent to condition variable Wait()
        }
        buffer[tail] = item;
        tail = (tail + 1) % capacity;
        count++;
        System.out.println("Monitor Produced: " + item);
        notifyAll(); // Wake up waiting consumers
    }

    public synchronized int consume() throws InterruptedException {
        while (count == 0) {
            wait(); // Wait until items are available
        }
        int item = buffer[head];
        head = (head + 1) % capacity;
        count--;
        System.out.println("Monitor Consumed: " + item);
        notifyAll(); // Wake up waiting producers
        return item;
    }
}

public class MonitorDemo {
    public static void main(String[] args) {
        BoundedBufferMonitor monitor = new BoundedBufferMonitor();

        Thread p = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) monitor.produce(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread c = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) monitor.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        p.start();
        c.start();
    }
}