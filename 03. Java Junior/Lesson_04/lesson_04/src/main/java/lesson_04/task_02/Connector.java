package lesson_04.task_02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/*
А теперь сделаем наш код более чистым. Создадим класс Connector и перенесём в него
из класса 'Db' всё, что касается создания sessionFactory,
а выделение сессии вынесем в метод getSession()
 */

public class Connector {
    final StandardServiceRegistry registry;
    SessionFactory sessionFactory;

    public Connector() {
        registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
