package seminar_04.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class StudentsRepositoryImpl implements StudentsRepository{

    @Override
    public void add(Student item) {
        String URL = "jdbc:mysql://localhost:3306";
        String USER = "root";
        String PASSWORD = "helga-linux";

        // Подключение к БД
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) // Подключение к базе данных
        {
            String insertDataSQL = "INSERT INTO students (name, age) VALUES (?, ?);";
            try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
                statement.setString(1, item.getName());
                statement.setInt(2, item.getAge());
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Student item) {

    }

    @Override
    public void delete(Student item) {

    }

    @Override
    public Student getById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Student> getAll() {
        return List.of();
    }
}
