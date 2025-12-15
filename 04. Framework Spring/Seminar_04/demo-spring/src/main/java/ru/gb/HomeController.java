package ru.gb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String name, @RequestParam(required = false) String color, Model model) {
        // @RequestParam(required = false) String name =>> будет выводить имя пользователя, а если его нет, то
        // определенную константу
        if (name != null) {
            model.addAttribute("name", name);
        } else {
            model.addAttribute("name", "world");
        }
        model.addAttribute("myColor", (color == null ? "black" : color));
        return "home";
    }


    // Метод для передачи строк
//    @GetMapping("/list")
//    public String list(@RequestParam int count, Model model) {
//        List<String> items = new ArrayList<>();
//        for (int i = 1; i <= count; i++) {
//             items.add("Item # " + i);
//        }
//        model.addAttribute("items", items);
//        return "list";
//    }

    // Метод для передачи java-объектов
    @GetMapping("/list")
    public String list(@RequestParam int count, Model model) {
        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            items.add(new Item(i, "Item # " + i));
        }
        model.addAttribute("items", items);
        return "list";
    }

    @GetMapping("/table")
    public String table(Model model) {
        List<Person> people = List.of(
                new Person("Ivanov", "Ivan", 20, "GeekBrains"),
                new Person("Sidorov", "Ivan", 30, "GeekBrains"),
                new Person("Petrov", "Ivan", 25, "GeekBrains")
        );
        model.addAttribute("people", people);
        return "table";
    }
}
