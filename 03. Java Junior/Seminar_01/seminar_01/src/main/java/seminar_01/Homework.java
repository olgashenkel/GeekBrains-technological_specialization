package seminar_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Введите несколько чисел, разделяя их пробелами. Для завершения ввода введите нечисловой " +
                "символ и Enter");

        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        System.out.println("Создан список чисел:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        double average = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .average()
                .orElse(0.0);

        System.out.println("\nСреднее значение всех четных чисел в списке = " + average);
        scanner.close();
    }
}
