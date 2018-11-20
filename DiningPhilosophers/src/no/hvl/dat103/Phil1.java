package no.hvl.dat103;


public class Phil1 extends Thread {

    private MyGlobalVariables mgv;
    private Buffer buffer;

    public Phil1(Buffer buffer, MyGlobalVariables mgv) {
        this.mgv = mgv;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        do {
            buffer.vent(StringConstants.FULL, mgv);
            buffer.vent(StringConstants.MUTEX, mgv);
            Integer tall = buffer.removeFromList();
            System.out.println("Phil1: " + tall);
            buffer.signal(StringConstants.MUTEX, mgv);
            buffer.signal(StringConstants.EMPTY, mgv);


        } while(true);
    }

}
