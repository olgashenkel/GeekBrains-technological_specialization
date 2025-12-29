package ru.gb;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import ru.gb.model.User;
import ru.gb.repository.UserRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataDemoApplication {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringDataDemoApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

//        User user = new User();
//        user.setId(1L);
//        user.setName("Igor");
//        userRepository.save(user);

        for (int i = 15; i <= 25; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("User # " + i);
            user.setAge(i);
            userRepository.save(user);
        }

//        System.out.println(userRepository.findAllByName("Igor"));

        System.out.println(userRepository.findByAgeGreaterThan(Pageable.ofSize(3), 20));

//        Optional<User> foundUser = userRepository.findById(1L);
//        foundUser.ifPresent(it -> System.out.println(it));
//
//        userRepository.findById(2L).ifPresentOrElse(System.out::println, () -> System.out.println("Не найден " +
//                "пользователь с индентификатором '2'"));


//
//        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//
//        jdbcTemplate.execute("create table users(id bigint, name varchar(512))");
//        jdbcTemplate.execute("insert into users(id, name) values(1, 'Igor')");
//
//        List<User> users = jdbcTemplate.query("select id, name from users", new RowMapper<User>() {
//
//            @Override
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return new User(rs.getLong("id"), rs.getString("name"));
//            }
//        });
//
//        DataSource dataSource = context.getBean(DataSource.class);
//        try (Connection connection = dataSource.getConnection()) {
//            try (Statement statement = connection.createStatement()) {
//                statement.execute("create table users(id bigint, name varchar(512))");
//            }
//
//            try (Statement statement = connection.createStatement()) {
//                statement.execute("insert into users(id, name) values(1, 'Igor')");
//            }
//
//            try (Statement statement = connection.createStatement()) {
//                ResultSet resultSet = statement.executeQuery("select id, name from users");
//                while (resultSet.next()) {
//                    System.out.println(resultSet.getInt("id"));
//                    System.out.println(resultSet.getString("name"));
//                }
//            }
//        }
//
//    }
//
//    @Data
//    @AllArgsConstructor
//    static class User{
//        long id;
//        String name;
    }
}
