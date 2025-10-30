package seminar_01.task_01;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class Library {
    private List<Book> books = new ArrayList<>();


    public void addBooks(Book book) {
        books.add(book);
    }

    // Метод для получения книги по ID
    public Book getBookByID(Integer id) {
        return books.get(id);
    }


    // Метод, который выводит все книги
    public void allBooks() {
        /**
         * Обычный способ:
         */
//        for (Book book : books) {
//            System.out.println(book);
//        }

        /**
         * Использование лямбда-выражений:
         */
        books.forEach(System.out::println);

    }

    // Метод, который ищет книги по названию
    public List<Book> findBooksByName(String nameBook) {
        /**
         * Обычный способ:
         */
//        List<Book> foundBooks = new ArrayList<>();
//        for (Book book : books) {
//            if (book.getName().equalsIgnoreCase(nameBook)) {
//                foundBooks.add(book);
//            }
//        }
//        return foundBooks;

        /**
         * Использование лямбда-выражений:
         */
        return books.stream().filter(book -> book.getName().equalsIgnoreCase(nameBook)).toList();
    }

    // Метод, который ищет все книги, изданные после определенного года
    public List<Book> findBooksByYear(Integer year) {
        /**
         * Обычный способ:
         */
//        List<Book> foundBooks = new ArrayList<>();
//        for (Book book : books) {
//            if (book.getYear() > year) {
//                foundBooks.add(book);
//            }
//        }
//        return foundBooks;

        /**
         * Использование лямбда-выражений:
         */
        return books.stream().filter(book -> book.getYear() > year).toList();
    }

    // Метод, который выводит все уникальные названия книг в библиотеке
    public void allUniqueBooks() {
        /**
         * Обычный способ:
         */
        Set<String> uniqueBook = new HashSet<>();
        for (Book book : books) {
            uniqueBook.add(book.getName());
        }
        for (String nameBook : uniqueBook) {
            System.out.println(nameBook);
        }
    }

    /**
     * Использование лямбда-выражений:
     */
    public List<Book> getUniqueBooksByTitle() {
        return new ArrayList<>(books
                .stream()
                .collect(Collectors.toMap(
                        Book::getName,
                        book -> book,
                        (first, second) -> first
                ))
                .values());
    }

}
