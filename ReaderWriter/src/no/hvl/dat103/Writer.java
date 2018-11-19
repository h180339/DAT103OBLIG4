package no.hvl.dat103;

import static java.lang.Thread.sleep;

public class Writer implements Runnable {

	private MyGlobalVariables mgv;
	private MySemaphore mySemaphore;


	public Writer(MySemaphore mySemaphore, MyGlobalVariables mgv) {
		this.mySemaphore = mySemaphore;
		this.mgv = mgv;
	}

	@Override
	public void run() {
		do {
			mySemaphore.vent(StringConstants.WRT, mgv);
			System.out.println("writing");
			try {sleep(1000);}catch (InterruptedException e) {e.printStackTrace();}
			mySemaphore.skriv("boom");
			mySemaphore.signal(StringConstants.WRT, mgv);
			System.out.println("sluttet å skrive");
		} while (true);
	}
	
}
