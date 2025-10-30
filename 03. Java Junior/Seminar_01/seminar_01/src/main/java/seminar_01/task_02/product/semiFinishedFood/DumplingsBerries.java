package seminar_01.task_02.product.semiFinishedFood;

import seminar_01.task_02.model.SemiFinishedFood;

/**
 * Замороженные ягоды
 */

public class DumplingsBerries implements SemiFinishedFood {
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
        return "Замороженные ягоды";
    }
}
