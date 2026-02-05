package main;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        PointsObj p1 = new PointsObj(1, 2);
        PointsObj p2 = new PointsObj(1, 2);
        PointsObj p3 = new PointsObj(3, 4);

        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);

        System.out.println("-------------------------");
        System.out.println("p1.equals(p2) -> " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3) -> " + p1.equals(p3)); // false

        System.out.println("-------------------------");
        PointsObj p1clone = p1.clone(); // без try/catch
        System.out.println("p1clone = " + p1clone);
        System.out.println("p1clone == p1 -> " + (p1clone == p1));         // false
        System.out.println("p1clone.equals(p1) -> " + p1clone.equals(p1)); // true

        System.out.println("-------------------------");
        System.out.println("hashCode p1: " + p1.hashCode());
        System.out.println("hashCode p2: " + p2.hashCode());
        System.out.println("hashCode p1clone: " + p1clone.hashCode());
    }


}
