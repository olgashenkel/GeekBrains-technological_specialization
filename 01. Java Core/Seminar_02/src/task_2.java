/*
Задание 2
Задача: Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
заполнить его диагональные элементы единицами, используя цикл(ы)

Задание 2*
Задача: Дописать функцию вывода двумерного массива в консоль

* Реализация дополнительного решения, вне условий задания:
1) заполнение массива случайными числами (Random),
2) реализовано выполнение запросов от пользователя на размерность массива

 */


import java.util.Random;
import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {

        consoleMethod();
    }

    // метод для вывода сообщений в консоль (общение с пользователем):
    private static void consoleMethod() {
        // запрос от пользователя для установки размера массива
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите размер массива: ");
        int size = in.nextInt();
        System.out.printf("Массив из случайных чисел размером = %d x %d: \n", size, size);

        // метод заполнения массива случайными числами, а диагональные элементы - единицами
        fillArray(size);

        in.close();
    }

    // метод заполнения массива случайными числами, а диагональные элементы - единицами:
    public static int[][] fillArray(int sizeArray) {
        Random random = new Random();
        int[][] newArray = new int[sizeArray][sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            for (int j = 0; j < sizeArray; j++) {

                if (i == j || i == (sizeArray - j - 1)) {
                    // заполнение диагональных элементов массива единицами
                    newArray[i][j] = 1; // Главная диагональ
                    newArray[i][sizeArray - 1 - j] = 1; // Побочная диагональ
                } else {
                    // заполнение массива случайными числами
                    newArray[i][j] = random.nextInt(100);
                }
                System.out.print(newArray[i][j] + "\t");   // вывод массива в консоль
            }
            System.out.println();
        }
        return newArray;
    }

}
