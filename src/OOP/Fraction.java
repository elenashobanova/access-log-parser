package OOP;
interface NumberOperations {
    double doubleValue();
}
public class Fraction implements NumberOperations{
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("Здесь на ноль делить нельзя!");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return " Дробь " + numerator + "/" + denominator;
    }
}
