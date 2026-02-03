package OOP;

public class FloatPoint implements NumberOperations{
    private double value;

    public FloatPoint(double value) {
        this.value = value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
}
