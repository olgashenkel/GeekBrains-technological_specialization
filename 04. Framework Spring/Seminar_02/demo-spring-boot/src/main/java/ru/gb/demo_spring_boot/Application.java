package ru.gb.demo_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);

        ApplicationContext context = SpringApplication.run(Application.class, args);

//        UserRepository userRepository = (UserRepository) context.getBean("myUserRepositoryBean");
//        UserRepository userRepository11 = context.getBean("myUserRepositoryBean", UserRepository.class);


//        UserRepository userRepository1 = context.getBean(UserRepository.class);
//        UserRepository userRepository2 = context.getBean(UserRepository.class);
//        UserRepository userRepository3 = context.getBean(UserRepository.class);
//        System.out.println(userRepository1 == userRepository2);
//        System.out.println(userRepository1 == userRepository3);
//        System.out.println(userRepository2 == userRepository3);

//        UserRepository userRepository = new UserRepository();
//        System.out.println(userRepository.getAllOriginal());
//        System.out.println("***************");
//        System.out.println(userRepository.getAllCopy());
//        System.out.println("***************");
//        System.out.println(userRepository.getById(6));
	}

}
