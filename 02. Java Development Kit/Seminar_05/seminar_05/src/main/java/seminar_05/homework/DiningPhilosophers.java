package seminar_05.homework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DiningPhilosophers {

    private static final int NUM_PHILOSOPHERS = 5;
    private static final int MEALS_PER_PHILOSOPHER = 3;

    public DiningPhilosophers() {

        Lock[] forks = new ReentrantLock[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new ReentrantLock();
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            int leftFork = i;
            int rightFork = (i + 1) % NUM_PHILOSOPHERS;
            Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
            philosophers[i] = new Philosopher((i+1), forks[leftFork], forks[rightFork], MEALS_PER_PHILOSOPHER);
            new Thread(philosophers[(i)]).start();
        }
    }
}