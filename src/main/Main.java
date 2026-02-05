package main;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Line line1 = new Line(p1, p2);
        Line line2 = new Line(new Point(0, 0), new Point(1, 1));
        Line line3 = line1.clone();

        System.out.println("Начало и конец линий расположены в одинаковых точках: " + line1.equals(line2)); // true (точки совпадают по значению)
        System.out.println("Копия оригинальной линии: " + line1.equals(line3)); // true (клонированная линия эквивалентна исходной)

    }


}
