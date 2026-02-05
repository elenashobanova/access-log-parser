package main;

import java.awt.*;

public class PointsObj extends Object
{
    private int x;
    private int y;

    public PointsObj(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }


    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";

    }

    public void setY(int y) {
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        PointsObj obj2 = (PointsObj) obj;
        return this.x == obj2.x && this.y == obj2.y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected PointsObj clone() throws CloneNotSupportedException {
        return new PointsObj(this.x, this.y);
    }
}
