
# Урок 2. Reflection API



### План урока:

- Создание класса с приватными полями, который реализует интерфейс Serializable.
- Запись объекта этого класса в файл с использованием ObjectOutputStream.
- Чтение объекта из файла с использованием ObjectInputStream и восстановление его состояния.
- Использование Java I/O для чтения и записи данных в файл.


## Домашняя работа ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/03.%20Java%20Junior/Seminar_03/seminar_03/src/main/java/seminar_03/homework))

**Задание 1:** Разработайте класс Student c полями String name, int age, transient double GPA (средний балл). Обеспечьте сериализацию для этого класса.

Создайте объект класса Student и инициализируйте его данными. Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла.

Выведите все поля объекта, включая GPA и обсудите, почему значение GPA не было сохранено/восстановлено.

**Задание 2\*:** Выполните задачу 1, используя другие типы сериализаторов (в xml и json документы).

---
## Задачи с семинара

### Задание 1 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/03.%20Java%20Junior/Seminar_03/seminar_03/src/main/java/seminar_03/task_01))
Создайте класс **UserData** с полями **String name**, **int age**, **transient String password**. Поле **password** должно быть отмечено ключевым словом **transient**.
```
private String name;
private int age;
transient String password;
```
Реализуйте интерфейс Serializable в вашем классе.

```
public class UserData implements Serializable
```

В методе **main** создайте экземпляр класса **UserData** и инициализируйте его данными. Сериализуйте этот объект в файл, используя **ObjectOutputStream** в сочетании с **FileOutputStream**.
```
UserData userData = new UserData("Ivanov Ivan", 29, "password");

try (FileOutputStream fileOutputStream = new FileOutputStream("userdata.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
    objectOutputStream.writeObject(userData);
    System.out.println("Объект UserData сериализован.");
}
```

### Задание 2 ([решение]())
Десериализуйте объект из ранее созданного файла обратно в объект Java, используя **ObjectInputStream**.

Выведите данные десериализованного объекта **UserData**.

```
try (
        FileInputStream fileInputStream = new FileInputStream("userdata.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
    userData = (UserData) objectInputStream.readObject();
//            System.out.println("Объект UserData десериализован.");
}

System.out.println("Объект UserData десериализован.");
System.out.println("Имя: " + userData.getName());
System.out.println("Возраст: " + userData.getAge());
System.out.println("Пароль (должен быть null, так как transient): " + userData.getPassword());    
```

Сравните данные до сериализации и после десериализации, особенно обратите внимание на поле, помеченное как **transient**.

Обсудите, почему это поле не было сохранено после десериализации.


### Задание 3 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/03.%20Java%20Junior/Seminar_03/seminar_03/src/main/java/seminar_03/task_02))

1) Разработать простейшее приложение (аналог приложения ToDoList), т.е. когда запускается приложение - есть возможность придумать себе ряд задач, а также отображение состояния ("выполнено" или "не выполнено").

2) Спроектировать приложение таким образом, чтобы результаты работы сохранялись в файл.

3) Добавление набора библиотек:
```
<dependencies>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.38</version>
        <scope>provided</scope>
    </dependency>

<!-- Добавляем зависимость для Jackson -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.16.0</version>
    </dependency>


<!-- Поддержка xml-сериализатора  -->
    <dependency>
        <groupId>com.fasterxml.jackson.dataformat</groupId>
        <artifactId>jackson-dataformat-xml</artifactId>
        <version>2.16.0</version>
    </dependency>
</dependencies>
```