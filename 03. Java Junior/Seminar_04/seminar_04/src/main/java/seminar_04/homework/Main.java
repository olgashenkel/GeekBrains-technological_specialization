package seminar_04.homework;

public class Main {
    public static void main(String[] args) {

        WorkingDatabase workingDatabase = new WorkingDatabase();

        Person person1 = new Person("Иванов Иван Иванович", 20);
        Person person2 = new Person("Сидорова Антонина Павловна", 30);
        Person person3 = new Person("Чехов Антон Павлович", 44);

        // Внесение данных в БД
        workingDatabase.createPerson(person1);
        workingDatabase.createPerson(person2);
        workingDatabase.createPerson(person3);

        // Чтение данных из БД
        System.out.println("\n************************************");
        System.out.println("Все сведения из БД Person: ");
        workingDatabase.readAllPersons().forEach(System.out::println);

        // 3. Обновление данных БД
        workingDatabase.updatePerson(1, "Инкогнито");

        // Проверка обновления
        System.out.println("\n************************************");
        System.out.println("Сведения из БД Person после обновления");
        workingDatabase.readAllPersons().forEach(System.out::println);

        // 4. Удаление данных из БД по id
        workingDatabase.deletePerson(2);

        // Проверка удаления
        System.out.println("\n************************************");
        System.out.println("Сведения из БД Person после удаления");
        workingDatabase.readAllPersons().forEach(System.out::println);


    }
}