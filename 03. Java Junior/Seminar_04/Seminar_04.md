
# Урок 4. Базы данных и инструменты взаимодействия с ними

### План урока

- Создание базы данных MySQL и таблицы для хранения объектов определенного класса.
- Реализация доступа к базе данных с использованием JDBC и выполнение базовых операций CRUD.
- Создание сущности JPA для соответствующей таблицы базы данных.
- Использование Hibernate для работы с базой данных: чтение, запись, обновление и удаление записей.

## Домашняя работа ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/03.%20Java%20Junior/Seminar_04/seminar_04/src/main/java/seminar_04/homework))

**Задание:** 

Настройте связь между вашим приложением и базой данных MySQL с использованием Hibernate. 

Создайте несколько объектов Person и сохраните их в базу данных.

Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Person.

Убедитесь, что каждая операция выполняется в отдельной транзакции.


---

## Задачи с семинара

### Задание 1 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/03.%20Java%20Junior/Seminar_04/seminar_04/src/main/java/seminar_04/task_01/Main.java))
Используя SQL, создайте таблицу Students c полями id (ключ), name, age.

Реализация подключения к базе данных через JDBC:
1) Напишите Java-код для подключения к базе данных (например, MySQL или PostgreSQL)
2) Реализуйте вставку, чтение, обновление и удаление данных в таблице Students с использованием провайдера JDBC.



### Задание 2 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/03.%20Java%20Junior/Seminar_04/seminar_04/src/main/java/seminar_04/task_02/Main.java))
Настройте Hibernate, связав его с вашей БД.

Создайте класс Student в Java, аннотируя его как сущность Hibernate.

Используя Hibernate, реализуйте вставку, чтение, обновление и удаление данных в таблице Students.

Обратите внимание на использование сессий и транзакций в Hibernate.