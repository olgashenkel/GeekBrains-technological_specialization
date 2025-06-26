/*
Задание 3
Задача: Написать метод, в который передается не пустой одномерный целочисленный массив,
метод должен вернуть true если в массиве есть место, в котором
сумма левой и правой части массива равны.
Примеры:
checkBalance([1, 1, 1, || 2, 1]) → true,
checkBalance([2, 1, 1, 2, 1]) → false,
checkBalance([10, || 1, 2, 3, 4]) → true.
Абстрактная граница показана символами ||, эти символы в массив не входят.

Задание 3*
Задача: написать этот же метод таким образом, чтобы в нём использовался только один цикл.

* Реализация дополнительного решения, вне условий задания:
1) заполнение массива случайными числами (Random),
2) реализовано выполнение запросов от пользователя на размерность массива

 */

import java.util.Random;
import java.util.Scanner;

public class task_3 {

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
        System.out.println(checkBalance(fillArray(size)));

        in.close();
    }


    // метод заполнения массива случайными числами:
    public static int[] fillArray(int sizeArray) {
        Random random = new Random();
        int[] newArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {     // заполнение массива случайными числами
            newArray[i] = random.nextInt(11);
            System.out.print(newArray[i] + " ");
        }
        return newArray;
    }

    public static boolean checkBalance(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("\nМассив пустой! Вычисления невозможны!");
            return false;
        }

        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        if (sum % 2 != 0) {
            System.out.println("\nВ данном массиве НЕТ места, в котором бы суммы левой и правой части были бы равны");
            return false;
        }

        int leftSum = 0;
        for (int i : array) {
            leftSum += i;
            sum -= i;
            if (leftSum == sum) {
                System.out.println("\nВ данном массиве есть место, в котором суммы левой и правой части массива равны");
                return true;
            }
        }
        System.out.println("\nВ данном массиве НЕТ места, в котором бы суммы левой и правой части были бы равны");
        return false;
    }
}
