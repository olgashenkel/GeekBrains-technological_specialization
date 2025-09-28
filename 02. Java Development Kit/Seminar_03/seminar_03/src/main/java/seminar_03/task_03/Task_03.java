package seminar_03.task_03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Task_03<T>  implements Iterator<T> {
    private final T[] array;
    private int index;

    public Task_03(T[] array) {
        this.array = array;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Элементов в массиве больше нет");
        }
        return array[index++];
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

}
