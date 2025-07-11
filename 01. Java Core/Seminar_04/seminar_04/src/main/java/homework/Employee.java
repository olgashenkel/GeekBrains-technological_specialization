package homework;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Setter
@Getter
public class Employee {
    String lastName;
    String firstName;
    String fatherName;
    LocalDate birthDate;
    Gender gender;
    String function;
    String phone;
    int salary;


    public Employee(String lastName, String firstName, String fatherName,
                    LocalDate birthDate, Gender gender, String function, String phone, int salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.function = function;
        this.phone = phone;
        this.salary = salary;
    }


    // метод для вычисления возраста сотрудника
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // метод для увеличения з/п сотрудника
    public void salaryUp(int amount) {
        this.salary += amount;
    }


    // метод для вычисления среднего возраста сотрудников
    public static double middleAge(Employee[] array) {
        if (array.length == 0) {
            System.out.println("Массив пуст!");
            return 0;
        }
        int sum = 0;
        for (Employee employee : array) {
            sum += employee.getAge();
        }
        System.out.print("Средний возраст сотрудников составляет - ");
        return (double) sum / array.length;
    }

    // метод для вычисления средней з/п
    public static double averageSalary(Employee[] array) {
        if (array.length == 0) {
            System.out.println("Массив пуст!");
            return 0;
        }
        int sum = 0;
        for (Employee employee : array) {
            sum += employee.salary;
        }
        System.out.print("\nСредняя з/п сотрудников составляет - ");
        return (double) sum / array.length;
    }

    // прототип компаратора - метод внутри класса сотрудника, сравнивающий две даты,
    // представленные в виде трёх чисел гггг-мм-дд, без использования условного оператора
    public static int compareDates(int yyyy1, int mm1, int dd1, int yyyy2, int mm2, int dd2) {
        int date1 = yyyy1 * 10000 + mm1 * 100 + dd1;
        int date2 = yyyy2 * 10000 + mm2 * 100 + dd2;
        return Integer.compare(date1, date2);
    }


    // метод вычисления праздничного дня и поздравление сотрудников
    public static void happyHoliday(Employee[] array) {
        LocalDate dateNow = LocalDate.now();
        for (int i = 0; i < array.length; i++) {
            if (LocalDate.now().isEqual(Holidays.FEBRUARY_23.getHoliday()) &&
                    array[i].gender.equals(Gender.MALE)) {
                System.out.println(array[i].lastName + " " + array[i].firstName
                        + " " + array[i].fatherName + " - С Днём защитника Отечества!");
            } else if (LocalDate.now().isEqual(Holidays.MARCH_8.getHoliday()) &&
                    array[i].gender.equals(Gender.FEMALE)) {
                System.out.println(array[i].lastName + " " + array[i].firstName + " " + array[i].fatherName +
                        " - С Международным Женским днём - 8 Марта!");
            } else if (LocalDate.now().isEqual(Holidays.NEW_YEAR.getHoliday())) {
                System.out.println(array[i].lastName + " " + array[i].firstName + " " + array[i].fatherName +
                        " - Счастливого Нового года!");
            } else {
                System.out.println(array[i].lastName + " " + array[i].firstName + " " + array[i].fatherName +
                        " - Хорошего рабочего дня!");
            }

        }
    }


    public String info() {
        String info = "Сотрудник:\n" +
                "ФИО - " + lastName + " " + firstName + " " + fatherName +
                ", возраст - " + getAge() +
                ", пол - " + gender + '\n' +
                "должность - " + function +
                ", телефон - " + phone +
                ", заработная плата - " + salary;
        System.out.println(info);
        return info;
    }

    @Override
    public String toString() {
        return "\nСотрудник:\n" +
                "ФИО - " + lastName + " " + firstName + " " + fatherName +
                ", возраст - " + getAge() +
                ", пол - " + gender + '\n' +
                "должность - " + function +
                ", телефон - " + phone +
                ", заработная плата - " + salary;
    }


}
