package OOP;

import java.util.Arrays;
import java.util.List;

public class Main{
    public interface Measurable {
        double getLenght();
    }
    public static void main(String[] args){
        Point pnt1 = new Point(1,1);
        Point pnt2 = new Point(4,1);
        Point pnt3 = new Point(4,5);
        Point pnt4 = new Point(1,5);
        PolyLine open = new PolyLine(new Point[] {pnt1, pnt2, pnt3});
        ClosedPolyLine closed = new ClosedPolyLine(new Point[] {pnt1, pnt2, pnt3, pnt4});
        Measurable[] items = new Measurable[] { open, closed };
        Metod.printMeasurements(items);
        System.out.println("Ломаная: "  + open);
        System.out.println("Длина ломаной: " + open.getLenght());
        System.out.println("Замкнутая ломаная: " + closed);
        System.out.println("Длина замкнутой ломаной: " + closed.getLenght());


    }


}
