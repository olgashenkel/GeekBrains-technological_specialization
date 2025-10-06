
# Урок 4. Коллекции

## Домашняя работа 
**Задание № 1 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/02.%20Java%20Development%20Kit/Seminar_04/seminar_04/src/main/java/seminar_04/homework)):**   

Создать справочник сотрудников.

Необходимо:

● Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:  
* Табельный номер   
* Номер телефона  
* Имя   
* Стаж

***Класс "Сотрудник":***
```
package seminar_04.homework;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Employee {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static int startPositionForID = 0;

    @Setter(AccessLevel.NONE)
    private int personnelNumber;    // Табельный номер сотрудника
    private String phoneEmployee;           // Телефон
    private String nameEmployee;            // Имя
    private int experienceEmployee;         // Стаж (лет)

    public Employee(String phoneEmployee, String nameEmployee, int experienceEmployee) {
        this.personnelNumber = ++startPositionForID;
        this.phoneEmployee = phoneEmployee;
        this.nameEmployee = nameEmployee;
        this.experienceEmployee = experienceEmployee;
    }

    @Override
    public String toString() {
        return "Табельный номер: " + personnelNumber +
                "; Номер телефона: " + phoneEmployee +
                "; Имя: " + nameEmployee +
                "; Стаж (лет): " + experienceEmployee + "\n";

    }
}
```
***Класс "Справочник сотрудников":***
```
package seminar_04.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeDirectory {
    private final Map<Integer, Employee> employees;

    public EmployeeDirectory() {
        this.employees = new HashMap<>();
    }
}
```

● Добавить метод, который ищет сотрудника по стажу (может быть список)
```
    public List<Employee> findExperienceEmployee(int experienceEmployee) {

//        // 1-ый вариант

//        List<Employee> findEmployee = new ArrayList<>();
//        for (Employee emp : employees.values()){
//            if (emp.getExperienceEmployee() == experienceEmployee){
//                findEmployee.add(emp);
//            }
//        }
//        System.out.println("Сотрудники со стажем " + experienceEmployee + " лет:");
//        return findEmployee;


        // 2-ой вариант

        System.out.println("Сотрудники со стажем " + experienceEmployee + " лет:");
        return employees.values().stream()
                .filter(employee -> employee.getExperienceEmployee() == experienceEmployee)
                .collect(Collectors.toList());
    }
```

● Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
```
public List<String> findPhoneByName(String nameEmployee) {
    List<String> findEmployee = new ArrayList<>();
    for (Employee emp : employees.values()){
        if (emp.getNameEmployee().equals(nameEmployee)){
            findEmployee.add(emp.getPhoneEmployee());
        }
    }
    System.out.println("Телефон сотрудника " + nameEmployee);
    return findEmployee;
}
```

● Добавить метод, который ищет сотрудника по табельному номеру
```
public Employee findEmployeePersonnelNumber(int personnelNumber) {
    System.out.println("Сотрудник с табельным номером \"" + personnelNumber + "\":");
    return employees.get(personnelNumber);
}
```

● Добавить метод добавления нового сотрудника в справочник
```
public boolean addEmployees(Employee employee) {
    if (employees.containsKey(employee.getPersonnelNumber())) {
        System.out.printf("Ошибка! Сотрудник с табельным номером \"%d\" уже был внесен!\n",
                employee.getPersonnelNumber());
        return false;
    }
    employees.put(employee.getPersonnelNumber(), employee);
    return true;
}
```


---

## Практическая работа 

**Задание № 1 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/02.%20Java%20Development%20Kit/Seminar_04/seminar_04/src/main/java/seminar_04/Task_01.java)):**

В рамках выполнения задачи необходимо:   
● Создайте коллекцию мужских и женских имен с помощью интерфейса List   
```
    List<String> manName = new ArrayList<>();
    Collections.addAll(manName,
            "Евгений", "Анатолий", "Юрий",
            "Тимофей", "Аркадий", "Михаил", "Сергей"
    );

    List<String> womanName = new ArrayList<>();
    Collections.addAll(womanName,
            "Антонина", "Юлия", "Олеся",
            "Янина", "Анжелика", "Мария", "Евгения"
    );
```
● Отсортируйте коллекцию в алфавитном порядке   
```
    private static void sortedList(List<String> name) {
        Collections.sort(name);
        System.out.println(name);
    }
```
● Отсортируйте коллекцию по количеству букв в слове   
```
    private static void sortedListLength(List<String> name) {
        name.sort(Comparator.comparingInt(String::length));
        System.out.println(name);
    }
```
● Разверните коллекцию
```
    private static void reverseList(List<String> name) {
        Collections.reverse(name);
        System.out.println(name);
    }
```


**Задание № 2 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/02.%20Java%20Development%20Kit/Seminar_04/seminar_04/src/main/java/seminar_04/Task_02.java)):**

В рамках выполнения задачи необходимо:   
● Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
```
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
```
● Получите уникальный список Set на основании List
```
    private static void uniqueName(List<String> name) {
        Set<String> uniqueName = new HashSet<>(name);
        System.out.println(uniqueName);
    }
```
● Определите наименьший элемент (алфавитный порядок)
```
    private static void minElement(List<String> name) {
        Set<String> uniqueName = new HashSet<>(name);
        System.out.println(Collections.min(uniqueName));
    }
```
● Определите наибольший элемент (по количеству букв в слове, но в обратном порядке)
```
    private static void maxElement(List<String> name) {
        Set<String> uniqueName = new HashSet<>(name);
        System.out.println(Collections.max(uniqueName, (a, b) -> Integer.compare(b.length(), a.length())));
    }
```

● Удалите все элементы, содержащие букву ‘A’
```
    private static void removeElement(List<String> name) {
        Set<String> uniqueName = new HashSet<>(name);
        uniqueName.removeIf(names -> names.contains("А") || names.contains("а"));
        System.out.println(uniqueName);
    }
```

**Задание № 3 ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/blob/main/02.%20Java%20Development%20Kit/Seminar_04/seminar_04/src/main/java/seminar_04/Task_03.java)):**

В рамках выполнения задачи необходимо:   
● Создайте телефонный справочник с помощью Map - телефон это ключ, а имя - значение
```
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
```
● Найдите человека с самым маленьким номером телефона
```
    private static void findMinPhone(Map<Long, String> phone) {
        Long minPhone = Collections.min(phone.keySet());
        System.out.printf("Самый маленький номер телефона %d " +
                "принадлежит контакту \"%s\"", minPhone, phone.get(minPhone));
    }
```
● Найдите номер телефона человека, чье имя самое большое в алфавитном порядке
```
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
```