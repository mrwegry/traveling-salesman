/*************************************************************************
 *  Compilation:  javac Tour.java
 *  Dependencies:  Point.java StdDraw.java
 *
 *  Note that you are not allowed to add any field variables or class
 *  variables for this assignment. Otherwise, you will lose major points.
 *
 *************************************************************************/

public class Tour {
	private Node first;   // a reference to the "first" node on the tour

	// a node in the circular linked list
	private static class Node {
		private Point p;
		private Node next;
	}


	// print the tour to standard output
	public void show() {
		if (first == null) return;
		Node x = first;
		do {
			System.out.println(x.p);
			x = x.next;
		} while (x != first);
	}

	// plot the tour using standard draw
	public void draw() {
		// implement this using the method "drawTo" provided in Point.java
		if (first == null) return;
		Node x = first;
		do {
			if(x.next != null){
				x.p.drawTo(x.next.p);
				x = x.next;
			}
		} while (x != first);
	}

	// return the length of the tour
	public double distance() {
		if (first == null) return 0.0;
		Node x = first;
		double total = 0.0;
		do {
				total += x.p.distanceTo(x.next.p);
				x = x.next;
		} while (x != first);		
		return total;
	}


	// insert after the point that was most recently added
	public void insertInorder(Point p) {
		Node current = new Node();
		Node newFirst = new Node();
		current.p = p;
		
		if (first == null){
			first = current;
			first.next = first;
			return;
		}
		newFirst = first;
		
		while (newFirst.next != first){
			newFirst = newFirst.next;
		}
		
		newFirst.next = current;
		current.next = first;
		newFirst = current;
	}
	// implement the rest



	// insert Point p into the tour
	public void insertSmallest(Point p) {
		Node current  = new Node();                   // new node to insert
		Node bestNode = null;                        // insert after this node
		double bestDelta = Double.POSITIVE_INFINITY;  // it's this distance away
		current.p = p;

		insertInorder(p);
		// implement the rest
	}



	// nearest insertion heuristic
	public void insertNearest(Point p) {
		Node current  = new Node();                  // new node to insert
		Node newFirst  = new Node();
		Node bestNode = null;                        // insert after this node
		double bestDist = Double.POSITIVE_INFINITY;  // it is this distance away

		current.p = p;
		
		if (first == null){
			first = current;
			first.next = first;
			StdOut.println("if");
			return;
		}
		
		newFirst = first;
		
		while (newFirst.next != first){
			if (current.p.distanceTo(newFirst.p) < bestDist){
				bestNode = newFirst;
				bestDist = current.p.distanceTo(newFirst.p);
				StdOut.println(bestDist);
				StdOut.println("second if");
			}
			newFirst = newFirst.next;
			System.out.println("loop");
		}
		StdOut.println("out");
		if (bestNode != null){
		current.next = bestNode.next;
		bestNode.next = current;
		}
		StdOut.println(bestDist);
		StdOut.println(current.p.distanceTo(newFirst.p));
		// implement the rest
	}
}
