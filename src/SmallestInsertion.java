/*************************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Compilation:  javac SmallestInsertion.java
 *  Execution:    java SmallestInsertion  file.txt
 *  Dependencies: Tour.java Point.java In.java
 *
 *  Run smallest insertion heuristic for traveling salesperson problem
 *  and print resulting tour to standard output.
 *
 *  % java SmallestInsertion tsp100.txt | more
 *
 *
 *************************************************************************/

public class SmallestInsertion {

    public static void main(String[] args) {

        // open input file
        In in = new In(args[0]);

        // get dimensions and ignore since no plotting in this client
        int w = in.readInt();
        int h = in.readInt();

        // read in data and run nearest insertion heuristic
        Tour tour = new Tour();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point p = new Point(x, y);
            tour.insertSmallest(p);
        }

        // print results
        System.out.println("Tour distance = " + tour.distance());
        tour.show();
    }

}
