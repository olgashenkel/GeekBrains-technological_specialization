package seminar_03.homework;

import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Getter;

@Getter
public class Student implements Externalizable {
    private String name;
    private int age;
    private transient double GPA; // Поле transient для демонстрации

    // Обязательный публичный конструктор без параметров
    public Student() {
    }

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Студент:\nИмя: " + name + "\nВозраст: " + age + "\nСредний балл: " + GPA + "\n";
    }

    // Реализация метода writeExternal
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name); // Сохраняем имя
        out.writeInt(age);     // Сохраняем возраст
        out.writeDouble(GPA);  // Сохраняем GPA вручную
    }

    // Реализация метода readExternal
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject(); // Восстанавливаем имя
        age = in.readInt();              // Восстанавливаем возраст
        GPA = in.readDouble();           // Восстанавливаем GPA вручную
    }

    // Сериализация в JSON
    public void serializeToJson(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), this);
    }

    // Десериализация из JSON
    public static Student deserializeFromJson(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), Student.class);
    }

    // Сериализация в XML
    public void serializeToXml(String fileName) throws IOException {
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new File(fileName), this);
    }

    // Десериализация из XML
    public static Student deserializeFromXml(String fileName) throws IOException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(new File(fileName), Student.class);
    }
}