package OOP;

import java.util.Arrays;

import static OOP.Calc.sumAll;

public class Main {
    public static void main(String[] args) {
        NumberOperations[] nums1 = {
                new Fraction(2, 1),
                new Fraction(3, 5),
                new FloatPoint(2.3)  // 2.3
        };
        double result1 = sumAll(nums1);
        System.out.println("2 + 3/5 + 2.3 = " + result1);


        NumberOperations[] nums2 = {
                new FloatPoint(3.6),
                new Fraction(49, 12),
                new Fraction(3, 1),
                new Fraction(3, 2)
        };
        double result2 = sumAll(nums2);
        System.out.println("3.6 + 49/12 + 3 + 3/2 = " + result2);


        NumberOperations[] nums3 = {
                new Fraction(1, 3),
                new Fraction(1, 1)
        };
        double result3 = sumAll(nums3);
        System.out.println("1/3 + 1 = " + result3);
    }
}
