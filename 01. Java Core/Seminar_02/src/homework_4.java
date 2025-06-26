/*
Задача 4: Написать функцию, возвращающую истину,
если в переданном массиве есть два соседних элемента, с нулевым значением.

 */


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class homework_4 {
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
        searchZero(newArray);

        in.close();
    }


    // метод заполнения массива случайными числами:
    public static int[] fillArray(int sizeArray) {
        Random random = new Random();
        int[] newArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {     // заполнение массива случайными числами
            newArray[i] = random.nextInt(5);
        }
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    // метод нахождения в массиве два соседних элемента с нулевым значением:
    public static boolean searchZero(int[] array) {
        if (array.length < 2) {   // проверка на размерность массива
            System.out.println("Массив должен содержать хотя бы 2 элемента!");
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 && array[i + 1] == 0) {
                System.out.print("Массив содержит два соседних элемента с нулевым значением");
                return true;
            }
        }
        System.out.print("Массив НЕ содержит два соседних элемента с нулевым значением");
        return false;
    }

}
