package ProblemSet2A;

import java.util.Comparator;

public class OctagonComparator implements Comparator<Octagon> {
	@Override
	public int compare(Octagon octagon, Octagon t1) {
		return (int) (octagon.getSide() - t1.getSide());
	}
}
