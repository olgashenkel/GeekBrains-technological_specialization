package seminar_03.homework.task_01;

public class Calculator {
    public static <T extends Number> double sum(T firstNum, T secondNum) {
        return firstNum.doubleValue() + secondNum.doubleValue();
    }

    public static <T extends Number> double subtract(T firstNum, T secondNum) {
        return firstNum.doubleValue() - secondNum.doubleValue();
    }

    public static <T extends Number> double multiply(T firstNum, T secondNum) {
        return firstNum.doubleValue() * secondNum.doubleValue();
    }

    public static <T extends Number> double divide(T firstNum, T secondNum) {
        if (secondNum.doubleValue() == 0) {
            throw new ArithmeticException("Нельзя делить на ноль!");
        }
        return firstNum.doubleValue() / secondNum.doubleValue();
    }
}
