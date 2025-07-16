package seminar_05;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {


        int[] array = newArray();
        System.out.println();
        System.out.println("Задание № 1");
        writesArrayToFile(array);
        System.out.println();
        System.out.println("Задание № 1*");
        writesArrayToFile2(array);
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


    // Метод записи (дозаписи) массива в файл:
    public static void writesArrayToFile(int[] arrays) {
        try (FileWriter writeArray = new FileWriter("src/main/resources/array.txt", true)) {
            writeArray.append("[");
            for (int i = 0; i < arrays.length; i++) {
                if (i == (arrays.length - 1)) {
                    writeArray.write(String.valueOf(arrays[i]));  // Явное преобразование числа в строку и запись в файл
                    writeArray.append("]");
                    writeArray.append("\n");     // Переход в файле на новую строку
                } else {
                    writeArray.write(arrays[i] + ", ");// Записываем значения массива в файл
                }
            }
            System.out.println("Массив успешно записан в файл"); // Сообщение пользователю
        } catch (IOException ex) {
            System.err.println("Ошибка при записи в файл: " + ex.getMessage());
        }
    }

    // *Метод записи (дозаписи) массива в файл:
    public static void writesArrayToFile2(int[] arrays) {
        try (FileWriter writeArray = new FileWriter("src/main/resources/array_2.txt", true)) {
            for (int i = 0; i < arrays.length; i++) {
                if (i == (arrays.length - 1)) {
                    writeArray.write(String.valueOf(arrays[i]));// Записываем значения массива в файл
                    writeArray.write("\n");     // Переход в файле на новую строку
                } else {
                    writeArray.write(String.valueOf(arrays[i]));// Записываем значения массива в файл
                    writeArray.write(String.valueOf(0));
                }
            }
            System.out.println("Массив успешно записан в файл"); // Сообщение пользователю
        } catch (IOException ex) {
            System.err.println("Ошибка при записи в файл: " + ex.getMessage());
        }
    }
}