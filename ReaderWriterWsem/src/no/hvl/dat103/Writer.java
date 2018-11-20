package no.hvl.dat103;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Writer implements Runnable {


	private Semaphore wrt;
	private Buffer buffer;
	private int tall = 1;


	public Writer(Semaphore wrt, Buffer buffer) {
		this.wrt = wrt;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		do {

			try {
				wrt.acquire();
				System.out.println("writing");
				try {sleep(10);}catch (InterruptedException e) {e.printStackTrace();}
				buffer.skriv("skrift" + tall);
				wrt.release();
				System.out.println("sluttet å skrive");
				try {sleep(10);}catch (InterruptedException e) {e.printStackTrace();}
				tall++;


			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			/*
			wrt.vent();
			System.out.println("writing");
			try {sleep(10);}catch (InterruptedException e) {e.printStackTrace();}
			buffer.skriv("skrift" + tall);
			wrt.signal();
			System.out.println("sluttet å skrive");
			try {sleep(10);}catch (InterruptedException e) {e.printStackTrace();}
			tall++;			try {sleep(100);}catch (InterruptedException e) {e.printStackTrace();}
			*/
		} while (true);
	}

}
