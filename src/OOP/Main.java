package OOP;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Fraction f = new Fraction(6, 7);
        System.out.println(f);
        System.out.println("doudle: " + f.doubleValue());
        System.out.println("int: " + f.intValue());
        System.out.println("float: " + f.floatValue());
        System.out.println("long: " + f.longValue());

    }
}
