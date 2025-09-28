package seminar_03.task_03;

public class Main {
    public static void main(String[] args) {

        String[] elements = {"Hello ", "Hello ", "Hello ", "Hello ", "Hello ", "Hello "};
        Task_03<String> stringIterator = new Task_03<>(elements);

        Integer[] elements_2 = {1, 2, 3, 5, 8, 9, 10};
        Task_03<Integer> integerIterator = new Task_03<>(elements_2);

        while (stringIterator.hasNext()) {
            System.out.print(stringIterator.next());
        }

        System.out.println();

        while (integerIterator.hasNext()) {
            System.out.print(integerIterator.next());
            System.out.print(" ");
        }
    }
}