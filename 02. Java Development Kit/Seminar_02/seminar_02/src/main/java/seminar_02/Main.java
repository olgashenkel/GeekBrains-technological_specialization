package seminar_02;


public class Main {
    public static void main(String[] args) {
        Pair<String, String> stringPair = new Pair<>("Hello,", "World!");
        System.out.println(PairUtils.concatenate(stringPair)); // Вывод: Hello, World!

        Pair<Integer, Integer> intPair = new Pair<>(5, 10);
        System.out.println(PairUtils.concatenate(intPair)); // Вывод: (5, 10)
    }
}