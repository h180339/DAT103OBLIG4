package no.hvl.dat103;

public class Process1 implements Runnable {
	private ConcurrencyLibrary cl;

	public Process1() { this.cl = new ConcurrencyLibrary(); }

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
