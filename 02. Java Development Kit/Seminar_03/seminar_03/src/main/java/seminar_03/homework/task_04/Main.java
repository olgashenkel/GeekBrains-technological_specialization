package seminar_03.homework.task_04;

public class Main {
    public static void main(String[] args) {

        Database db = new Database();

        User user1 = new User();
        user1.setName("Иванов Иван Иванович");
        user1.setEmail("ivanov@email.com");

        User user2 = new User();
        user2.setName("Сидоров Егор Игоревич");
        user2.setEmail("sidorov@email.com");

        System.out.println("Сотрудник: " + db.save(user1));
        System.out.println("Сотрудник: " + db.save(user2));
        System.out.println(db.getAll());

        db.delete(user1.getId());
        System.out.println(db.getAll());
    }
}