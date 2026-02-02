package OOP;

import java.util.Arrays;

public class PolyLine {
    private Point[] points;
    public PolyLine(Point[] points) {
        this.points = points;
    }
    public PolyLine() {
     this.points = new Point[0];
    }
    public Point[] getPoints() {
        Point[] res = new Point[points.length];
        for (int i = 0; i < points.length; i++){
            res[i] = points[i];
        }
        return res;
    }
    public Line[] getLines(){
        if (points == null || points.length < 2){
            return new Line[0];
        }
        Line[] lines = new Line[points.length - 1];
        for (int i = 0; i < points.length - 1; i++){
            lines[i] = new Line(points[i], points[i + 1]);
        }
        return lines;
    }
    public double getLength() {
        double sum = 0, len1, len2;
        for (int i = 0; i< points.length - 1; i++){
            len1 = points[i].getX() - points[i+1].getX();
            len2 = points[i].getY() - points[i+1].getY();
            sum += Math.sqrt(len1 * len1 + len2 * len2);
        }
        return sum;
      //  Line[] lines = getLines();
     //        double sum = lines.length;
      //         return sum;
    }
   public String toString() {
        String res = "Линия " + Arrays.toString(points);
        return res;

    }

}
