package ProblemSet2A;

import java.util.ArrayList;

public class OctagonComparatorTest {
	public static void main(String[] args) {
		ArrayList<Octagon> l = new ArrayList<>();
		l.add(new Octagon(2));
		l.add(new Octagon(3));
		l.add(new Octagon(1));
		l.sort(new OctagonComparator());
		for (Octagon o: l) {
			System.out.println(o.getSide());
		}
	}
}
