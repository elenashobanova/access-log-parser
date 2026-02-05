package main;

public class Line implements Cloneable {
    Point start;
    Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Line other = (Line) obj;
        return (start.equals(other.start)) && (end.equals(other.end));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line clonedLine = (Line) super.clone();
        clonedLine.start = this.start.clone();
        clonedLine.end = this.end.clone();
        return clonedLine;
    }
}
