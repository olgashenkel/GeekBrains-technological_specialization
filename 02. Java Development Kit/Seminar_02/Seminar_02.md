
# Урок 2. Программные интерфейсы


## Домашняя работа ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/02.%20Java%20Development%20Kit/Seminar_02/seminar_02/src/main/java/seminar_02))

Реализуйте простой обобщённый класс, такой как пара или кортеж. Затем создайте обобщенный метод, который работает с этим классом. Например, вы можете создать метод, который принимает пару и возвращает их сумму или конкатенацию.

---

1. Создать обобщенный класс Pair:
```
package seminar_02;

// Обобщенный класс
public class Pair <T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
```

2. Создать обобщенный метод (например, для конкатенации строк):

```
package seminar_02;

public class PairUtils {
    public static <T> String concatenate(Pair<?, T> pair) {
        if (pair.getFirst() instanceof String && pair.getSecond() instanceof String) {
            return pair.getFirst() + " " + pair.getSecond();
        }
        return pair.toString(); // Возвращает строковое представление пары, если типы не String
    }
}
```

3. Пример использования:
```
package seminar_02;


public class Main {
    public static void main(String[] args) {
        Pair<String, String> stringPair = new Pair<>("Hello,", "World!");
        System.out.println(PairUtils.concatenate(stringPair)); // Вывод: Hello World

        Pair<Integer, Integer> intPair = new Pair<>(5, 10);
        System.out.println(PairUtils.concatenate(intPair)); // Вывод: (5, 10)
    }
}
```
