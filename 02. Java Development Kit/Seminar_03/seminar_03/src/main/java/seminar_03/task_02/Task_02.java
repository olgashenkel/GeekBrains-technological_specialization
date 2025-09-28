package seminar_03.task_02;

import java.util.Arrays;

public class Task_02<T> {
    private Object[] elements;
    private int size;
    private static final int INITIAL_SIZE = 10;

    public Task_02() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
    }

    // Метод добавления элемента в массив
    public boolean addElement(T element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    // Метод проверки и расширения массива
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    // Метод удаления элемента из массива по индексу
    public boolean removeElement(int index) {
        if (index > size || index < 0) {
            System.out.printf("Индекс %d находится за пределами массива\n", index);
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i+1];
        }
        elements[--size] = null;
        return true;
    }

    @Override
    public String toString() {
        System.out.printf("Размер массива: %d. Количество элементов в массиве: %d\n", elements.length, size);
        return Arrays.toString(elements);

    }
}
