package seminar_03.task_02;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;


/**
 * Данный класс ToDoV1 создан для демонстрации работы
 * стандартного интерфейса Serializable
 */
@Getter
@Setter
public class ToDoV1 implements Serializable {

    // region Поля
    /**
     * Наименование задачи
     * -- GETTER --
     * Получить наименование задачи
     *
     * @return наименование задачи
     */

    private String title;

    /**
     * Статус задачи
     */
    private boolean isDone;
    // endregion


    // region Конструкторы
    public ToDoV1() {
    }

    public ToDoV1(String title) {
        this.title = title;
        isDone = false;
    }
    // endregion


    // region Методы

    /**
     * Получить статус выполнения задачи
     *
     * @return статус выполнения задачи
     */
    private boolean isDone() {
        return isDone;
    }


    /**
     * Изменить статус выполнения задачи
     *
     * @param done новый статус задачи
     */
    public void setDone(boolean done) {
        isDone = done;
    }
    // endregion


}
