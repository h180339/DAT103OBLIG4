package no.hvl.dat103;

public class Process1 implements Runnable {

	ConcurrencyLibrary cl;
	public Process1(ConcurrencyLibrary cl) { this.cl = cl; }

	@Override
	public void run() {
		while (true) {
			cl.criticalSection1();
			synchronized (this) {
				try {
					this.wait(1000);
				} catch (InterruptedException e) {
				}
			}


		}
	}
}
