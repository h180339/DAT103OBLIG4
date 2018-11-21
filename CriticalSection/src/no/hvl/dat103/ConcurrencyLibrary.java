package no.hvl.dat103;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ConcurrencyLibrary {

	public Semaphore sem;
	private List<Integer> list;

	public ConcurrencyLibrary() {
		sem  = new Semaphore(1);
		list = new ArrayList<>();
		list.add(22);
	}

	public void criticalSection1() {
		try {
			sem.acquire();
			System.out.println("Sett inn tall: " + 22);
			list.add(22);
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void criticalSection2() {
		try {
			sem.acquire();
			Integer tall1 = list.get(0);
			System.out.println("ta ut :" + tall1);
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
