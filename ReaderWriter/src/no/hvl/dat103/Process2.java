package no.hvl.dat103;

import static java.lang.Thread.sleep;

public class Process2 implements Runnable {

	private MySemaphore shared;
	private final int i = 0;
	private final int j = 1;

	public Process2(MySemaphore shared) { this.shared = shared; }

	@Override
	public void run() {
		do {
			shared.flag[j] = true;
			shared.turn = i;
			while (shared.flag[i] && shared.turn == i) {
				//wait
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			System.out.println("Prosses 2 crit section start:");
			System.out.println("flag[0] = " + shared.flag[0] + " flag[1] = " + shared.flag[1]);
			System.out.println("Prosses 2 crit section end");
			System.out.println();
			shared.flag[j] = false;
		} while (true);
	}

}
