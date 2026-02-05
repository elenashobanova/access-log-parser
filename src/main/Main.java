package main;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(2, 2);

        PolyLine line1 = new PolyLine(p1, p2, p3);
        PolyLine line2 = new PolyLine(new Point(0, 0), new Point(1, 1), new Point(2, 2));

        System.out.println("Все точки ломаных совпадают: " + line1.equals(line2));
    }


}
