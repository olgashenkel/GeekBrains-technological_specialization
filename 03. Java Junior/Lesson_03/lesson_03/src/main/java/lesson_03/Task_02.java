package lesson_03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class Task_02 {
    public static void main(String[] args) throws Exception {
        // Десериализация
        FileInputStream fileInputStream = new FileInputStream("ser.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        String str2 = (String) objectInputStream.readObject();
        System.out.println(str2);

    }
}
