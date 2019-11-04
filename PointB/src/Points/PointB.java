package Points;
import std.*;

/* this class creates a point like object
   white two points
 */
public class PointB {

    private double x;
    private double y;

    public PointB (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance (PointB other) {
        double distance = 0;
        double distX = this.x + other.x;
        double distY = this.y + other.y;
        distance = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
        return distance;
    }

    public void draw() {
        StdDraw.filledCircle(this.x, this.y, 1);
    }

    public void drawLine(PointB other) {
        StdDraw.line(this.x, this.y, other.x, other.y);
    }

    //returns the sum of two points
    public PointB add (PointB other) {
        PointB sum = new PointB(this.x + other.x, this.y + other.y);
        return sum;
    }

    // toString Mathod for the point object
    public String toString() {
        return ("(" + (int)this.x +" , " + (int)this.y + ")");
    }
}
