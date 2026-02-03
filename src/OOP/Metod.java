package OOP;

public class Metod {
    public static void printMeasurements(Main.Measurable[] items) {
        double total = 0.0;
        for (int i = 0; i < items.length; i++) {
            Main.Measurable m = items[i];
            double len = m.getLenght();
            System.out.println("Ломаная: " + (i+1) + " Длина: " + len);
            total += len;

        }
        System.out.println("Общая длина: " + total);
    }
}
