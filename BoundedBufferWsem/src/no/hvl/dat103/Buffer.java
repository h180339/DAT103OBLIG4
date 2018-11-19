package no.hvl.dat103;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

/**
 * A shared buffer for consumers and producers. The item type is int. The buffer
 * is implemented by using a double ended queue.
 * @author Atle Geitung
 * @version 30.08.2018 Java version
 */
public class Buffer {

	private final static int SIZE = 10;
	private final static int PERMITS = 1;
	private LinkedList<Integer> buffer = new LinkedList<>();
	private Semaphore sem;

	/**
	 * Makes a buffer
	 */
	public Buffer() {
		sem = new Semaphore(PERMITS);
	}

	/**
	 * Add a new item to the buffer. If the buffer is full, wait.
	 * @param item the new item
	 */
	public void add(Integer item) {
		try {
			while (true) {
				if(buffer.size() <= SIZE) {
					sem.acquire();
					buffer.add(item);
					sem.release();

					return;
				}

				sleep(50);
			}
		} catch(Exception e) {
			sem.release();
		}
	}

	/**
	 * Remove next available item from the buffer. If the buffer is empty, wait.
	 * @return next item
	 */
	public Integer remove() {
		try {
			while (true) {
				if(buffer.size() > 0) {
					sem.acquire();
					Integer back = buffer.removeFirst();
					sem.release();

					return back;
				}

				sleep(50);
			}
		} catch(Exception e) {
			sem.release();
		}

		return -1;
	}

}
