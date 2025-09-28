package lesson_03.array_swap;

public class ArraySwap {

    public static <T> void swapElements(T[] array, int index1, int index2) {
        // Проверка на корректность индексов
        if (array == null || index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            throw new IllegalArgumentException("Некорректные индексы или массив");
        }

        // Использование временной переменной для обмена
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
