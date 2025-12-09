package ru.gb.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring_demo.domain.User;

@Service
public class RegistrationService {
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
    //Поля UserService, NotificationService
    private final UserService userService;
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private DataProcessingService dataProcessingService;


    public void processRegistration (String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        notificationService.sendNotification("The created user is added to the repository");
    }


    public RegistrationService(UserService userService, NotificationService notificationService, DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }
}