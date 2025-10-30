package seminar_01.task_02.product.healthyFood;

import seminar_01.task_02.model.HealthyFood;

/**
 * Курица
 */

public class Chicken implements HealthyFood {
    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Курица";
    }
}
