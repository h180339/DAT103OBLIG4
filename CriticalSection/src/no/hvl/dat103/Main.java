package no.hvl.dat103;

/**
 * Main class to demonstrate how to run multiple Threads. 
 *
 */
public class Main {

	public static void main(String[] args) {
		// To start a Thread, we use our existing Runnable implementation and start it.
		new Thread(new Process1()).start();
		new Thread(new Process2()).start();

	}
	
}
