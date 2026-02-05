package main;

public class Sauce {
    public enum HotLevel {
        ОЧЕНЬ_ОСТРЫЙ,
        ОСТРЫЙ,
        НЕ_ОСТРЫЙ
    }
    private final String name;
    private final HotLevel hotLevel;
    public Sauce(String name, HotLevel hotLevel) {
        this.name = name;
        this.hotLevel = hotLevel;
    }
    @Override
    public String toString() {
        return "Соус " + name + ": " + hotLevel;
    }

}
