package lesson_03;

import java.io.IOException;
import java.io.Serializable;

import static lesson_03.Task_03.deSerialObj;
import static lesson_03.Task_03.serialObj;

public class Task_04 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        // Сериализация
//        MyFCs myFCs = new MyFCs("Ivanov", "Ivan", "Ivanovich");
//        serialObj(myFCs, "ser.txt");

        // Десериализация
        MyFCs myFCs = (MyFCs) deSerialObj("ser.txt");
        System.out.println(myFCs);
    }

    static class MyFCs implements Serializable {
        public String lName;
        public String fName;
        public String patronymic;

        public MyFCs(String patronymic, String fName, String lName) {
            this.patronymic = patronymic;
            this.fName = fName;
            this.lName = lName;
        }

        @Override
        public String toString() {
            return String.format("%s %s.%s.",
                    fName,
                    lName.toUpperCase().charAt(0),
                    patronymic.toUpperCase().charAt(0));
        }
    }


}
