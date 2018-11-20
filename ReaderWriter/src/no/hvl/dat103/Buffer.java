package no.hvl.dat103;


import java.util.ArrayList;
import java.util.List;

public class Buffer {

    private List<String> list;
    private int readCount;
    public Buffer() {
        readCount = 0;
        list = new ArrayList<>();
    }


    public void skriv(String s) {

        list.add(s);
        //System.out.println("add " + s + " to list");
    }



    public boolean listIsEmpty() {
        return list.isEmpty();
    }

    public List<String> getList() {
        return list;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String les() {
        return list.get(0);
    }
}
