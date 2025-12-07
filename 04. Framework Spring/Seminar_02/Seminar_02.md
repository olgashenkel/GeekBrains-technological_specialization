
# Урок 2. Основы Spring. Spring Boot

### План урока

- Создание простого Spring Boot приложения.
- Настройка и использование Spring Dependency Injection.
- Создание простого REST контроллера.

## Домашняя работа ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/04.%20Framework%20Spring/Seminar_02/demo-spring-boot/src/main/java/ru/gb/demo_spring_boot))
**Задание:** 

Базовое задание:   
Добавить в простое CRUD веб-приложение, которое было разработано на семинаре функцию удаления данных о пользователе:
1) В класс UserRepository добавить метод public void deleteById(int id)(подсказка: SQL запрос "DELETE FROM userTable WHERE id=?", метод jdbc.update) - удаления записи пользователя из БД по ID.

2) В класс UserService добавить метод public void deleteById(int id)(подсказка: в нем вызывается метод userRepository.deleteById) - удаление пользователя через репозиторий.
```
public void deleteById(long id) {
    users.removeIf(t -> t.getId() == id);
}
```
3) В класс UserController добавить метод public String deleteUser(@PathVariable("id") int id)(с аннотацией: @GetMapping("user-delete/{id}")) (подсказка: в нем вызывается метод userService.deleteById) - перехват команды на удаление студента от браузера.

```
@GetMapping("/delete/{id}")
public List<User> deleteUser(@PathVariable long id) {
    // // http://ip-address/delete/1 -> User(1, Igor) - отработка запроса: удаление по ID
    repository.deleteById(id);
    return repository.getAllCopy(); // вывод списка
}
```

Если задание выполнено верно, то при запуске приложения по адресу http://localhost:8180/users будет работать кнопка удаления пользователя по ID.

Задание "со звездочкой":   
Реализовать метод обновления данных о пользователе.
- @GetMapping("/user-update/{id}")
- @PostMapping("/user-update")
- User update(User user)
- User getOne(int id)

```
// Метод добавления User
public List<User> addUser(User user) {
    users.add(new User(user.getName()));
    return users;
}

// Метод обновления User по ID
public User updateUser(long id, User user) {
    User user1 = getById(id);
    if (user1 != null) {
        user1.setName(user.getName());
    }
    return user1;
}
```

```
// Метод для добавления нового User
@PostMapping("/add/{name}")
public List<User> addUser(User user) {
    repository.addUser(user);
    return repository.getAllCopy();
}

@PutMapping("/update/{id}/{name}")
public List<User> updateUser(@PathVariable long id, User user) {
    repository.updateUser(id, user);
    return repository.getAllCopy(); // вывод списка
}
```

## Практическая работа с семинара ([решение](https://github.com/olgashenkel/GeekBrains-technological_specialization/tree/main/04.%20Framework%20Spring/Seminar_02/demo-spring-boot/src/main/java/ru/gb/demo_spring_boot))