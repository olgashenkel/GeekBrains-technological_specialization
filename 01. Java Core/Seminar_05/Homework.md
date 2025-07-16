
# Урок 5. Тонкости работы


## Домашняя работа

### Задание 1 ([решение]())

Задача: 




### Задание 2

Задача: 

```

```

![Задание № 2](./image/task_2.jpg)



---
## Задачи с семинара

### Задание 1 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/01.%20Java%20Core/Seminar_05/seminar_05/src/main/java/seminar_05))

Задача: Создать массив из 9 цифр и записать его в файл, используя поток вывода.

```
    // Метод записи (дозаписи) массива в файл:
    public static void writesArrayToFile(int[] arrays) {
        try (FileWriter writeArray = new FileWriter("src/main/resources/array.txt", true)) {
            writeArray.append("[");
            for (int i = 0; i < arrays.length; i++) {
                if (i == (arrays.length - 1)) {
                    writeArray.write(String.valueOf(arrays[i]));  // Явное преобразование числа в строку и запись в файл
                } else {
                    writeArray.write(arrays[i] + ", ");// Записываем значения массива в файл
                }
            }
            writeArray.append("]");
            writeArray.append("\n");     // Переход в файле на новую строку

            System.out.println();
            System.out.println("Массив успешно записан в файл"); // Сообщение пользователю
        } catch (IOException ex) {
            System.err.println("Ошибка при записи в файл: " + ex.getMessage());
        }
    }
```
![Задание № 1](./image/task_1.2.jpg)
![Задание № 1](./image/task_1.1.jpg)


```

```


![Задание № 2](./image/task_1.jpg)