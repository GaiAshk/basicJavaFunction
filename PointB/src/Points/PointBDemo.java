package Points;
import std.*;

import java.awt.*;

public class PointBDemo {

    public static void main (String[] args) {
        PointB A = new PointB (1, 1);
        PointB B = new PointB (10, 30);

        StdDraw.setCanvasSize(1400, 1400);
        StdDraw.setXscale(0, 1400);
        StdDraw.setYscale(0, 1400);

        //test1(A, B);
        test2();
    }

    public static void test1 (PointB A, PointB B) {
        StdOut.println(A);
        StdOut.println(B.toString());

        PointB C = (A.add(B));
        StdOut.println(C);
        A.draw();
        B.draw();
        C.draw();

        PointB D = C.add(C);
        D.draw();
        PointB E = D.add(D);
        E.draw();
        E.drawLine(A);
        StdDraw.text(1, 1, A.toString());
        StdDraw.text(31, 11, C.toString());
        StdDraw.text(100, 100, E.toString());

    }

    public static void test2() {
        int n = 0;
        while(n < 1000) {
            double x = Math.random() * 1400;
            double y = Math.random() * 1400;
            StdDraw.setPenColor(Color.MAGENTA);
            StdDraw.setFont(new Font("Arial", Font.ITALIC, 12));
            PointB C = new PointB (x, y );
            C.draw();
            StdDraw.text(x + 10, y + 10, C.toString()  );
            n++;
        }
    }
}
