
# Урок 2. Reflection API



### План урока:

- Получение информации о классе и его структуре с использованием Reflection API.
- Создание и вызов методов и конструкторов во время выполнения.
- Использование Reflection API для работы с приватными полями и методами.


## Домашняя работа ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/03.%20Java%20Junior/Seminar_02/seminar_02/src/main/java/seminar_02/Homework.java))

Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.

```
Class<String> stringClass = String.class;

Method[] methods = stringClass.getDeclaredMethods();
    for (Method method : methods) {
    System.out.println(method.getName()); // выводит только название методов
    System.out.println(method);
}
```
---
## Задачи с семинара

### Задание 1. Основы Reflection API ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/03.%20Java%20Junior/Seminar_02/seminar_02/src/main/java/seminar_02/task_01))

Получите информацию о классе "Person" с использованием Reflection API:
- выведите на экран все поля и методы класса;

```
// Получить список всех полей
Field[] fields = personalClass.getDeclaredFields();
for (Field field : fields) {
    System.out.println("Поле: " + field.getName());
}
```
```
// Получить список всех методов
Method[] methods = personalClass.getDeclaredMethods();
for (Method method : methods) {
    System.out.println("Методы: " + method);
}
```

- создайте экземпляр класса "Person" с использованием Reflection API;
```
Constructor<?> constructor = personalClass.getConstructor(String.class, int.class);
Object personInstance = constructor.newInstance("Ivan", 30);
```
- установите значения полей и вызовите методы;
```
Person ivan = (Person) personInstance;
System.out.println(ivan);
```
- реализуйте обработку исключений для обеспечения корректного взаимодействия с Reflection API
```
public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
```


### Задание 2. Применение Reflection API в разработке ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/03.%20Java%20Junior/Seminar_02/seminar_02/src/main/java/seminar_02/task_02))

1) Реализуйте обобщенный метод, который принимает объект и выводит в консоль значения всех его полей.
```
private static <T> void task2(T obj) throws IllegalAccessException {
    Class<?> objClass = obj.getClass();

    Field[] fields = objClass.getDeclaredFields();
    for (Field field : fields) {
        field.setAccessible(true); // Разрешение доступа к закрытому полю
        System.out.printf("%s: %s\n", field.getName(), field.get(obj));
    }
}
```

2) Создайте класс "Car" с различными полями (например: модель, цвет, год выпуска).
```
public class Car {
    private String model;
    private String color;
    private int year;

    public Car(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }
}
```

3) Примените Reflection API для вывода значений полей созданного объекта класса "Car" с использование ранее созданного метода.
```
Field[] fields = objClass.getDeclaredFields();
for (Field field : fields) {
    field.setAccessible(true); // Разрешение доступа к закрытому полю
    System.out.printf("%s: %s\n", field.getName(), field.get(obj));
}
```


### Задание 3\*. Реализовать простой фреймворк для создания SQL-запросов на основе Java-объектов ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/03.%20Java%20Junior/Seminar_02/seminar_02/src/main/java/seminar_02/task_03))

Фреймворк должен позволять аннотировать классы и поля для связывания их с таблицами и столбцами в базе данных.

1. Аннотация для маппинга:   
    Создайте аннотации, такие как @Entity, @Table, @Column для маппинга классов, таблиц и полей в базе данных.
2. Механизм генерации SQL-запросов:  
    Реализуйте класс QueryBuilder, который может принимать объект и генерировать SQL-запросы для выполнения операций CRUD (Create, Read, Update, Delete) на основе аннотаций.   
    Используйте Reflection для получения метаданных класса, аннотированного объекта, чтобы построить соответствующий ЫЙ -запрос. 
3. Пример использования:   
    Создайте простой класс, аннотированный для маппинга с базой данных.   
    Используйте ваш фреймворк для генерации SQL-запросов для различных операций, таких как вставка, выборка, обновление и удаление.
