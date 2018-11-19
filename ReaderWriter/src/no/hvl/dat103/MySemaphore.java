package no.hvl.dat103;

public class MySemaphore {

	public MySemaphore() {
	}


	public void vent(int s) {
		while (s <= 0) {
			//no op
		}
		s--;
	}
	public void signal(int s) {
		s++;
	}
	
}
