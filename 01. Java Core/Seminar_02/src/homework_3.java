/*
Задача 3: Написать функцию, возвращающую разницу между самым большим и самым маленьким
элементами переданного не пустого массива.
 */


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class homework_3 {
    public static void main(String[] args) {

        consoleMethod();

    }


    // метод для вывода сообщений в консоль (общение с пользователем):
    private static void consoleMethod() {
        // запрос от пользователя для установки размера массива
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите размер массива: ");
        int size = in.nextInt();
        System.out.printf("Массив из случайных чисел размером = %d: \n", size);
        int[] newArray = fillArray(size);
        difference(newArray);

        in.close();
    }


    // метод заполнения массива случайными числами:
    public static int[] fillArray(int sizeArray) {
        Random random = new Random();
        int[] newArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {     // заполнение массива случайными числами
            newArray[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    // метод нахождения в массиве разницы между минимальным и максимальным числами:
    public static int difference(int[] array) {
        if (array.length < 2) {   // проверка на размерность массива
            System.out.println("Массив должен содержать хотя бы 2 элемента!");
            return 0;
        }

        int min = array[0];
        int max = array[0];

        for (int i : array) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }
        System.out.printf("min = %d, max = %d", min, max);
        System.out.printf("\nРазница между min и max элементами переданного массива = %d", max - min);
        return max - min;
    }


}
