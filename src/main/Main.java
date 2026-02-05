package main;

public class Main {
    public static void main(String[] args) {
        Sauce sauce1 = new Sauce("ЧИЛИ", Sauce.HotLevel.ОЧЕНЬ_ОСТРЫЙ);
        Sauce sauce2 = new Sauce("БАРБЕКЮ", Sauce.HotLevel.ОСТРЫЙ);
        Sauce sauce3 = new Sauce("СЫРНЫЙ", Sauce.HotLevel.НЕ_ОСТРЫЙ);
        System.out.println(sauce1);
        System.out.println(sauce2);
        System.out.println(sauce3);

    }


}
