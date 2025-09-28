package lesson_03.array_swap;

import java.util.Scanner;

import static lesson_03.array_swap.ArraySwap.swapElements;

public class Main {
    public static void main(String[] args) {

        // Пример для массива строк
        String[] stringArray = {"Привет,", "Java", "World!", "Development Kit"};
        System.out.println("Исходный массив строк: ");
        for (String s : stringArray) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        swapElements(stringArray, 1, 2); // Меняем местами "Java" и "World!"
        System.out.println("Массив после обмена: ");
        for (String s : stringArray) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        // Пример для массива Объектов
        Object[] intArray = {20, "?????", "!!!!!", 40};
        System.out.println("Исходный массив Объектов: ");
        for (Object i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        swapElements(intArray, 0, 2);
        System.out.println("Массив после обмена: ");
        for (Object i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();




    }
}