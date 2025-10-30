package seminar_01.task_01;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Book {

    //region Поля
    /**
     * ID книги
     */
    private static int startID = 0;
    private int ID;

    /**
     * Наименование
     */
    private String name;

    /**
     * Автор
     */
    private String author;

    /**
     * Год издания
     */
    private int year;

    //endregion


    //region Конструктор
    public Book(String name, String author, int year) {
        this.ID = ++startID;
        this.name = name;
        this.author = author;
        this.year = year;
    }
    //endregion


    @Override
    public String toString() {
        return "ID книги: '" + ID + '\'' +
                ", Наименование: '" + name + '\'' +
                ", Автор: '" + author + '\'' +
                ", год издания: " + year;
    }
}
