package no.hvl.dat103;

import java.util.Random;

public class Producer extends Thread {

    private Random rand = new Random();
    private MySemaphore full;
    private MySemaphore mutex;
    private MySemaphore empty;
    private Buffer buffer;
    int bufferSize;

    public Producer(MySemaphore full, MySemaphore mutex, MySemaphore empty, Buffer buffer) {
        this.full = full;
        this.mutex = mutex;
        this.empty = empty;
        this.buffer = buffer;
        bufferSize = empty.getTall() -1;

    }


    @Override
    public void run() {
        do {
            Integer item = rand.nextInt(100);
            if(buffer.getList().size() < bufferSize) {
                empty.vent();
                mutex.vent();
                buffer.addToList(item);
                mutex.signal();
                full.signal();
            }


            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /*
            buffer.vent(StringConstants.EMPTY, mgv);
            buffer.vent(StringConstants.MUTEX, mgv);
            buffer.addToList(item);
            buffer.signal(StringConstants.MUTEX, mgv);
            buffer.signal(StringConstants.FULL, mgv);
            */
        }while (true);
    }
}
