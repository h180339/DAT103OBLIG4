package no.hvl.dat103;


public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        int full = 0;
        int mutex = 1;
        int empty = 10;
        MyGlobalVariables myGlobalVariables = new MyGlobalVariables(full, mutex, empty);
        Thread consumer = new Thread(new Phil1(buffer, myGlobalVariables));
        Thread producer = new Thread(new Producer(buffer, myGlobalVariables));

        producer.start();
        consumer.start();
    }
}
