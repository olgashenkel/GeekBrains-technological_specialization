package seminar_01.task_02.product.semiFinishedFood;

import seminar_01.task_02.model.SemiFinishedFood;

/**
 * Пельмени
 */

public class DumplingsMeat implements SemiFinishedFood {
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
        return "Пельмени";
    }
}
