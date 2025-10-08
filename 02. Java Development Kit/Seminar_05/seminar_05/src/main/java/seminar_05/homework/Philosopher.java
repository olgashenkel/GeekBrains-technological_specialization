package seminar_05.homework;

import java.util.concurrent.locks.Lock;


public class Philosopher implements Runnable {

    private final int id;
    private final Lock leftFork;
    private final Lock rightFork;
    private final int mealsToEat;
    private int mealsEaten = 0;


    public Philosopher(int id, Lock leftFork, Lock rightFork, int mealsToEat) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.mealsToEat = mealsToEat;
    }


    @Override
    public void run() {
        try {
            while (mealsEaten < mealsToEat) {
                think();
                eat();
            }
            System.out.println("Философ " + id + " закончил трапезу.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Философ " + id + " был прерван.");
        }
    }


    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " размышляет.");
        Thread.sleep((long) (Math.random() * 1000));
    }


    private void eat() throws InterruptedException {
        leftFork.lock();
        rightFork.lock();
        try {
            mealsEaten++;
            System.out.println("Философ " + id + " трапезничает. Прием пищи № " + mealsEaten);
            Thread.sleep((long) (Math.random() * 1000));
        } finally {
            leftFork.unlock();
            rightFork.unlock();
        }
    }
}