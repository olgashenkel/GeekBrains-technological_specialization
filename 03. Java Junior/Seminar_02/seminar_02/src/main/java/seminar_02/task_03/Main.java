package seminar_02.task_03;

import java.util.UUID;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        Employee user = new Employee("Ivanov", "email@mail.ru");
        UUID pk = UUID.randomUUID();
        user.setId(pk);

        QueryBuilder queryBuilder = new QueryBuilder();
        String insertQuery = queryBuilder.buildInsertQuery(user);
        System.out.printf("Insert Query: %s\n", insertQuery);

    }
}
