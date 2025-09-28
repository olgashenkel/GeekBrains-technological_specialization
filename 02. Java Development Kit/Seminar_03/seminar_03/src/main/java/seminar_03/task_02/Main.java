package seminar_03.task_02;

public class Main {
    public static void main(String[] args) {

        Task_02<Object> task_02 = new Task_02<>();

        task_02.addElement("Hello");
        task_02.addElement("Hello");
        task_02.addElement("Hello");
        task_02.addElement("Hello");
        task_02.addElement("Hello");

        System.out.println(task_02);

        task_02.addElement("Hello");
        task_02.addElement("Hello");
        task_02.addElement("Hello");
        task_02.addElement("Hello");
        task_02.addElement("Hello");
        task_02.addElement("Hello");
        task_02.addElement("Hello");

        System.out.println(task_02);

        task_02.removeElement(1);
        task_02.removeElement(2);
        System.out.println(task_02);

        task_02.removeElement(17);
        System.out.println(task_02);
    }
}