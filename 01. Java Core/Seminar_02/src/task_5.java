/*
Задание 5 (необязательное)

Задача: Написать метод, осуществляющий сортировку одномерного массива подсчётом.
Важное ограничение состоит в том, что для этой сортировки диапазон значений
исходного массива должен находиться в разумных пределах, например, не более 1000.

x[2, 1, 0, 4, 3, 0, 0, 1, 2] → t[3(x0), 2(x1), 2(x2), 1(x3), 1(x4)] →
                                        → x[0, 0, 0, 1, 1, 2, 2, 3, 4]

* Реализация дополнительного решения, вне условий задания:
1) заполнение массива случайными числами (Random),
2) реализовано выполнение запросов от пользователя

 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {
        consoleMethod();
    }


    private static void consoleMethod() {
        // запрос от пользователя для установки размера массива
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите размер массива: ");
        int size = in.nextInt();

        System.out.printf("Массив из случайных чисел размером = %d: \n", size);
        int[] newArray = fillArray(size);

        countingSort(newArray);
    }


    // метод заполнения массива случайными числами:
    public static int[] fillArray(int sizeArray) {
        Random random = new Random();
        int[] newArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {     // заполнение массива случайными числами
            newArray[i] = random.nextInt(20);
//            System.out.print(newArray[i] + " ");
        }
        System.out.println("Исходный массив: " + Arrays.toString(newArray));
        return newArray;
    }



    public static void countingSort(int[] array) {
        if (array.length <= 1) {   // проверка на размерность массива
            System.out.println("Для выполнения сортировки массив должен быть больше 1!");
            return;
        }

        // Находим максимальное значение в массиве для определения размера вспомогательного массива
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // Создаем вспомогательный массив для подсчета вхождений
        int[] countArray = new int[max + 1];

        // Подсчитываем вхождения каждого элемента
        for (int num : array) {
            countArray[num]++;
        }

        // Формируем отсортированный массив
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                array[index++] = i;
                countArray[i]--;
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}
