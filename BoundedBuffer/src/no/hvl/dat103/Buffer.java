package no.hvl.dat103;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

/**
 * A shared buffer for consumers and producers. The item type is int. The buffer
 * is implemented by using a double ended queue.
 * @author Atle Geitung
 * @version 30.08.2018 Java version
 */
public class Buffer {

    public final static int BUFFERSIZE = 10;

    public Integer[] buffer;
    public int in;
    public int out;

    /**
     * Makes a buffer
     */
    public Buffer() {
        buffer = new Integer[BUFFERSIZE];
        in = 0;
        out = 0;
    }
}
