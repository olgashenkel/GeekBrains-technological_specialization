package seminar_01.task_02.product.snack;

import seminar_01.task_02.model.Snack;

/**
 * Сыр Балыковый (Балык)
 */

public class BalykCheese implements Snack {
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
        return "Сыр (Балык)";
    }
}
