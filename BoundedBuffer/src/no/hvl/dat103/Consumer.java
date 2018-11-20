package no.hvl.dat103;


public class Consumer extends Thread {

    private MySemaphore full;
    private MySemaphore mutex;
    private MySemaphore empty;
    private Buffer buffer;

    public Consumer(MySemaphore full, MySemaphore mutex, MySemaphore empty, Buffer buffer) {
        this.full = full;
        this.mutex = mutex;
        this.empty = empty;
        this.buffer = buffer;
    }

    @Override
    public void run() {

        while (true) {


            full.vent();
            mutex.vent();
            Integer tall = buffer.removeFromList();
            System.out.println("Consumer: " + tall);
            mutex.signal();
            empty.signal();


            /*
            buffer.vent(StringConstants.FULL, mgv);
            buffer.vent(StringConstants.MUTEX, mgv);
            Integer tall = buffer.removeFromList();
            System.out.println("Consumer: " + tall);
            buffer.signal(StringConstants.MUTEX, mgv);
            buffer.signal(StringConstants.EMPTY, mgv);
            */
        }

    }

}
