package seminar_04;

import java.util.*;

public class Task_03 {

    public static void main(String[] args) {
        Map<Long, String> phoneBook = new HashMap<>();
        phoneBook.put(11111111111L, "Алексей");
        phoneBook.put(22222222222L, "Иван");
        phoneBook.put(33333333333L, "Тимофей");
        phoneBook.put(44444444444L, "Юрий");
        phoneBook.put(44444444445L, "Юра");
        phoneBook.put(55555555555L, "Савелий");
        phoneBook.put(66666666666L, "Игнат");
        phoneBook.put(77777777777L, "Рустам");
        phoneBook.put(88888888888L, "Алевтина");
        phoneBook.put(99999999999L, "Олеся");
        phoneBook.put(10101010101L, "Юрий");

        findMinPhone(phoneBook);
        System.out.println();

        findMaxName(phoneBook);
        System.out.println(findMaxName(phoneBook));

    }


    private static void findMinPhone(Map<Long, String> phone) {
        Long minPhone = Collections.min(phone.keySet());
        System.out.printf("Самый маленький номер телефона %d " +
                "принадлежит контакту \"%s\"", minPhone, phone.get(minPhone));
    }

    private static String findMaxName(Map<Long, String> name) {
        String names = Collections.max(name.values());
        Long keys = 0L;
        for (Map.Entry<Long, String> el : name.entrySet()) {
            if (el.getValue().equals(names)) {
                keys = el.getKey();
            }
        }
        return String.format("Наибольшее имя в алфавитном порядке \"%s\" с номером телефона - %d",
                names, keys);
    }

}
