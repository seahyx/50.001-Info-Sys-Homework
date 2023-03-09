package ProblemSet2A;

public class Octagon implements Comparable<Octagon> {
	private double side;

	public Octagon(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	@Override
	public int compareTo(Octagon octagon) {
		return (int) (getSide() - octagon.getSide());
	}
}
