package no.hvl.dat103;


import java.util.ArrayList;
import java.util.List;

public class Buffer
Consumer
        Main
        MySemaphore
        ProducerBuffer {

    private List<Integer> list;

    public Buffer() {
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
}
