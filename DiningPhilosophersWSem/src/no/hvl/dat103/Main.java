package no.hvl.dat103;

class Main {

    public static void main(String[] args) {
        Philosopher [] philosophers= new Philosopher[5];
        Fork forks[] = new Fork[5];

        for (int i = 0; i < philosophers.length; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % philosophers.length]);
            philosophers[i].start();
        }


    }
}
