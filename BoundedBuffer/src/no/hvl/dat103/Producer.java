package no.hvl.dat103;

import java.util.Random;

/**
 * A producer that produces items and add items to a shared buffer. The item
 * type is int.
 *
 * @author Atle Geitung
 * @version 15.05.2018 C++ version
 * @version 30.08.2018 Java version
 */
public class Producer extends Thread {

    private Buffer buffer;
    Random rand = new Random();

    /**
     * Constructs a new producer.
     *
     * @param buffer The shared buffer
     */
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    /**
     * Runs the producer
     * Adds items to the buffer when it has space and prints them
     */
    @Override
    public void run() {
        while (true) {
            while(((buffer.in + 1) % buffer.BUFFERSIZE) == buffer.out) {
                //do nothing
            }
            synchronized (this) {
                Integer item = rand.nextInt(100);
                buffer.buffer[buffer.in] = item;
                buffer.in = (buffer.in + 1) % buffer.BUFFERSIZE;
                System.out.println("Produced: " + item);
            }
            try {
                sleep(1);
            } catch (InterruptedException e) {
                // ignore
            }
        }
    }
}
