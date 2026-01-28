package OOP;

public class Main {
    public static void main(String[] args){
        Point pnt1 = new Point(1,3);
        Point pnt2 = new Point(1,3);
        Point pnt3 = new Point(5,8);
        System.out.println("Точка 1: " + pnt1);
        System.out.println("Точка 2: " + pnt2);
        System.out.println("Точка 3: " + pnt3);
        System.out.println("т.1 = т.2 " + (pnt1 == pnt3));
        System.out.println("т.2 = т.3 " + (pnt2 == pnt3));
        System.out.println("т.3 = т.1 " + (pnt3 == pnt1));

    }

}
