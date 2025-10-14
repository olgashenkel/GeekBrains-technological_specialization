package lesson_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*
        Для метода Интерфейса: String action(int x, int y);
         */
////        PlainInterface plainInterface = new PlainInterface() {
////            @Override
////            public String action(int x, int y) {
////                return String.valueOf(x+y);
////            }
////        };
//
//        // Реализация Лямбда-выражения с одной командой (сумма чисел)
//        PlainInterface plainInterface = (x, y) -> String.valueOf(x + y);
//
////        // Реализация Лямбда-выражения с несколькими командами:
////        PlainInterface plainInterface1 = (x, y) -> {
////            return String.valueOf(x + y);
////        };

//// Реализация Лямбда-выражения с одной командой (сравнение чисел) - работа компаратора по сравнению двух чисел
//        PlainInterface plainInterface2 = (x, y) -> String.valueOf(Integer.compare(x, y));
//
//        System.out.println(plainInterface.action(5, 2));
//        System.out.println(plainInterface2.action(5, 2));
//
//
//        /*
//        Для метода Интерфейса: int action(int x, int y);
//         */
//
//        // Так как совпадают аргументы (x, y) -> x + y; - то лямбда-выражение можно сократить до
//        // следующего вывода
//        PlainInterface plainInterface = Integer::sum;
//        System.out.println(plainInterface.action(5, 1));
//
//        // Так как совпадают аргументы (x, y) -> Integer.compare(x, y); - то лямбда-выражение можно сократить до
//        // следующего вывода
//        PlainInterface plainInterface2 = Integer::compare;
//        System.out.println(plainInterface2.action(5, 1));


        // работа со stream
//        List<String> list = Arrays.asList("Привет", "Мир", "!", "Я", "родился", "!");

        // вывести значения List по заданному фильтру (1-ый способ)
//        list = list.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
//        for (String item : list){
//            System.out.println(item);
//        }

        // вывести значения List по заданному фильтру (2-ой способ)
//        list.stream().filter(str -> str.length() > 4).forEach(s -> System.out.println(s));
//        // или
//        list.stream().filter(str -> str.length() > 4).forEach(System.out::println);
//        // можно создавать цепочку фильтрации:
//        list.stream().filter(str -> str.length() > 4).filter(str -> str.contains("о")).forEach(System.out::println);
//
//
//        // пример работы stream с числами:
//        Arrays.asList(1, 2, 3, 4, 5).stream().map(chislo -> chislo * chislo).forEach(System.out::println);
//        Arrays.asList(1, 2, 3, 4, 5).stream().map(chislo -> "Число: " + chislo + ". Квадрат числа: " + chislo * chislo).forEach(System.out::println);
//        // с методом sorted
//        Arrays.asList(1, 20, 13, 0, 0, 1, 20, 45).stream().sorted().forEach(System.out::println);
//        // с методом sorted с удалением дубликатов с помощью distinct
//        Arrays.asList(1, 20, 13, 0, 0, 1, 20, 45).stream().sorted().distinct().forEach(System.out::println);

        // создание коллекции для класса User:
        List<User> list = Arrays.asList(new User("Павел", 25), new User("Аркадий", 40), new User("Иван", 30));
        // работа со stream --> вывести всех Users, предварительно уменьшив возраст на 5 лет (user.age-5)
        list.stream().map(user -> new User(user.name, user.age-5)).forEach(System.out::println);
        // работа со stream --> добавление фильтрации
        list.stream().map(user -> new User(user.name, user.age-5)).filter(user -> user.age <=25).forEach(System.out::println);
    }
}
