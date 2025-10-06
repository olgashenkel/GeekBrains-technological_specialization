package seminar_04.homework;

public class Main {
    public static void main(String[] args) {

        EmployeeDirectory employeeDirectory = new EmployeeDirectory();

        Employee employee1 = new Employee("89991112233", "Иванов Иван Иванович", 20);
        Employee employee2 = new Employee("81112223344", "Петрова Елизавета Александровна", 12);
        Employee employee3 = new Employee("82223334455", "Сидоров Алексей Алексеевич", 2);
        Employee employee4 = new Employee("83334445566", "Васильев Сергей Витальевич", 0);
        Employee employee5 = new Employee("84445556677", "Сидорова Антонина Алексеевна", 2);
        Employee employee6 = new Employee("85556667788", "Сидорова Антонина Алексеевна", 2);

        employeeDirectory.addEmployees(employee1);
        employeeDirectory.addEmployees(employee2);
        employeeDirectory.addEmployees(employee3);
        employeeDirectory.addEmployees(employee4);
        employeeDirectory.addEmployees(employee5);
        employeeDirectory.addEmployees(employee6);
        employeeDirectory.addEmployees(employee1);

        System.out.println();
        employeeDirectory.allEmployees();

        System.out.println();
        System.out.println(employeeDirectory.findEmployeePersonnelNumber(3));

        System.out.println(employeeDirectory.findExperienceEmployee(1));

        System.out.println();
        System.out.println(employeeDirectory.findPhoneByName("Сидорова Антонина Алексеевна"));

    }
}
