package seminar_02;

public class PairUtils {
    public static <T> String concatenate(Pair<?, T> pair) {
        if (pair.getFirst() instanceof String && pair.getSecond() instanceof String) {
            return pair.getFirst() + " " + pair.getSecond();
        }
        return pair.toString(); // Возвращает строковое представление пары, если типы не String
    }
}
