package no.hvl.dat103;


public class Main {

    public static void main(String[] args) {


        MySemaphore sem1 = new MySemaphore(1);
        MySemaphore sem2 = new MySemaphore(1);
        MySemaphore sem3 = new MySemaphore(1);
        MySemaphore sem4 = new MySemaphore(1);
        MySemaphore sem5 = new MySemaphore(1);

        MySemaphore[] chopsticks = {sem1, sem2,sem3, sem4, sem5};

        Thread tråd1 = new Thread(new Phil1(chopsticks, 0));
        Thread tråd2 = new Thread(new Phil1(chopsticks, 1));
        Thread tråd3 = new Thread(new Phil1(chopsticks, 2));
        Thread tråd4 = new Thread(new Phil1(chopsticks, 3));
        Thread tråd5 = new Thread(new Phil1(chopsticks, 4));
        //Thread producer = new Thread(new Producer(buffer, myGlobalVariables));

        tråd1.start();
        tråd2.start();
        tråd3.start();
        tråd4.start();
        tråd5.start();


    }
}
