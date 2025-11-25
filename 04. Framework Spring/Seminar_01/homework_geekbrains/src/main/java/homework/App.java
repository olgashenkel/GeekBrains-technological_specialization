package homework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
    // 1. Создание коллекции объектов
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Иван", "Иванов", 25));
        persons.add(new Person("Артем", "Артемов", 35));
        persons.add(new Person("Семен", "Семенов", 45));


    // 2. Использование Gson для сериализации
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(persons);

        System.out.println("Сериализованный объект (JSON):");
        System.out.println(json);

    // 3. Использование Gson для десериализации
        // 1) Определение типа коллекции
        Type listOfPersonType = new TypeToken<List<Person>>(){}.getType();
        // 2) Десериализация
        List<Person> read = gson.fromJson(json, listOfPersonType);
        // 3) Вывод результата
        System.out.println("Десериализованный объект (JSON): " + read);

    }
}
