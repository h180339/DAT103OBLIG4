package no.hvl.dat103;

public class Process2 implements Runnable {
	private ConcurrencyLibrary cl;

	public Process2() { this.cl = new ConcurrencyLibrary(); }
	@Override
	public void run() {
		while (true) {
			cl.criticalSection2();
			System.out.println("Hallo fra P2");
			synchronized (this) {
				try {
					this.wait(900);
				} catch (InterruptedException e) {
				}
			}

		}
	}
}
