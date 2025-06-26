/*
Задание 4
Задача: Написать функцию добавления элемента в конец массива таким образом,
чтобы она расширяла массив при необходимости

Задание 4*
Задача: Функция должна возвращать ссылку на вновь созданный внутри себя массив,
а не использовать глобальный.

* Реализация дополнительного решения, вне условий задания:
1) заполнение массива случайными числами (Random),
2) реализовано выполнение запросов от пользователя
3) добавлено навигационное меню
4) метод добавления элемента по индексу

 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task_4 {
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

        arrayUpdate(newArray, in);
    }


    private static void arrayUpdate(int[] newArray, Scanner in) {
        int[] copyArray = copyArray(newArray);
        int out1;
        // добавление элементов и вывод в консоль нового массива
        while (true) {
            menu();
            out1 = in.nextInt();
            if (out1 == 1) {
                System.out.println("Введите число: ");
                int element = in.nextInt();
                copyArray = addArrayEnd(copyArray, element);
            } else if (out1 == 2) {
                System.out.println("Введите число: ");
                int element = in.nextInt();
                System.out.printf("Укажите индекс в пределах массива с 0 по %d: ", copyArray.length);
                int index = in.nextInt();
                copyArray = addArrayIndex(copyArray, element, index);
            } else if (out1 == 3) {
                System.out.println("До новых встреч!");
                return;
            } else {
                System.out.println("Команда не распознана!");
                return;
            }
        }
    }

    private static void menu() {
        System.out.println("\nВыберите необходимый пункт меню. \n------------------------------\n" +
                "Навигационное меню: " +
                "\n1. Добавить новое значение в конец массива " +
                "\n2. Добавить новое значение в массив по индексу " +
                "\n3. Выход из программы" +
                "\n------------------------------");
    }


    // метод заполнения массива случайными числами:
    public static int[] fillArray(int sizeArray) {
        Random random = new Random();
        int[] newArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {     // заполнение массива случайными числами
            newArray[i] = random.nextInt(20);
//            System.out.print(newArray[i] + " ");
        }
//        System.out.println(Arrays.toString(newArray));
        return newArray;
    }


    // метод по созданию копии массива
    public static int[] copyArray(int[] array) {
        int[] copyArray = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(copyArray));
        return copyArray;
    }


    // метод добавления элемента в массив по индексу
    public static int[] addArrayIndex(int[] array, int element, int index) {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("Недопустимый индекс!");
        }
        int[] addArrayIndex = new int[array.length + 1];
        // Копирование элементов массива до индекса вставки
        System.arraycopy(array, 0, addArrayIndex, 0, index);
        // Вставка нового элемента
        addArrayIndex[index] = element;
        // Копирование оставшихся элементов после вставки
        System.arraycopy(array, index, addArrayIndex, index + 1, array.length - index);

        System.out.println("Новый массив: " + Arrays.toString(addArrayIndex));
        return addArrayIndex;
    }


    // метод добавления элемента в конец массива
    public static int[] addArrayEnd(int[] array, int element) {
        int[] addArrayEnd = Arrays.copyOf(array, array.length + 1);
        addArrayEnd[addArrayEnd.length - 1] = element;
        System.out.println("Новый массив: " + Arrays.toString(addArrayEnd));
        return addArrayEnd;
    }
}
