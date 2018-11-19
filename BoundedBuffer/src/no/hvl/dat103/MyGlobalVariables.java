package no.hvl.dat103;

public class MyGlobalVariables {
    private int full;
    private int mutex;
    private int empty;

    public MyGlobalVariables(int full, int mutex, int empty) {
        this.full = full;
        this.mutex = mutex;
        this.empty = empty;
    }

    public void increment(String variable) {
        switch (variable) {
            case "full" :
                this.full++;
                break;
            case "mutex":
                this.mutex++;
                break;
            case "empty":
                this.empty++;
                break;
        }
    }

    public void decrement(String variable) {
        switch (variable) {
            case "full" :
                this.full--;
                break;
            case "mutex":
                this.mutex--;
                break;
            case "empty":
                this.empty--;
                break;
        }
    }

    public int getVariable(String variable) {
        switch (variable) {
            case "full" :
                return this.full;
            case "mutex":
                return this.mutex;
            case "empty":
                return this.empty;
            default:
                return -1;
        }
    }
}
