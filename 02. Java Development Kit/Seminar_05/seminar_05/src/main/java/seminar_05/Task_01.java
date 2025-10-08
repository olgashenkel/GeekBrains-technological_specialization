package seminar_05;

public class Task_01 {
    static final Object objectA = new Object();
    static final Object objectB = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                workThread1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                workThread2();
            }
        });

        thread1.start();
        thread2.start();

    }


    public static void workThread1() {
        synchronized (objectA) {
            try {
                System.out.println("Поток 1 захватил объект A");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectB) {
                System.out.println("Поток 1 захватил объект B");
            }
        }
    }

    public static void workThread2() {
        synchronized (objectB) {
            System.out.println("Поток 2 захватил объект B");

            synchronized (objectA) {
                System.out.println("Поток 2 захватил объект A");
            }
        }
    }

}
