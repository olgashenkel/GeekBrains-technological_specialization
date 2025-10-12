package task_01;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 10, 15, 20, 3, 5, 7, 9);

        DescriptiveStatistics statistics = new DescriptiveStatistics();
        for (Integer number : numbers) {
            statistics.addValue(number);
        }

        double min = statistics.getMin();
        double max = statistics.getMax();
        double sum = statistics.getSum();
        double average = statistics.getMean();

        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Сумма чисел коллекции: " + sum);
        System.out.println("Среднее арифметическое значение: " + average);

        System.out.println();

        System.out.println("Факториал числа N: " + ArithmeticUtils.factorial(5));
        System.out.println("Наименьшее общее частное двух чисел (100 и 325): " + ArithmeticUtils.lcm(100, 325));
        System.out.println("Наибольший общий делитель двух чисел (15 и 18): " + ArithmeticUtils.gcd(15, 30));
        System.out.println("Проверить, что число 32 - это степень двойки: " + ArithmeticUtils.isPowerOfTwo(32));
    }
}
