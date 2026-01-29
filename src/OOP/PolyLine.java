package OOP;

import java.util.Arrays;

public class PolyLine {
    public Point[] points;
    public PolyLine(Point[] points) {
        this.points = points;
    }
    public PolyLine() {
     this.points = new Point[0];
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
        Line[] lines = getLines();
             double sum = lines.length;
               return sum;
    }
   public String toString() {
        String res = "Линия " + Arrays.toString(points);
        return res;

    }

}
