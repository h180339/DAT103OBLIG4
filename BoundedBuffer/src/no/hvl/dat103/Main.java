package no.hvl.dat103;


public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        MySemaphore full = new MySemaphore(0);
        MySemaphore mutex = new MySemaphore(1);
        MySemaphore empty = new MySemaphore(10);

        Thread consumer = new Thread(new Consumer(full, mutex, empty, buffer));
        Thread producer = new Thread(new Producer(full, mutex, empty, buffer));

        producer.start();
        consumer.start();
    }
}
