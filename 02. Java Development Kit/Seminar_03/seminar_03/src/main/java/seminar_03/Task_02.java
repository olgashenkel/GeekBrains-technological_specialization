package seminar_03;

import java.util.Arrays;

public class Task_02<T> {
    private Object[] elements;
    private int size;
    private static final int INITIAL_SIZE = 10;

    public Task_02(Object[] elements, int size) {
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
    private boolean removeElement(int index) {
        if (index > size || index < 0) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i+1];
        }
        elements[--size] = null;
        return true;
    }
}
