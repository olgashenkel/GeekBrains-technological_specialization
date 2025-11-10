package seminar_03.task_01;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        UserData userData = new UserData("Ivanov Ivan", 29, "password");

        // Задача 1. Сериализация
        try (FileOutputStream fileOutputStream = new FileOutputStream("userdata.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(userData);
            System.out.println("Объект UserData сериализован.");
        }


        // Задача 2. Десериализация
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
    }

}


