package seminar_04;

import java.util.*;

public class Task_01 {
    public static void main(String[] args) {
        List<String> manName = new ArrayList<>(Arrays.asList(
                "Евгений", "Анатолий", "Юрий",
                "Тимофей", "Аркадий", "Михаил", "Сергей"
        ));

        List<String> womanName = new ArrayList<>(Arrays.asList(
                "Антонина", "Юлия", "Олеся",
                "Янина", "Анжелика", "Мария", "Евгения"
        ));

        System.out.println("Коллекция мужских и женских имен:");
        System.out.println(manName);
        System.out.println(womanName);

        System.out.println();

        System.out.println("Сортировка в алфавитном порядке:");
        sortedList(manName);
        sortedList(womanName);

        System.out.println();

        System.out.println("Сортировка по количеству букв в слове:");
        sortedListLength(manName);
        sortedListLength(womanName);

        System.out.println();

        System.out.println("Разворот коллекции:");
        reverseList(manName);
        reverseList(womanName);

    }

    private static void sortedList(List<String> name) {
        Collections.sort(name);
        System.out.println(name);
    }

    private static void sortedListLength(List<String> name) {
        name.sort(Comparator.comparingInt(String::length));
        System.out.println(name);
    }

    private static void reverseList(List<String> name) {
        Collections.reverse(name);
        System.out.println(name);
    }


}
