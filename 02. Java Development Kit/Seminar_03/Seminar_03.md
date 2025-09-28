
# Урок 3. Обобщенное программирование

## Домашняя работа ([решение]())


## Практическая работа 

**Задание № 1 ([решение]()):**
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

**Задание № 2 ([решение]()):**

Описать собственную коллекцию - список на основе массива.

Коллекция должна иметь возможность хранить любые типы данных, иметь методы добавления и удаления элементов.

```
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
```

**Задание № 3 ([решение]()):**
