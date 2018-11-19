package no.hvl.dat103;

public class MyGlobalVariables {
    private int readCount;
    private int mutex;
    private int wrt;

    public MyGlobalVariables(int readCount, int mutex, int wrt) {
        this.readCount = readCount;
        this.mutex = mutex;
        this.wrt = wrt;
    }

    public void increment(String variable) {
        switch (variable) {
            case "readCount" :
                this.readCount++;
                break;
            case "mutex":
                this.mutex++;
                break;
            case "wrt":
                this.wrt++;
                break;
        }
    }

    public void decrement(String variable) {
        switch (variable) {
            case "readCount" :
                this.readCount--;
                break;
            case "mutex":
                this.mutex--;
                break;
            case "wrt":
                this.wrt--;
                break;
        }
    }

    public int getVariable(String variable) {
        switch (variable) {
            case "readCount" :
                return this.readCount;
            case "mutex":
                return this.mutex;
            case "wrt":
                return this.wrt;
            default:
                return -1;
        }
    }
}
