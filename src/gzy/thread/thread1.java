package gzy.thread;

/**
 * Created by gzy on 2018/5/17.
 */
public class thread1 {
    public static void main(String[] args) {
        // Create two Thread objects
        Thread t1 = new Thread(thread1::print);
        Thread t2 = new Thread(thread1::print);

        // Start both threads
        t1.start();
        t2.start();
    }

    public static void print() {
        for (int i = 1; i <= 500; i++) {
            System.out.println(i);
        }
    }
}
