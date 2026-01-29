package OOP;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Point pnt1 = new Point(1,5);
        Point pnt2 = new Point(2,8);
        Point pnt3 = new Point(5,3);
        Point pnt4 = new Point(8,9);
        Point[] pointArr = {pnt1, pnt2, pnt3, pnt4};
        PolyLine polyLine = new PolyLine(pointArr);
        double pllenght = polyLine.getLength();
        Line[] lineArr = polyLine.getLines();
        int lineCount = lineArr.length;
        System.out.println("Ломаная: " + polyLine);
        System.out.println("Длина ломаной: " + pllenght);
        System.out.println("Массив линий: " + Arrays.toString(lineArr));
        System.out.println("Длина массива линий: " + lineCount);
        System.out.println("Длина ломаной = длине массива линий: " + (pllenght == lineCount));
        pnt2.x = 12;
        System.out.println("Изменение координат точки {2;8} на " + pnt2);
        System.out.println("Ломаная после изменения: " + polyLine);
        System.out.println("Массив линий после изменения: " + Arrays.toString(lineArr));
    }
}
