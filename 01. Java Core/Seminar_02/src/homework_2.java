/*
Задача 2: Написать метод, возвращающий количество чётных элементов массива

    countEvens([2, 1, 2, 3, 4]) → 3
    countEvens([2, 2, 0]) → 3
    countEvens([1, 3, 5]) → 0

 */


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class homework_2 {
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
        countEvenNumbers(newArray);

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

    // метод нахождения количество чётных элементов массива:
    public static void countEvenNumbers(int[] array) {
        int count = 0;

        if (array.length < 1){   // проверка на размерность массива
            System.out.println("Массив должен содержать хотя бы 1 элемент!");
            return;
        }

        for (int i : array) {
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.printf("Количество чётных элементов массива = %d", count);
    }
}
