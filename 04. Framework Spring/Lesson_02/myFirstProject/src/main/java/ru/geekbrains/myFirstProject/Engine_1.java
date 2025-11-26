package ru.geekbrains.myFirstProject;

import org.springframework.stereotype.Component;

@Component
public class Engine_1 {

    public Engine_1() {
        System.out.println("Двигатель запущен");
    }


    public void go(){
        System.out.println("Поехали!");
    }
}
