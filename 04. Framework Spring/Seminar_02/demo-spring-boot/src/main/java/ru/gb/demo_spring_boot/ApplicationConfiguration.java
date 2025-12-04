package ru.gb.demo_spring_boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// java-based configuration
@Configuration
public class ApplicationConfiguration {

    @Bean
    UserRepository myUserRepository(){
        return new UserRepository();
    }
}
