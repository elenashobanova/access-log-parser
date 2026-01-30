package OOP;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator < 0)
            throw new IllegalArgumentException("Отрицательное значение недопустимо!");
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction sum(Fraction second){
        int sumNum = this.numerator * second.denominator + this.denominator * second.numerator;
        int sumDen = this.denominator * second.denominator;
        return new Fraction(sumNum, sumDen);
    }
    public Fraction minus(Fraction second){
        int sumNum = this.numerator * second.denominator - this.denominator * second.numerator;
        int sumDen = this.denominator * second.denominator;
        return new Fraction(sumNum, sumDen);
    }
    public Fraction sum(int x){
        return sum(new Fraction(x, 1));
    }
    public Fraction minus(int x){
        return minus(new Fraction(x, 1));
    }

    @Override
    public String toString() {
        return " Дробь " + numerator + "/" + denominator;
    }
}
