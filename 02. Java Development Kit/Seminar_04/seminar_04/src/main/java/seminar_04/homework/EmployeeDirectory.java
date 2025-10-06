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

    // Метод добавления нового сотрудника в справочник
    public boolean addEmployees(Employee employee) {
        if (employees.containsKey(employee.getPersonnelNumber())) {
            System.out.printf("Ошибка! Сотрудник с табельным номером \"%d\" уже был внесен!\n",
                    employee.getPersonnelNumber());
            return false;
        }
        employees.put(employee.getPersonnelNumber(), employee);
        return true;
    }


    // Метод, который ищет сотрудника по стажу (может быть список)
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


    // Метод, который выводит номер телефона сотрудника по имени (может быть список)
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


    // Метод, который ищет сотрудника по табельному номеру
    public Employee findEmployeePersonnelNumber(int personnelNumber) {
        System.out.println("Сотрудник с табельным номером \"" + personnelNumber + "\":");
        return employees.get(personnelNumber);
    }

    // Метод, который выводит всех сотрудников
    public void allEmployees(){
        for (Map.Entry<Integer, Employee> emp : employees.entrySet()){
            System.out.print("№ " + emp.getKey() + ". " + emp.getValue());
        }
    }

}
