package OOP;

public class Calc {
    public static double sumAll(NumberOperations[] values) {
        double sum = 0.0;
        for (NumberOperations value : values) {
            sum += value.doubleValue();
        }
        return sum;
    }
}
