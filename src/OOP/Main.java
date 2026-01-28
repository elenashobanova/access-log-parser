package OOP;

public class Main {
    public static void main(String[] args){
        Point pnt1 = new Point(1,3);
        Point pnt2 = new Point(5,8);
        Point pnt3 = new Point(10,11);
        Point pnt4 = new Point(15,19);
        Line line1 = new Line(pnt1, pnt2);
        Line line2 = new Line(pnt3, pnt4);
        Line line3 = new Line(pnt2, pnt3);
        System.out.println("Линия 3: " + line3);
        line3.start.x = 7;
        line3.start.y = 10;
        line3.end.x = 12;
        line3.end.y = 13;
        System.out.println("Линия 3 после изменения: " + line3);
        double sumLenght = line1.getLenght() +
                                line2.getLenght() +
                                    line3.getLenght();
        System.out.println("Суммарная длина: " + sumLenght);
    }
}
