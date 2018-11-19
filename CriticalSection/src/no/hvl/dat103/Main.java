package no.hvl.dat103;

/**
 * Main class to demonstrate how to run multiple Threads. 
 *
 */
public class Main {


	public static void main(String[] args) {
		// To start a Thread, we use our existing Runnable implementation and start it.
		ConcurrencyLibrary cl = new ConcurrencyLibrary();
		new Thread(new Process1(cl)).start();
		new Thread(new Process2(cl)).start();

	}
	
}
