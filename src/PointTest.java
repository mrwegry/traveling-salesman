
/*************************************************************************
 *    YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Compilation:  javac PointTest.java
 *  Execution:    java PointTest file.txt
 *  Dependencies: StdDraw.java StdIn.java Point.java
 *
 *  Reads in a set of TSP point and plots them. Tests the Point
 *  constructor and the draw() method.
 *
 *  % java PointTest tsp1000.txt
 *
 *************************************************************************/

public class PointTest {

    public static void main(String[] args) {

        // open input file
        In in = new In(args[0]);

        // get dimensions
        int w = in.readInt();
        int h = in.readInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);
        StdDraw.setPenRadius(.005);

        // read in and plot points one at at time
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point p = new Point(x, y);
            p.draw();
        }
    }
}
