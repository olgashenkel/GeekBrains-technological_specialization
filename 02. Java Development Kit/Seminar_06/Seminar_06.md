
# Урок 6. Управление проектом: сборщики проектов

## Домашняя работа 
**Задание № 1 ([решение]()):**

В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).

Необходимо:
- Создать свой Java Maven или Gradle проект;
- Самостоятельно реализовать прикладную задачу;
- Сохранить результат в HashMap<шаг теста, результат>
- Вывести на экран статистику по победам и поражениям


---

## Практическая работа 

**Задание № 1 ([решение]()):**

В рамках выполнения задачи необходимо:
- Создать свой Java Maven проект;
- Добавьте зависимость commons-math3 (предназначена для решения математических задач) и изучить интерфейс библиотеки.
```
<dependencies>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-math3</artifactId>
        <version>3.6.1</version>
    </dependency>
</dependencies>
```
- Воспользоваться пакетом org.apache.commons.math3.stat и классом DescriptiveStatistics.
    - Создать коллекцию из числовых элементов.
    ```
    List<Integer> numbers = new ArrayList<>();
    Collections.addAll(numbers, 10, 15, 20, 3, 5, 7, 9);
    ``` 
    - С помощью объекта DescriptiveStatistics вычислить минимальное и максимальное значение, сумму и среднее арифметическое.
    ```
    import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    public class Main {
        public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 10, 15, 20, 3, 5, 7, 9);

        DescriptiveStatistics statistics = new DescriptiveStatistics();
        for (Integer number : numbers){
            statistics.addValue(number);
        }

        double min = statistics.getMin();
        double max = statistics.getMax();
        double sum = statistics.getSum();
        double average = statistics.getMean();

        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Сумма чисел коллекции: " + sum);
        System.out.println("Среднее арифметическое значение: " + average);
        }
    }
    ``` 
- Воспользоваться пакетом org.apache.commons.math3.util. С помощью класса ArithmeticUtils найти:
    - факториал числа N.
    ```
    System.out.println("Факториал числа N: " + ArithmeticUtils.factorial(5));        
    ```
    - наименьшее общее частное двух чисел
    ```
    System.out.println("Наименьшее общее частное двух чисел (100 и 325): " + ArithmeticUtils.lcm(100, 325));        
    ```
    - наибольший общий делитель двух чисел
    ```
    System.out.println("Наибольший общий делитель двух чисел (15 и 18): " + ArithmeticUtils.gcd(15, 30));
    ```
    - проверить, что число N - это степень двойки
    ```
    System.out.println("Проверить, что число 32 - это степень двойки: " + ArithmeticUtils.isPowerOfTwo(32));
    ```


**Задание № 2 ([решение]()):**

В рамках выполнения задачи необходимо:
- Создать свой Java Gradle проект;
- Добавить зависимость Guava (популярная библиотека от Google, содержащая набор утилитарных механизмов).
  ```
    dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.google.guava:guava:33.5.0-jre")
    }
  ```
- Воспользоваться утилитарным классом Lists:
    - Развернуть список элементов
    ```
    List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
    List<Integer> arrayList2 = new ArrayList<>(List.of(7, 6, 5, 4, 3, 2, 1, 0));

        System.out.println("Развернутый список элементов: " + Lists.reverse(arrayList));
    ``` 
    - Получить лист Character из строки
    
    ```
    List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
    List<Integer> arrayList2 = new ArrayList<>(List.of(7, 6, 5, 4, 3, 2, 1, 0));

        System.out.println("Получить лист Character из строки: " + Lists.charactersOf("adsfgafgdfgd"));
    ``` 
    - Разделить лист на группы по 2 элемента   
    ```
    List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
    List<Integer> arrayList2 = new ArrayList<>(List.of(7, 6, 5, 4, 3, 2, 1, 0));        
        System.out.println("Разделить лист на группы по 2 элемента: " + Lists.partition(arrayList, 2));
    ``` 
- Воспользоваться утилитарным классом Sets
    - Получить итоговый Set из двух коллекций
    
    ```
    List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
    List<Integer> arrayList2 = new ArrayList<>(List.of(7, 6, 5, 4, 3, 2, 1, 0));        

        System.out.println("Получить итоговый Set из двух коллекций: " + Sets.union(Set.of(arrayList), Set.of(arrayList2)));
    ``` 
    - Получить итоговый Set из общих элементов двух коллекций
    
    ```
    List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
    List<Integer> arrayList2 = new ArrayList<>(List.of(7, 6, 5, 4, 3, 2, 1, 0));

        System.out.println("Получить итоговый Set из общих элементов двух коллекций: " + Sets.union(Set.copyOf(arrayList), Set.copyOf(arrayList2)));
    ``` 
    - Получить итоговый Set из непересекающихся элементов двух коллекций  
    ```
    List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
    List<Integer> arrayList2 = new ArrayList<>(List.of(7, 6, 5, 4, 3, 2, 1, 0));

        System.out.println("Получить итоговый Set из непересекающихся элементов двух коллекций: " + Sets.symmetricDifference(Set.copyOf(arrayList), Set.copyOf(arrayList2)));    
    ``` 