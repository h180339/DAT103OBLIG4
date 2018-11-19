package no.hvl.dat103;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ConcurrencyLibrary {

	// Java has synchronization primitives in its standard library, ready to use
	// The following creates a semaphore of initial size 5, which means that we can call
	// acquire 5 times before a process has to wait...
	public Semaphore sem;
	private List<Integer> list;
	//private Integer tall = new Integer(22);

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
