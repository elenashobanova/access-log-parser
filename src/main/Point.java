package main;

public class Point extends Object
{
    int x;
    int y;

    public Point(int x, int y) {
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
        Point obj2 = (Point) obj;
        return this.x == obj2.x && this.y == obj2.y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected Point clone() throws CloneNotSupportedException {
        return new Point(this.x, this.y);
    }
}
