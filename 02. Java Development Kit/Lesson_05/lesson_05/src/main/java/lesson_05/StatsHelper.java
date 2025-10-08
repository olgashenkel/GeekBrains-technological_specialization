package lesson_05;

import java.util.Scanner;

public class StatsHelper {
    private static int cnt = 0;


            public static void main(String[] args) throws InterruptedException {

                Thread readThred = new Thread(()->{
                    Scanner in = new Scanner(System.in);
                    while (in.hasNextLine() && !Thread.interrupted()){
                        String line = in.nextLine();
                        cnt++;
                    }
                });
                readThred.setDaemon(true);
                readThred.start();
                readThred.interrupt();
                while (true)    {
                    System.out.println(cnt + " messages inputted by user");
                    Thread.sleep(1000);
                }
    }
}
