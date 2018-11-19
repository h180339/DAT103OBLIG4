package no.hvl.dat103;

public class Process1 implements Runnable {

	private MySemaphore shared;
	private final int i = 0;
	private final int j = 1;

	public Process1(MySemaphore shared) { this.shared = shared; }

	@Override
	public void run() {
		do {
			shared.flag[i] = true;
			shared.turn = j;
			while (shared.flag[j] && shared.turn == j) {
				//wait

			}
			System.out.println("Prosses 1 crit section start:");
			System.out.println("flag[0] = " + shared.flag[0] + " flag[1] = " + shared.flag[1] + " turn = " + shared.turn);
			System.out.println("Prosses 1 crit section end");
			System.out.println();
			shared.flag[i] = false;
		} while (true);
	}
	
}
