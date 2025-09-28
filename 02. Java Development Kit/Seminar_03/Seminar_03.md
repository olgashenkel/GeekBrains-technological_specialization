
# Урок 3. Обобщенное программирование

## Домашняя работа 
**Задание № 1 ([решение]()):**   
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа,
над которыми должна быть произведена операция.


**Задание № 2 ([решение]()):**   
Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае.
Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.


**Задание № 3 ([решение]()):**   
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
а также переопределение метода toString(), возвращающее строковое представление пары.



**Задание № 4\* ([решение]()):**
Создайте интерфейс, который определяет набор методов для работы с базой данных (например, сохранение, удаление, получение данных). Реализуйте этот интерфейс в конкретном классе.

---

## Практическая работа 

**Задание № 1 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/02.%20Java%20Development%20Kit/Seminar_03/seminar_03/src/main/java/seminar_03/task_01.java)):**
1. Создать обобщенный класс с тремя параметрами (T, V, K). 
2. Класс содержит три переменные типа (T, V, K).
3. Конструктор, принимающий на вход параметры типа (T, V, K).
4. Методы, возвращающие значения трех переменных.

```
public class Task_01<T, V, K> {
    private T t;
    private V v;
    private K k;

    public Task_01(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getValuesT() {
        return t;
    }

    public V getValuesV() {
        return v;
    }

    public K getValuesK() {
        return k;
    }
}
```

5. Создать метод, выводящий на консоль имена классов для трех переменных класса.

```
    public void getName(){
        System.out.println("Имя класса переменной T: " + t.getClass().getName());
        System.out.println("Имя класса переменной V: " + v.getClass().getName());
        System.out.println("Имя класса переменной K: " + k.getClass().getName());
    }
```

6. Наложить ограничения на параметры типа:

- **T** - должен реализовать интерфейс Comparable;
- **V** - должен реализовать интерфейс DataInput и расширять класс InputStream;
- **K** - должен расширять класс Number.
```
public class Task_01<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number>
```

---

**Задание № 2 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/02.%20Java%20Development%20Kit/Seminar_03/seminar_03/src/main/java/seminar_03/task_02.java)):**

Описать собственную коллекцию - список на основе массива.

Коллекция должна иметь возможность хранить любые типы данных, иметь методы добавления и удаления элементов.

```
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
```

**Задание № 3 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/02.%20Java%20Development%20Kit/Seminar_03/seminar_03/src/main/java/seminar_03/task_03.java)):**

Написать итератор по массиву.

Итератор - это объект, осуществляющий движение по коллекциям любого типа, содержащим любые типы данных. Итераторы обычно имеют только два метода - проверка на наличие следующего элемента и переход к следующему элементу. Но также, особенно в других языках программирования, возможно встретить итераторы, реализующие дополнительную логику.

```
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
```