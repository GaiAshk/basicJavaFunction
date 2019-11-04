import std.*;

public class BouncingBall {
    public static void main(String[] args) {
        // Creates a 2 by 2 box
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        // Sets the ball's radius
        double radius = .05;

        // Sets initial ball location
        double rx = .480, ry = .860;

        // Sets initial ball velocity
        double vx = .025, vy = .023;



        while(true) {
            // If the ball is going to hit a wall, update the velocity
            if (Math.abs(rx + vx) + radius > 1.0) vx = -vx;
            if (Math.abs(ry + vy) + radius > 1.0) vy = -vy;

            // Computes the new ball's location
            rx = rx + vx;
            ry = ry + vy;

            // Clears the picture (by redrawing the background)
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(0.0, 0.0, 1.0);

            // Draws the ball in its new location
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);

            // Displays the new image and pauses for 10 ms
            StdDraw.show(10);
        }
    }
}
