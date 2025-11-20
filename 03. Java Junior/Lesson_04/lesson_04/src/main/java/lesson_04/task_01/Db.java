package lesson_04.task_01;

import java.sql.*;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    /*
    Поле "url" представляет собой путь к серверу.
    "jdbc:mysql://localhost:3306" =>
     => jdbc -> это протокол, наш драйвер, через который будет проходить подключение
     => mysql -> это название СУБД
     => localhost -> путь к серверу. В нашем случае это локальный сервер, что обозначается как "localhost"
     => 3306 -> стандартный порт MySQL
     */

    private static final String USER = "root";
    private static final String PASSWORD = "helga-linux";
    /*
     Поля "user" и "password" необходимы для установления соединения с сервером, и их
значения должны соответствовать тем, которые мы ввели при установке MySQL
     */


    // Подключение к базе данных
    /*
        Обычно базу данных создают в инструментарии СУБД, и в MySQL, конечно, это всё есть, но мы попробуем создать
        её с использованием SQL-запроса прямо из нашего приложения.

        !!! Кстати, в MySQL база данных называется схемой, это всего лишь название и не влияет на функционал.
     */
    public static void connection() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            /*
            объект Statement используется для выполнения SQL-запросов и получения результатов их выполнения
             */
            Statement statement = connection.createStatement(); // создаём объект Statement
            statement.execute("DROP SCHEMA test");  // удаление (если БД существует) базы данных test
            statement.execute("CREATE SCHEMA test");  // создание базы данных test
            statement.execute("CREATE TABLE `test`.`table` (\n" +   // добавление таблицы и полей
                    " `id` INT NOT NULL,\n" +
                    " `firstname` VARCHAR(45) NULL,\n" +
                    " `lastname` VARCHAR(45) NULL,\n" +
                    " PRIMARY KEY (`id`));");

            //обычный SQL-запрос с просьбой заполнить поля таблицы данными
            statement.execute("INSERT INTO `test`.`table` (`id`,`firstname`,`lastname`)\n"
                    + "VALUES (1,'Иванов','Иван');");
            statement.execute("INSERT INTO `test`.`table` (`id`,`firstname`,`lastname`)\n" +
                    "VALUES (2,'Петров','Пётр');");

            /*
            Стейтмент возвращает результат работы запроса, а ResultSet создаёт указатель на
            первую строку результата. Метод next() возвращает истину, только если ещё есть не
            обработанные строки. Геттеры позволяют получить доступ непосредственно к
            данным. Таким образом осуществляется доступ к данным и их перебор
             */
            ResultSet set = statement.executeQuery("SELECT * FROM `test`.`table`;");
            while (set.next()) {
                System.out.println(set.getString(3) + " " + set.getString(2) + " " + set.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
