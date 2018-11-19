package no.hvl.dat103;

public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        Thread consumer = new Thread(new Consumer(buffer));
        Thread producer = new Thread(new Producer(buffer));

        producer.start();
        consumer.start();
    }
}
