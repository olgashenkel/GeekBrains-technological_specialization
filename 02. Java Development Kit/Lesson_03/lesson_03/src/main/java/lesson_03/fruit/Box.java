package lesson_03.fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Box<T extends Fruit> {
    private final List<T> fruits; // Список фруктов данного типа
    private String fruitType; // Тип фруктов в этой коробке (для проверки при добавлении и пересыпании)

    public Box() {
        this.fruits = new ArrayList<>();
        this.fruitType = null; // Тип определяется при первом добавлении фрукта
    }

    /**
     * Добавляет фрукт в коробку, если тип фрукта совместим.
     */
    public void addFruit(T fruit) {
        if (fruitType == null) { // Если коробка пустая, устанавливаем тип
            fruitType = fruit.getClass().getSimpleName();
        } else if (!fruit.getClass().getSimpleName().equals(fruitType)) {
            System.out.println("Ошибка: Нельзя добавить " + fruit.getClass().getSimpleName() + " в коробку с " + fruitType);
            return;
        }
        fruits.add(fruit);
    }

    /**
     * Возвращает общее количество фруктов в коробке.
     */
    public int getFruitCount() {
        return fruits.size();
    }

    /**
     * Возвращает общий вес коробки.
     */
    public float getWeight() {
        float totalWeight = 0.0f;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    /**
     * Сравнивает вес текущей коробки с весом другой коробки.
     */
    public boolean compare(Box<?> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    /**
     * Пересыпает фрукты из текущей коробки в другую, соблюдая правила совместимости типов.
     */
    public void transferFruits(Box<T> targetBox) {
        if (this.fruitType == null) {
            System.out.println("Нечего пересыпать: Текущая коробка пуста.");
            return;
        }

        if (!Objects.equals(this.fruitType, targetBox.fruitType) && targetBox.fruitType != null) {
            System.out.println("Ошибка: Нельзя пересыпать " + this.fruitType + " в коробку с " + targetBox.fruitType);
            return;
        }

        // Если целевая коробка пуста, устанавливаем тип фруктов в соответствии с текущей коробкой
        if (targetBox.fruitType == null && !this.fruits.isEmpty()) {
            targetBox.fruitType = this.fruitType;
        } else if (targetBox.fruitType != null && !Objects.equals(this.fruitType, targetBox.fruitType)) {
            System.out.println("Ошибка: Нельзя пересыпать " + this.fruitType + " в коробку с " + targetBox.fruitType);
            return;
        }

        targetBox.fruits.addAll(this.fruits);
        this.fruits.clear();
        // После пересыпания, если текущая коробка пуста, сбрасываем её тип
        if (this.fruits.isEmpty()) {
            this.fruitType = null;
        }
    }


}