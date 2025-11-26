package ru.geekbrains.myFirstProject;


/*
Для корректного запуска проекта в Spring Boot - лучше всего это делать через зависимости


 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Car {
//    Engine_1 engine1;

//    // Внедрение Engine_1 в класс Car с помощью конструктора
//    // И это не единственный способ внедрять зависимости (более подробное описание см. ниже)
//    // 1-ый способ - через конструктор:
//    public Car(Engine_1 engine1) {
//        this.engine1 = engine1;
//        engine1.go();
//    }


//    // 2-ой способ - через Setter:
//    // для это необходим конструктор по умолчанию
//    // и создание Setter
//    public Car() {
//    }
//
//    public void setEngin(Engine_1 engine1) {
//        this.engine1 = engine1;
//        engine1.go();
//    }


//    // 3-ий способ (для самых ленивых):
//    @Autowired
//    Engine_1 engine1;
//
//
//    public void start() { // метод написан для класса CarController
//        engine1.go();
//    }


    // Методы для интерфейса Engine
    @Autowired
    Engine engine;


    public void start() { // метод написан для класса CarController
        engine.go();
    }

}

/*
Всего 3 основных способа внедрения зависимостей:
1!!!. Самый лучший и самый основной (чтобы избежать циклических зависимостей и прочих проблем при тестировании!!!)
        необходимо стараться ВСЕГДА в своих проектах ВНЕДРЯТЬ зависимости
        ЧЕРЕЗ КОНСТРУКТОР!!!
        Бывают случаи, когда необходимо внедрять конструкторы через Setter, но этих случаев бывает очень мало (~1%)

2. 2-ой способ - через Setter:

3. 3-ий способ (для самых ленивых) - через @Autowired

 */
