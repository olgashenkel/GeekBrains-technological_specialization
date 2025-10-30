package seminar_01.task_02.product.snack;

import seminar_01.task_02.model.Snack;

/**
 * Шоколадный батончик
 */

public class ChocolateBar implements Snack {
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
        return "Шоколадный батончик";
    }
}
