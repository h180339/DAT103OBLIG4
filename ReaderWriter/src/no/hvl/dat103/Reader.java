package no.hvl.dat103;

public class Reader implements Runnable {

	private MyGlobalVariables mgv;
	private MySemaphore mySemaphore;

	public Reader( MySemaphore mySemaphore, MyGlobalVariables mgv) {
		this.mgv = mgv;
		this.mySemaphore = mySemaphore;
	}

	@Override
	public void run() {
		do {
			mySemaphore.vent(StringConstants.MUTEX, mgv);
			mgv.increment(StringConstants.READCOUNT);
			if(mgv.getVariable(StringConstants.READCOUNT) == 1) {
				System.out.println("loop");
				mySemaphore.vent(StringConstants.WRT, mgv);
			}
			mySemaphore.signal(StringConstants.MUTEX, mgv);
			System.out.println("leser: " + mySemaphore.les());
			mySemaphore.vent(StringConstants.MUTEX, mgv);
			mgv.decrement(StringConstants.READCOUNT);
			if(mgv.getVariable(StringConstants.READCOUNT) == 0) {
				mySemaphore.signal(StringConstants.WRT, mgv);
			}
			mySemaphore.signal(StringConstants.MUTEX, mgv);
		} while (true);
	}

}
