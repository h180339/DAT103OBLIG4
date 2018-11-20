package no.hvl.dat103;


public class Phil1 extends Thread {

    private MySemaphore[] chopsticks;
    private int i;

    public Phil1(MySemaphore[] chopsticks, int i) {
        this.chopsticks = chopsticks;
        this.i = i;
    }

    @Override
    public void run() {
        do {
            chopsticks[i].vent();
            chopsticks[(i + 1) % 5].vent();
            System.out.println("philo" + i + " START EATING");
            try {sleep(1000);}catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("philo" + i + " STOP EATING");
            chopsticks[i].signal();
            chopsticks[(i + 1) % 5].signal();
            System.out.println("philo" + i + " START THINKING");
            try {sleep(1000);}catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("philo" + i + " STOP THINKING");

        } while(true);
    }

}
