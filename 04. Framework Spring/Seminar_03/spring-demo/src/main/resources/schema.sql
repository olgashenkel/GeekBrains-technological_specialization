CREATE TABLE IF NOT EXISTS userTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    age int NOT NULL,
    email varchar(50) NOT NULL
);

INSERT INTO userTable (name, age, email) values ('Ivan', 20, 'email@mail.ru');
INSERT INTO userTable (name, age, email) values ('Alex', 28, 'Alex222@mail.ru');
INSERT INTO userTable (name, age, email) values ('Bob', 31, 'Bob13@mail.ru');