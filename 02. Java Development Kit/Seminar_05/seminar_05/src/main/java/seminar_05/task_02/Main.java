package seminar_05.task_02;

public class Main {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB(threadA);

        Thread thread1 = new Thread(threadA);
        Thread thread2 = new Thread(threadB);

        thread1.start();
        thread2.start();
        try {
            thread2.join();
            thread1.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
