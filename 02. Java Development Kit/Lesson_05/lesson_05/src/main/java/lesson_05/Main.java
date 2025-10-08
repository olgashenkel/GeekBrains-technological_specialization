package lesson_05;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Hello, word!");
//        System.out.println(Thread.currentThread().getName());

//        for (int i = 0; i < 3; i++) {
//            MyThread thread = new MyThread();
//            thread.start();
//            thread.join();
//        }
//
//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(new MyRunnable());
//            thread.start();
//            thread.join();
//        }
//
////        for (int i = 0; i < 3; i++) {
////            new Thread(()->{
////                System.out.println("3. Hello from" + Thread.currentThread());
////            }).start();
////        }
//
        Thread tic = new Thread(new TicTac("["));
        Thread tac = new Thread(new TicTac("]"));
//        tic.setDaemon(true);
//        tac.setDaemon(true);
        tic.start();
        tac.start();

//        long start = System.currentTimeMillis();
//        Task task = new Task(0);
//        CountDownLatch cdl = new CountDownLatch(3);
//        task.setCdl(cdl);
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new Thread(task);
//            thread.start();
//        }
//        cdl.await();
//        System.out.println(task.getValue());
//
//        long end = System.currentTimeMillis();
//        System.out.println("Time: " + (end - start) + "ms.");


    }
}
