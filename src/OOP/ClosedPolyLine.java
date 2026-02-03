package OOP;

public class ClosedPolyLine extends PolyLine{
    public ClosedPolyLine(Point[] points) {
        super(points);
    }

    @Override
    public double getLenght() {
        double baseLenght = super.getLenght();
        //return baseLenght;
        Point[] pnts = getPoints();
        Point first = pnts[0];
        Point last = pnts[pnts.length - 1];
        Line closing = new Line(last, first);
        double plusLenght = closing.getLenght();
        double res = baseLenght + plusLenght;
        return res;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
