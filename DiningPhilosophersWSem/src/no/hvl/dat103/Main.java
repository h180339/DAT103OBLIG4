package no.hvl.dat103;

import static java.lang.Thread.sleep;

class Main {

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Fork [] forks = new Fork[philosophers.length];

        for (int i = 0; i < philosophers.length; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < philosophers.length; i++) {
            //the last philosopher reach for his right fork first, instead of the left
            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(i, forks[(i + 1) % forks.length], forks[i]);
                philosophers[i].start();

            } else {
                philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % forks.length]);
                philosophers[i].start();
            }
        }
    }

}