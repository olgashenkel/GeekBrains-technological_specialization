package lesson_02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Car car = new Car("name");
//        System.out.println(car.name);

        Class<?> car = Class.forName("lesson_02.Car");
        Constructor<?>[] constructors = car.getConstructors();
//        System.out.println(constructors);

        Object gaz = constructors[0].newInstance("ГАЗ");
        System.out.println(gaz);

        Field[] fields = gaz.getClass().getFields();
        int tmp = fields[fields.length-1].getInt(gaz);
        fields[fields.length-1].setInt(gaz, tmp*2);

        System.out.println(gaz);


//        Method[] methods = gaz.getClass().getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

        Method[] methods1 = gaz.getClass().getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }

    }


}