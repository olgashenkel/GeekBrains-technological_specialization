package lesson_01;

/*
Интерфейс без методов - маркерный
Интерфейс с одним методом - функциональный
Интерфейс с несколькими методами - обычный
 */

@FunctionalInterface    //Аннотация @FunctionalInterface - Делает интерфейс Функциональным
public interface PlainInterface {
//    String action(int x, int y);
    int action(int x, int y);
}
