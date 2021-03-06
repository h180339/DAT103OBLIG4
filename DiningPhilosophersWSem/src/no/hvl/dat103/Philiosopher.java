package no.hvl.dat103;

class Philosopher extends Thread {

    public int number;
    public Fork leftFork;
    public Fork rightFork;

    Philosopher(int num, Fork left, Fork right) {
        number = num;
        leftFork = left;
        rightFork = right;
    }

    public void run() {
        while (true) {
            leftFork.grab();
            System.out.println("Philosopher #" + (number + 1) + " grabs left fork.");
            rightFork.grab();
            System.out.println("Philosopher #" + (number + 1) + " grabs right fork.");
            eat();
            leftFork.release();
            System.out.println("Philosopher #" + (number + 1) + " releases left fork.");
            rightFork.release();
            System.out.println("Philosopher #" + (number + 1) + " releases right fork.");
        }
    }

    void eat() {
        try {
            System.out.println("Philosopher #" + (number + 1) + " eating");
            sleep(1000);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}


