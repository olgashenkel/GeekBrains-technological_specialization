package lesson_04.task_02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class Db {
    /**
     * Поле "url" представляет собой путь к серверу.
     * "jdbc:mysql://localhost:3306" =>
     * => jdbc -> это протокол, наш драйвер, через который будет проходить подключение
     * => mysql -> это название СУБД
     * => localhost -> путь к серверу. В нашем случае это локальный сервер, что обозначается как "localhost"
     * => 3306 -> стандартный порт MySQL
     */
    private static final String URL = "jdbc:mysql://localhost:3306";

    /**
     * Поля "user" и "password" необходимы для установления соединения с сервером, и их
     * значения должны соответствовать тем, которые мы ввели при установке MySQL
     */
    private static final String USER = "root";
    private static final String PASSWORD = "helga-linux";


    // Подключение к базе данных
    public static void connection() {

        /** Представленный ниже код перенесен в класс Connector:

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Magic magic = new Magic("'Волшебная стрела'", 10, 0, 0);
        session.beginTransaction();
        session.save(magic);
        session.getTransaction().commit();
        session.close();
*/

        Connector connector = new Connector();

        /** В этом фрагменте также нет ничего особо нового; мы просто используем наш коннектор и сохраняем немного
         * больше объектов:

         Session session = connector.getSession();
         Magic magic = new Magic("Волшебная стрела", 10, 0, 0);
         session.beginTransaction();
         session.save(magic);
         magic = new Magic("Молния", 25, 0, 0);
         session.save(magic);
         magic = new Magic("Каменная кожа", 0, 0, 6);
         session.save(magic);
         magic = new Magic("Жажда крови", 0, 6, 0);
         session.save(magic);
         magic = new Magic("Жажда крови", 0, 6, 0);
         session.save(magic);
         magic = new Magic("Проклятие", 0, -3, 0);
         session.save(magic);
         magic = new Magic("Лечение", -30, 0, 0);
         session.save(magic);
         session.getTransaction().commit();
         session.close();
         */

        /** Загрузка объектов из базы данных:
         */
        /** (*из методички к лекции) В этом коде, прежде всего, следует отметить, что я обернул создание сессии в блок
         try/catch с использованием автоматического закрытия ресурсов. Создавшаяся
         сессия будет обязательно закрыта. Это удобный инструмент для работы с
         ресурсами, требующими закрытия. Ещё одна особенность заключается в том, что
         транзакция не создаётся. Это верно, поскольку при чтении данных из таблицы
         транзакции не требуются. Выборка осуществляется с использованием метода
         createQuery(). Первый параметр - это запрос в формате HQL, который буквально
         указывает, из какой таблицы читать, а второй - это класс-сущность, описывающий
         данные в таблице.
         *
         */
        /*
        try (Session session = connector.getSession()) {

            List<Magic> books = session.createQuery("FROM Magic", Magic.class).getResultList();
            books.forEach(b -> {
                System.out.println("Book of Magic : " + b);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

        /** (*из методички к лекции) Изменение одного из объектов:
         Этот код выглядит сложнее, однако практически ничего нового тут нет. Сначала я
         задал строку hql. Тут важно, что в запросе есть указатель на ключевое поле, туда
         можно было сразу положить идентификатор, но в таком виде его можно задать
         потом. Далее создаю запрос (Query) и устанавливаю параметр «id» равным
         четырём. Метод getSingleResult() возвращает результат удовлетворяющий
         заданным параметрам. Результат я сразу сохраняю в объект magic. Дальше меняю
         его параметр и имя. Далее я хочу обновить данные в базе, а делается это в рамках
         транзакции. Поэтому я начинаю транзакцию, обновляю данные методом update и транзакцию закрываю!
         */
        try (Session session = connector.getSession()) {
            String hql = "from Magic where id = :id";
            Query<Magic> query = session.createQuery(hql, Magic.class);
            query.setParameter("id", 13);
            Magic magic = query.getSingleResult();
            System.out.println(magic);
            magic.setAttBonus(12);
            magic.setName("Ярость");
            session.beginTransaction();
            session.update(magic);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /** (*из методички к лекции) Удаление объектов:
         Пример очень похож на чтение за несколькими отличиями. Во-первых, удаление
         проходит в рамках транзакции, для этого я создаю её первым делом. Сам метод
         удаления delete(b) в параметре требует только ссылку на объект, данные которого
         мы хотим удалить из базы. Ну и закрытие транзакции, которое я вызываю после
         удаления всех полученных из бузы объектов
         */
//        try (Session session = connector.getSession()) {
//            Transaction t = session.beginTransaction();
//            List<Magic> books = session.createQuery("FROM Magic", Magic.class).getResultList();
//            books.forEach(b -> {
//                session.delete(b);
//            });
//            t.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}

