package seminar_02;

import java.lang.reflect.Method;

public class Homework {
    public static void main(String[] args) {


        Class<String> stringClass = String.class;

        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods) {
//            System.out.println(method.getName()); // выводит только название методов
            System.out.println(method);

        }
    }
}
