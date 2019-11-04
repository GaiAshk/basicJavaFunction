import std.StdDraw;

/** Represents two dimensional points. */
public class Point {

    private double x;
    private double y;

    /** Constructs a point */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** Returns the distance between this point and the other one. */
    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = y - other.y;       // will work also
        return Math.sqrt(dx * dx + dy * dy);
    }

    /** Draws the current point. */
    public void draw() {
        StdDraw.filledCircle(x, y, 0.01);
    }

    /** Draws a line between this point and the other one. */
    public void drawLineTo(Point other) {
        StdDraw.line(x, y, other.x, other.y);
    }

    /** Returns the addition of this point and the one one, as a Point object. */
    public Point add1(Point other) {
        double newx = x + other.x;
        double newy = y + other.y;
        return new Point(newx, newy);
    }

    /** Returns the addition of this point and the one one, as a Point object. */
    public Point add(Point other) {
        return new Point((x + other.x),(y + other.y));
    }

    /** Returns a textual representation of this point. */
    public String toString() {
        return ("(" + x + "," + y + ")");
    }
}
