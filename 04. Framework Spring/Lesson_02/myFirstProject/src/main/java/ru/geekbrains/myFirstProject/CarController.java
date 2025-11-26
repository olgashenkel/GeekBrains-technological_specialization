package ru.geekbrains.myFirstProject;

// Пример работы Spring в клиент/серверном приложении
// Пример внедрения зависимостей в Spring

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RestController — это аннотация Spring, которая говорит, что этот класс
// является контроллером, и он должен обрабатывать веб-запросы.

public class CarController {

    @Autowired  // такой подход нежелателен
    Car car;

    // чтобы запустить метод startCar() из вне нужно добавить аннотацию @GetMapping("/car")
    @GetMapping("/car")
    public String startCar() {
        car.start();
        return "Автомобиль запущен!";
    }
}
