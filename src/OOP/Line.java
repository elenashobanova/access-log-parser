package OOP;

public class Line {
    private Point start;
    private Point end;
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    public Line (int x1, int y1, int x2, int y2){
       this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public double getLenght(){
        double l = Math.sqrt((end.getX() - start.getX()) * (end.getX() - start.getX()) +
                (end.getY() - start.getY()) * (end.getY() - start.getY()));
        return l;
    }
    public String toString() {
        String res = "Линия от " + start + " до " + end;
        return res;
    }

}
