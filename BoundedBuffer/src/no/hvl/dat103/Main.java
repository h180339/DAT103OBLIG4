package no.hvl.dat103;

/**
 * The Main class
 * @author Gruppe 5
 * @version 1.0.0 The finalest final version
 */
public class Main {

    /**
     * Runs two threads that puts items into a buffer
     * @param args String arguments to the executable, not used
     */
    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        Thread consumer = new Thread(new Consumer(buffer));
        Thread producer = new Thread(new Producer(buffer));

        producer.start();
        consumer.start();
    }
}
