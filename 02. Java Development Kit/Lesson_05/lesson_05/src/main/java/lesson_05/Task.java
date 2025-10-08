package lesson_05;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable {
    private final AtomicInteger value;
    private CountDownLatch cdl;

    public Task(int left) {
        this.value = new AtomicInteger(left);
    }

    public void inc() {
        value.incrementAndGet();
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public int getValue() {
        return value.intValue();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            inc();
        }
        cdl.countDown();
    }

    @Override
    public String toString() {
        return String.format("(%s)", value);
    }
}
