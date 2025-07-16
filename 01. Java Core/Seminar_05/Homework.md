
# Урок 5. Тонкости работы


## Домашняя работа

### Задание 1 ([решение]())

Задача: Создать массив из 9 цифр и записать его в файл, используя поток вывода.

```
    // Метод записи массива в файл:
    public static void writesArrayToFile(int[] arrays) {
        try (FileWriter writeArray = new FileWriter("src/main/resources/array.txt")) {
            for (int i : arrays) {
                writeArray.write(i + " "); // Преобразуем число в строку и записываем
            }
            System.out.println("\nМассив успешно записан в файл");
        } catch (IOException ex) {
            System.err.println("Ошибка при записи в файл: " + ex.getMessage());
        }
    }
```



### Задание 2

Задача: 

```

```

![Задание № 2](./image/task_2.jpg)



---
## Задачи с семинара

### Задание 1 ([решение]())

Задача: Создать массив из 9 цифр и записать его в файл, используя поток вывода.


```

```


![Задание № 2](./image/task_1.jpg)