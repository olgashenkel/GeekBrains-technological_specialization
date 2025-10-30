package seminar_01.task_02.product.healthyFood;

import seminar_01.task_02.model.HealthyFood;

/**
 * Фрукт
 */

public class Fruit implements HealthyFood {
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Фрукт";
    }
}
