package ru.gb.lesson_05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        userRepository.save(new User(null, "Helga", "1111@mail.ru"));
        userRepository.save(new User(null, "Helga1", "2222@mail.ru"));
        userRepository.save(new User(null, "Helga2", "3333@mail.ru"));
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }
}
