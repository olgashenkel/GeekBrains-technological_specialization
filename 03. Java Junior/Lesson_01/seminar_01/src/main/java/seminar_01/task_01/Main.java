package seminar_01.task_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {


//    Library library = new ArrayList<Book>();

    public static void main(String[] args) {

        Library library = new Library();

        // region Создание книг
        Book book1 = new Book("Капитанская дочка", "А.С. Пушкин", 1836);
        Book book2 = new Book("Три сестры", "А.П. Чехов", 1901);
        Book book3 = new Book("Странник по звездам", "Джек Лондон", 1915);
        Book book4 = new Book("Обломов", "И.А. Гончаров", 1858);
        Book book5 = new Book("Маленький принц", "Антуан де Сент-Экзюпери", 1942);
        Book book6 = new Book("Капитанская дочка", "А.С. Пушкин", 1836);
        Book book7 = new Book("Три сестры", "А.П. Чехов", 1901);
        Book book8 = new Book("Война и мир", "Л.Н. Толстой", 1867);
        Book book9 = new Book("Хождение по мукам", "А.Н. Толстой", 1941);
    // endregion

        // region Внесение книг в библиотеку
        library.addBooks(book1);
        library.addBooks(book2);
        library.addBooks(book3);
        library.addBooks(book4);
        library.addBooks(book5);
        library.addBooks(book6);
        library.addBooks(book7);
        library.addBooks(book8);
        library.addBooks(book9);
        // endregion

// Метод, который выводит все книги
//        library.allBooks();

// Метод, который ищет книги по названию
//        library.findBooksByName("Капитанская дочка").forEach(System.out::println);


// Метод, который ищет все книги, изданные после определенного года (например, 2010)
//        library.findBooksByYear(1900).forEach(System.out::println);

// Метод, который выводит все уникальные названия книг в библиотеке
        library.getUniqueBooksByTitle().forEach(System.out::println);
        library.allUniqueBooks();

    }



}
