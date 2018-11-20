package no.hvl.dat103;

public class MyGlobalVariables {
    private int[] semaphores;

    public MyGlobalVariables(int [] semaphores) {
        this.semaphores = semaphores;
    }

    public void increment(String variable) {
        switch (variable) {
            case "0" :
                this.semaphores[0]++;
                break;
            case "1":
                this.semaphores[1]++;
                break;
            case "2":
                this.semaphores[2]++;
                break;
            case "3":
                this.semaphores[3]++;
                break;
            case "4":
                this.semaphores[4]++;
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
