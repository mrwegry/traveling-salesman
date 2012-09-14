/*************************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Compilation:  javac SmallestInsertionDraw.java
 *  Execution:    java SmallestInsertionDraw file.txt
 *  Dependencies: Tour.java Point.java In.java StdDraw.java
 *
 *  Run smallest insertion heuristic for traveling salesperson problem
 *  and plot results.
 *
 *  % java SmallestInsertionDraw tsp1290.txt
 *
 *************************************************************************/

public class SmallestInsertionDraw {

    public static void main(String[] args) {

        // open input file
        In in = new In(args[0]);

        // get dimensions
        int w = in.readInt();
        int h = in.readInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);

        // turn on animation mode
        StdDraw.show(0);

        // run smallest insertion heuristic
        Tour tour = new Tour();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point p = new Point(x, y);
            tour.insertSmallest(p);

            // uncomment the 4 lines below to animate
            StdDraw.clear();
            tour.draw();
            StdDraw.text(100, 0, "" + tour.distance());
            StdDraw.show(50);
        }

        tour.show();
        tour.draw();
        StdDraw.text(100, 0, "" + tour.distance());
        StdDraw.show(0);
    }

}
