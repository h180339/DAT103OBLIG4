package no.hvl.dat103;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MySemaphore {

	Random rand = new Random();
	private List<String> list;

	public MySemaphore() {
		list = new ArrayList<>();
	}
	public void vent(String variable, MyGlobalVariables mgv) {
		while (mgv.getVariable(variable) <= 0) {
		}
		mgv.decrement(variable);
	}

	public void signal(String variable, MyGlobalVariables mgv) {
		mgv.increment(variable);
	}

	public void skriv(String input) {
		list.add(input);
	}

	public String les() {
		//Integer tall = rand.nextInt(list.size() - 1);
		//return list.get(tall);
		return list.get(0);
	}
	/*
	public void addToList(int x) {
		Integer tall = new Integer(x);
		list.add(tall);
		System.out.println("add " + tall + " to list");
	}

	public Integer removeFromList() {
		if(!list.isEmpty()) {
			Integer tall = list.remove(0);
			System.out.println("remove " + tall + " from list");
			return tall;
		}else {
			System.out.println("list empty, return -1");
			return -1;
		}
	}
	*/
}
