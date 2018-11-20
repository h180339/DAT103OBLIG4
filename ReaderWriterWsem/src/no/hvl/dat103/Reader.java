package no.hvl.dat103;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Reader implements Runnable {


	private Semaphore mutex, wrt;
	private Buffer buffer;
	private int idTall;

	public Reader(Semaphore mutex, Semaphore wrt, Buffer buffer, int idTall) {
		this.mutex = mutex;
		this.wrt = wrt;
		this.buffer = buffer;
		this.idTall = idTall;

	}

	@Override
	public void run() {
		do {


			try {
				mutex.acquire();
				buffer.setReadCount(buffer.getReadCount() + 1);
				if(buffer.getReadCount() == 1) {
					wrt.acquire();
				}
				mutex.release();
				System.out.println("READER" + idTall + " LESER: " + buffer.les());
				mutex.acquire();
				buffer.setReadCount(buffer.getReadCount() - 1);
				if(buffer.getReadCount() == 0) {
					wrt.release();
				}
				mutex.release();
				try {sleep(100);}catch (InterruptedException e) {e.printStackTrace();}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			/*
			mutex.vent();
			buffer.setReadCount(buffer.getReadCount() + 1);
			if(buffer.getReadCount() == 1) {
				wrt.vent();
			}

			mutex.signal();
			System.out.println("READER" + idTall + " LESER: " + buffer.les());
			mutex.vent();
			buffer.setReadCount(buffer.getReadCount() - 1);
			if(buffer.getReadCount() == 0) {
				wrt.signal();
			}

			mutex.signal();
			try {sleep(100);}catch (InterruptedException e) {e.printStackTrace();}
			*/

		} while (true);
	}

}
