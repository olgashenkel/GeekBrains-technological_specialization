package lesson_03;

import java.io.*;

public class Task_01 {
    public static void main(String[] args) throws Exception {
        String str = "Всем привет!";

        // Сериализация
        FileOutputStream fileOutputStream = new FileOutputStream("ser.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(str);
        objectOutputStream.close();
        System.out.println();

    }
}
