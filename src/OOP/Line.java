package OOP;

public class Line {
    Point start;
    Point end;
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    public Line (int x1, int y1, int x2, int y2){
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    public double getLenght(){
        double l = Math.sqrt((end.x - start.x) * (end.x - start.x) +
                (end.y - start.y) * (end.y - start.y));
        return l;
    }
    public String toString() {
        String res = "Линия от " + start + " до " + end;
        return res;
    }

}
