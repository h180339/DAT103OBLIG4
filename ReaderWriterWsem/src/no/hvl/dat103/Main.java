package no.hvl.dat103;


import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {

		Semaphore mutex = new Semaphore(1);
		Semaphore wrt = new Semaphore(1);
		Buffer buffer = new Buffer();

		new Thread(new Writer(wrt, buffer)).start();
		new Thread(new Reader(mutex, wrt, buffer, 1)).start();
		new Thread(new Reader(mutex, wrt, buffer, 2)).start();
	}
	
}
