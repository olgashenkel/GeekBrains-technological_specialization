package lesson_03.fruit;

public class Apple extends Fruit {
    @Override
    public float getWeight() {
        return 1.0f; // Вес яблока
    }

    @Override
    public String toString() {
        return "Apple";
    }
}