package seminar_01.task_02.product.snack;

import seminar_01.task_02.model.Snack;

/**
 * Чипсы
 */

public class Crisps implements Snack {
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
        return "Чипсы";
    }
}
