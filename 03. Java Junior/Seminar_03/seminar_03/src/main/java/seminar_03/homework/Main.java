package seminar_03.homework;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String binaryFileName = "student.bin";
        String jsonFileName = "student.json";
        String xmlFileName = "student.xml";

        Student student = new Student("Иванов Иван Иванович", 25, 99.9);

        System.out.println("Создан объект студента: " + student);

        // Бинарная сериализация и десериализация
        serializeToBinary(student, binaryFileName);
        Student binaryDeserializedStudent = deserializeFromBinary(binaryFileName);

        // JSON сериализация и десериализация
        serializeToJson(student, jsonFileName);
        Student jsonDeserializedStudent = deserializeFromJson(jsonFileName);

        // XML сериализация и десериализация
        serializeToXml(student, xmlFileName);
        Student xmlDeserializedStudent = deserializeFromXml(xmlFileName);

        // Вывод результатов
        System.out.println("Объект, десериализованный из бинарного файла: " + binaryDeserializedStudent);
        System.out.println("Объект, десериализованный из JSON файла: " + jsonDeserializedStudent);
        System.out.println("Объект, десериализованный из XML файла: " + xmlDeserializedStudent);
    }

    // Бинарная сериализация
    private static void serializeToBinary(Student student, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            student.writeExternal(oos);
            System.out.println("Объект сериализован в бинарный файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при сериализации в бинарный файл: " + e.getMessage());
        }
    }

    // Бинарная десериализация
    private static Student deserializeFromBinary(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Student student = new Student();
            student.readExternal(ois);
            System.out.println("Объект десериализован из бинарного файла: " + fileName);
            return student;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при десериализации из бинарного файла: " + e.getMessage());
            return null;
        }
    }

    // JSON сериализация
    private static void serializeToJson(Student student, String fileName) {
        try {
            student.serializeToJson(fileName);
            System.out.println("Объект сериализован в JSON файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при сериализации в JSON файл: " + e.getMessage());
        }
    }

    // JSON десериализация
    private static Student deserializeFromJson(String fileName) {
        try {
            Student student = Student.deserializeFromJson(fileName);
            System.out.println("Объект десериализован из JSON файла: " + fileName);
            return student;
        } catch (IOException e) {
            System.err.println("Ошибка при десериализации из JSON файла: " + e.getMessage());
            return null;
        }
    }

    // XML сериализация
    private static void serializeToXml(Student student, String fileName) {
        try {
            student.serializeToXml(fileName);
            System.out.println("Объект сериализован в XML файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при сериализации в XML файл: " + e.getMessage());
        }
    }

    // XML десериализация
    private static Student deserializeFromXml(String fileName) {
        try {
            Student student = Student.deserializeFromXml(fileName);
            System.out.println("Объект десериализован из XML файла: " + fileName);
            return student;
        } catch (IOException e) {
            System.err.println("Ошибка при десериализации из XML файла: " + e.getMessage());
            return null;
        }
    }
}