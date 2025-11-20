package seminar_04.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table (name = "studentsdb.students")
@Setter
@Getter
public class Student {
    private static final String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Иван", "Апостол"};
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;


    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public static Student create() {
        return new Student(names[random.nextInt(names.length)], random.nextInt(20, 26));
    }

    public void updateAge() {
        age = random.nextInt(20, 26);
    }


    public void updateName() {
        name = names[random.nextInt(names.length)];
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
