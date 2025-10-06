package seminar_04;

import java.util.*;
import java.util.stream.Collectors;

public class Task_02 {
    public static void main(String[] args) {
        List<String> manName = new ArrayList<>(Arrays.asList(
                "Евгений", "Александр", "Юрий",
                "Тимофей", "Михаил", "Сергей",
                "Евгений", "Александр", "Юрий",
                "Тимофей", "Михаил", "Сергей"
        ));

        List<String> womanName = new ArrayList<>(Arrays.asList(
                "Анна", "Юлия", "Олеся",
                "Янина", "Мария", "Елизавета",
                "Анна", "Юлия", "Олеся",
                "Янина", "Мария", "Елизавета"
        ));

        System.out.println("Коллекция мужских и женских имен:");
        System.out.println(manName);
        System.out.println(womanName);

        System.out.println();

        System.out.println("Уникальный список Set на основании List:");
        uniqueName(manName);
        uniqueName(womanName);

        System.out.println();

        System.out.println("Наименьший элемент (алфавитный порядок):");
        minElement(manName);
        minElement(womanName);

        System.out.println();

        System.out.println("Наибольший элемент (по количеству букв в слове, но в обратном порядке):");
        maxElement(manName);
        maxElement(womanName);

        System.out.println();

        System.out.println("Удаление всех элементов, содержащих букву \"А\" или \"а\":");
        removeElement(manName);
        removeElement(womanName);
    }


    private static void uniqueName(List<String> name) {
        Set<String> uniqueName = new HashSet<>(name);
        System.out.println(uniqueName);
    }


    private static void minElement(List<String> name) {
        Set<String> uniqueName = new HashSet<>(name);
        System.out.println(Collections.min(uniqueName));
    }


    private static void maxElement(List<String> name) {
        Set<String> uniqueName = new HashSet<>(name);
        System.out.println(Collections.max(uniqueName, (a, b) -> Integer.compare(b.length(), a.length())));
    }


    private static void removeElement(List<String> name) {
        Set<String> uniqueName = new HashSet<>(name);
        uniqueName.removeIf(names -> names.contains("А") || names.contains("а"));
        System.out.println(uniqueName);
    }

}
