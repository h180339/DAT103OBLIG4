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

    Random rand = new Random();
    private MyGlobalVariables mgv;
    private Buffer buffer;

    public Producer(Buffer buffer, MyGlobalVariables mgv) {
        this.mgv = mgv;
        this.buffer = buffer;
    }


    @Override
    public void run() {
        do {
            Integer item = rand.nextInt(100);
            buffer.vent(StringConstants.EMPTY, mgv);
            buffer.vent(StringConstants.MUTEX, mgv);
            buffer.addToList(item);
            buffer.signal(StringConstants.MUTEX, mgv);
            buffer.signal(StringConstants.FULL, mgv);
        }while (true);
    }
}
