package no.hvl.dat103;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Process1 implements Runnable {

	private Semaphore shared;


	public Process1(Semaphore shared) { this.shared = shared; }

	@Override
	public void run() {
		try {
			while(true) {
				shared.acquire();
				System.out.println("P1 crit section start:");
				sleep(1000);
				System.out.println("P1 CS end");
				shared.release();
				sleep(50);
			}
		} catch(Exception e) {
			shared.release();
		}
	}
	
}
