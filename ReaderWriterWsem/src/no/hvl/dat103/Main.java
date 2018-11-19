package no.hvl.dat103;

import java.util.concurrent.Semaphore;

/**
 * Main class to demonstrate how to run multiple Threads. 
 *
 */
public class Main {

	public static void main(String[] args) {

		//Shared shared = new Shared();
		Semaphore shared = new Semaphore(1);

		new Thread(new Process1(shared)).start();
		new Thread(new Process2(shared)).start();
	}
	
}
