package ru.gb.demo_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Controller

@RestController()
/* @RestController в Spring — это аннотация, которая помечает класс как контроллер
для обработки REST-запросов, возвращающий данные (обычно JSON или XML),
а не HTML-страницы. Это метааннотация, объединяющая @Controller и @ResponseBody,
что автоматически означает, что возвращаемое методом значение метода контроллера
 будет напрямую записываться в тело ответа, без рендеринга представления
 */
@RequestMapping("/users")
public class UserController {
//    // этот класс принимает запросы и отправляет ответы с помощью следующих аннотаций
//
//    // http://ip-address/users -> List<User>
//    // http://ip-address/users/1 -> User(1, Igor)
//    // http://ip-address/users?name=Igor -> User(1, Igor)
//
////    @RequestMapping(path = "/users", method = RequestMethod.GET) // альтернативная аннотация (можно использовать
//    // вместо @GetMapping, но со вторым параметром)
//        @GetMapping(path = "/users") // альтернативная аннотация (можно использовать вместо @RequestMapping, но без
//    // второго параметра)
////    @ResponseBody // данная аннотация не нужна, если стоит аннотация @RestController
//    public List<User> getUsers() {
//        return List.of(new User("Igor"), new User("unknown"));
//    }
//
    /// /    public String getUsers() { // метод без аннотации @ResponseBody
    /// /        return "page.html";
    /// /    }

    private final UserRepository repository;

    //    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/all")
    public List<User> getUsers() {
        // http://ip-address/users -> List<User> - отработка запроса: вывода всех Users
        return repository.getAllCopy();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        // http://ip-address/users/1 -> User(1, Igor) - отработка запроса: поиск по ID
        return repository.getById(id);
    }

    @GetMapping()
    public User getUserByName(@RequestParam String name) {
        // // http://ip-address/users?name=Igor -> User(1, Igor) - отработка запроса: поиск по имени
        return repository.getByName(name);
    }

    @GetMapping("/delete/{id}")
    public User deleteUser(@PathVariable long id) {
        return repository.deleteById(id);
    }

}



    /*
    @ResponseBody в Spring — это аннотация, которая указывает контроллеру возвращать объект
     напрямую в тело HTTP-ответа (например, в формате JSON или XML),
     а не как номер страницы или вид.
     Это основная аннотация для создания REST-сервисов, так как она автоматически
     сериализует (преобразует) возвращаемый объект Java в нужный формат для клиента.

Как это работает
Сериализация:
 Когда метод контроллера с аннотацией @ResponseBody завершается,
Spring берёт возвращаемый объект и преобразует его в формат, который ожидает клиент
(часто JSON или XML).

Отсутствие необходимости ручной обработки:
 Это избавляет от необходимости вручную формировать HTTP-ответ, устанавливать заголовки и т.д..

Использование в REST-контроллерах:
 В сочетании с аннотацией @RestController, которая является комбинацией @Controller
 и @ResponseBody, эта аннотация применяется автоматически ко всем методам контроллера.

Ключевое различие с @RequestBody
@RequestBody:
Применяется к параметрам метода контроллера. Он используется для преобразования входящего HTTP-запроса (например, JSON) в объект Java.
@ResponseBody:
Применяется к методу контроллера. Он используется для преобразования исходящего объекта
Java обратно в тело HTTP-ответа.

Альтернатива ResponseEntity
Аннотация @ResponseBody проста, но для более гибкого контроля над ответом
(например, установки статусов и заголовков) рекомендуется использовать ResponseEntity<T>.
ResponseEntity представляет весь ответ и позволяет более детально настраивать его
     */
