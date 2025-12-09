package ru.gb.spring_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_demo.domain.User;
import ru.gb.spring_demo.services.RegistrationService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")    //localhost:8080/user
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

//    @PostMapping("/body")
//    public String userAddFromBody(@RequestBody User user) {
//        service.getDataProcessingService().getRepository().setUser(user);
//        return "User added from body!";
//    }

    @PostMapping("/body")
    public String userAddFromParam(@RequestBody Map<String, Object> requestBody) {
        String name = (String) requestBody.get("name");
        Integer age = (Integer) requestBody.get("age");
        String email = (String) requestBody.get("email");
        service.processRegistration(name,age, email);
        return "User added from body!";
    }

}