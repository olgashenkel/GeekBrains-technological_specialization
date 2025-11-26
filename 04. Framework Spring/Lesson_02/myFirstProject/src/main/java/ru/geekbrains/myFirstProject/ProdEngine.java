package ru.geekbrains.myFirstProject;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(("prod")) // запуск аннотации @Profile(("здесь указывается свое название для внесения изменений в
// настройках программы, например, в файле application.yml"))
public class ProdEngine implements Engine{

//    public LocalEngine() {
//        System.out.println("Двигатель запущен");
//    }


    public ProdEngine() { // конструктор для изменен под вывод сообщения для аннотации @Profile(("local"))
        System.out.println("Двигатель запущен на сервере");
    }

//    public void go(){
//        System.out.println("Поехали!");
//    }

    public void go(){ // изменение метода под аннотацию @Profile(("local"))
        System.out.println("Поехали быстро!");
    }
}
