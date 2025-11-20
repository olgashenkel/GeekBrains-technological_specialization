package seminar_04.homework;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WorkingDatabase {

    // Операция INSERT (Создание)
    public void createPerson(Person person) {
        Transaction transaction = null;
        try (Session session = Connector.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
            System.out.println("Person saved: " + person.getName());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Операция READ (Чтение всех записей)
    public List<Person> readAllPersons() {
        try (Session session = Connector.getSessionFactory().openSession()) {
            List<Person> persons = session.createQuery("from Person", Person.class).list(); // HQL
            return persons;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Операция UPDATE (Обновление)
    public void updatePerson(int id, String newName) {
        Transaction transaction = null;
        try (Session session = Connector.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Person person = session.get(Person.class, id);
            if (person != null) {
                person.setName(newName);
                session.update(person); // или session.merge(person) для JPA
                System.out.println("Person updated: " + person.getName());
            } else {
                System.out.println("Person not found with ID: " + id);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Операция DELETE (Удаление)
    public void deletePerson(int id) {
        Transaction transaction = null;
        try (Session session = Connector.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Person person = session.get(Person.class, id);
            if (person != null) {
                session.delete(person);
                System.out.println("Person deleted with ID: " + id);
            } else {
                System.out.println("Person not found with ID: " + id);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}


