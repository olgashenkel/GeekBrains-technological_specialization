package ru.gb.demo_spring_boot;

import lombok.Data;

@Data
public class User {

    private static long idCounter = 1L;

    private long id;
    private String name;

    public User(String name) {
        this.id = idCounter++;
        this.name = name;
    }

}
