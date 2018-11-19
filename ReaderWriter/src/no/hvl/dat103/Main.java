package no.hvl.dat103;

/**
 * Main class to demonstrate how to run multiple Threads. 
 *
 */
public class Main {

	public static void main(String[] args) {
		int readCount = 0;
		int mutex = 1;
		int wrt = 1;
		MyGlobalVariables myGlobalVariables = new MyGlobalVariables(readCount, mutex, wrt);

		MySemaphore mySem = new MySemaphore();
		new Thread(new Writer(mySem, myGlobalVariables)).start();
		new Thread(new Reader(mySem, myGlobalVariables)).start();
	}
	
}
