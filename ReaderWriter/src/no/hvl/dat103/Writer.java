package no.hvl.dat103;

import static java.lang.Thread.sleep;

public class Writer implements Runnable {


	private MySemaphore wrt;
	private Buffer buffer;


	public Writer(MySemaphore wrt, Buffer buffer) {
		this.wrt = wrt;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		do {
			wrt.vent();
			System.out.println("writing");
			try {sleep(1000);}catch (InterruptedException e) {e.printStackTrace();}
			buffer.skriv("boom");
			wrt.signal();
			System.out.println("sluttet å skrive");
			try {sleep(100);}catch (InterruptedException e) {e.printStackTrace();}
		} while (true);
	}
	
}
