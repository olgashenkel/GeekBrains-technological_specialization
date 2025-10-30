package seminar_01.task_02.product.healthyFood;

import seminar_01.task_02.model.HealthyFood;

/**
 * Оливковое масло
 */

public class OliveOil implements HealthyFood {
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return true;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Оливковое масло";
    }
}
