package seminar_02.task_01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> personalClass = Class.forName("seminar_02.task_01.Person");

        // Получить список всех полей
        Field[] fields = personalClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Поле: " + field.getName());
        }

        // Получить список всех методов
        Method[] methods = personalClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Методы: " + method);
        }


        // создайте экземпляр класса "Person" с использованием Reflection API
        Constructor<?> constructor = personalClass.getConstructor(String.class, int.class);
        Object personInstance = constructor.newInstance("Ivan", 30);


        // установите значения полей и вызовите методы
        Person ivan = (Person) personInstance;
        System.out.println(ivan);

    }
}
