package seminar_01.task_02.product.semiFinishedFood;

import seminar_01.task_02.model.SemiFinishedFood;

/**
 * Чебурек
 */

public class Cheburek implements SemiFinishedFood {
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
        return "Чебурек";
    }
}
