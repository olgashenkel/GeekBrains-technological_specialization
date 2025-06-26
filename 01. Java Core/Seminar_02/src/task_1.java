/*
Задание 1
Задача: Задать одномерный массив. Написать методы поиска в нём
минимального и максимального элемента;

Задание 1*
Задача: Привести функции к корректному виду и дополнительно написать ещё две функции так, чтобы получились
(четыре) функции поиска минимального и максимального как значения, так и индекса.

* Реализация дополнительного решения, вне условий задания:
1) заполнение массива случайными числами (Random),
2) реализовано выполнение запросов от пользователя на размерность массива

 */

import java.util.Random;
import java.util.Scanner;

public class task_1 {
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

//        findMin(newArray);  // метод нахождения в массиве минимального числа
//        findMax(newArray);  // метод нахождения в массиве максимального числа
        findMinIndex(newArray, findMin(newArray)); // метод нахождения в массиве индекса минимального числа
        findMaxIndex(newArray, findMax(newArray)); // метод нахождения в массиве индекса максимального числа
        in.close();
    }


    // метод заполнения массива случайными числами:
    public static int[] fillArray(int sizeArray) {
        Random random = new Random();
        int[] newArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {     // заполнение массива случайными числами
            newArray[i] = random.nextInt(100);
            System.out.print(newArray[i] + " ");
        }
        return newArray;
    }

    // метод нахождения в массиве минимального числа:
    public static int findMin(int[] array) {
        int min = array[0];
        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    // метод нахождения в массиве максимального числа:
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    // метод нахождения в массиве индекса минимального числа:
    public static void findMinIndex(int[] array, int min) {
        int indexMin = -1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == min) {
                indexMin = j;
            }
        }
        System.out.print("\n_________MIN_________");
        System.out.printf("\nМинимальное число массива = %d", min);
        System.out.printf("\nИндекс минимального числа в исходном массиве [%d]", indexMin);
    }

    // метод нахождения в массиве индекса максимального числа:
    public static void findMaxIndex(int[] array, int max) {
//        int max = array[0];
        int indexMax = -1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == max) {
                indexMax = j;
            }
        }
        System.out.print("\n_________MAX_________");
        System.out.printf("\nМаксимальное число исходного массива = %d", max);
        System.out.printf("\nИндекс максимального числа в исходном массиве [%d]", indexMax);
    }

}