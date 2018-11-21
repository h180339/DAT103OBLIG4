package no.hvl.dat103;

public class Main {


	public static void main(String[] args) {
		ConcurrencyLibrary cl = new ConcurrencyLibrary();
		new Thread(new Process1(cl)).start();
		new Thread(new Process2(cl)).start();

	}
	
}
