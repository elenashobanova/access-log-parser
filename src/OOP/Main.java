package OOP;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 5);
        Fraction f3 = new Fraction(7, 8);
        Fraction res = f1.sum(f2).sum(f3).minus(5);
        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);
        System.out.println("f3: " + f3);
        System.out.println(" f1.sum(f2).sum(f3).minus(5) = " + res);
    }
}
