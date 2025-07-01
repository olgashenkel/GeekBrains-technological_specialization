package homework;

import java.time.LocalDate;
import java.util.Arrays;

import static homework.Employee.*;
import static homework.Managers.increaserSalary;

public class Main {
    public static void main(String[] args) {
        Employee[] company = {
                new Employee("Vasilieva", "Vasilisa",
                        "Vasilievna", LocalDate.of(1984, 1, 1), "sistem.admin",
                        "89993332211", 70000),
                new Employee("Ivanov", "Ivan",
                        "Ivanovich", LocalDate.of(2005, 2, 2), "sistem.admin",
                        "89993332211", 50000),
                new Employee("Petrov", "Petr",
                        "Petrovih", LocalDate.of(1995, 3, 3), "sistem.admin",
                        "89993332211", 45000),
                new Employee("Sodorov", "Vladimir",
                        "Vladimirovich", LocalDate.of(1974, 4, 4), "sistem.admin",
                        "89993332211", 100000),
                new Employee("Vasechkin", "Vasiliy",
                        "Vasilievich", LocalDate.of(1963, 5, 5), "sistem.admin",
                        "89993332211", 120000),
                new Managers("Managers_1", "Gennadiy", "Gennadievich",
                        LocalDate.of(1968, 6, 6), "manager", "89991112233", 200000)};

        System.out.println(Arrays.toString(company));
        System.out.println(averageSalary(company));
        System.out.println(middleAge(company));

        int age = 45;
        int amount = 5000;

        increaserSalary(company, age, amount);
        System.out.println(Arrays.toString(company));


        System.out.println(averageSalary(company));
        System.out.println(middleAge(company));


    }

}
