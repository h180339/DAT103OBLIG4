package no.hvl.dat103;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Process2 implements Runnable {

	private Semaphore shared;

	public Process2(Semaphore shared) { this.shared = shared; }

	@Override
	public void run() {
		try {
			while(true) {
				shared.acquire();
				System.out.println("P2 crit section start:");
				sleep(1000);
				System.out.println("P2 CS end");
				shared.release();
				sleep(30);
			}
		} catch(Exception e) {
			shared.release();
		}



	}

}
