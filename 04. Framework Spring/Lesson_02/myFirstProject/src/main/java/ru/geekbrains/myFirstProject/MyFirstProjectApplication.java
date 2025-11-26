package ru.geekbrains.myFirstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstProjectApplication.class, args);
//        Car car = new Car(new Engine_1());   // для работы со Spring - данная строка кода теряет свою актуальность

	}

}
