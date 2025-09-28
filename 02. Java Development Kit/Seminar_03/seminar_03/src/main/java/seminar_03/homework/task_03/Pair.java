package seminar_03.homework.task_03;

public class Pair <X, Y> {
    private X first;
    private Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getFirst() {
        return first;
    }

    public Y getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Первый элемент: " + first + ", второй элемент: " + second + ".";
    }
}
