package seminar_05;

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        writesArrayToFile(newArray());

    }


    // Метод создания массива:
    private static int[] newArray() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Создание массива из " + array.length + " случайных чисел: ");
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                array[i] = random.nextInt(100);
                System.out.print(array[i]);
            } else {
                array[i] = random.nextInt(100);
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print("]");
        return array;
    }


    // Метод записи массива в файл:
    public static void writesArrayToFile(int[] arrays) {
        try (FileWriter writeArray = new FileWriter("src/main/resources/array.txt")) {
            for (int i : arrays) {
                writeArray.write(i + " "); // Преобразуем число в строку и записываем
            }
            System.out.println("\nМассив успешно записан в файл");
        } catch (IOException ex) {
            System.err.println("Ошибка при записи в файл: " + ex.getMessage());
        }
    }


}