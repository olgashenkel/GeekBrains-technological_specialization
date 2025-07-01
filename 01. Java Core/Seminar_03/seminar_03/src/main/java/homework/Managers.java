package homework;

import java.time.LocalDate;

public class Managers extends Employee{


    public Managers(String lastName, String firstName, String fatherName, LocalDate birthDate, String function, String phone, int salary) {
        super(lastName, firstName, fatherName, birthDate, function, phone, salary);
    }

    // метод для увеличения з/п сотрудникам старше заданного возраста
    public static void increaserSalary(Employee[] array, int age, int amount) {
        for (Employee employee : array) {
            if (!(employee instanceof Managers)) {
                if (employee.getAge() > age) {
                    employee.salaryUp(amount);
                }
            }
        }
    }
}
