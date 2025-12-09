package ru.gb.spring_demo.services;

import org.springframework.stereotype.Service;
import ru.gb.spring_demo.domain.User;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public void sendNotification(String s) {
        System.out.println(s);
    }

}