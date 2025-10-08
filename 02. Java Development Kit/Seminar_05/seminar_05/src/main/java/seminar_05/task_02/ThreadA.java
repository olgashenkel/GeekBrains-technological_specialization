package seminar_05.task_02;

public class ThreadA implements Runnable{
    private volatile boolean switcher;

    public boolean isSwitcher() {
        return switcher;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                switcher = !switcher;
                System.out.println("Статус: " + switcher);
            } catch (InterruptedException e) {
                System.out.println("Программа закончила работу");
                break;
            }
        }
    }
}