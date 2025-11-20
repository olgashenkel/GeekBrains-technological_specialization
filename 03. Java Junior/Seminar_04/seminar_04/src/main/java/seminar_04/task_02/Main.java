package seminar_04.task_02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import seminar_04.models.Student;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            // Создание (открытие) сессии
//            Session session = sessionFactory.getCurrentSession();
            Session session = sessionFactory.openSession();

            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Student student = Student.create();

            // Сохранение объекта
            session.save(student);
            System.out.println("Object student save successfully");

            // Чтение объекта из БД
            Student retrievedStudent = session.get(Student.class, student.getId());
            System.out.println("Object student retrieved successfully");
            System.out.println("Retrieved student object: " + retrievedStudent);

            // Обновление объекта в БД
            retrievedStudent.updateName();
            retrievedStudent.updateAge();
            session.update(retrievedStudent);
            System.out.println("Object student update successfully");


            // Фиксирование (запись) транзакции
            session.getTransaction().commit();

            // Закрытие сессии
            session.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}