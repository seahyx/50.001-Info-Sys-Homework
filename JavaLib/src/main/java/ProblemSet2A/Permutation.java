package ProblemSet2A;

import java.util.ArrayList;

public class Permutation {
	private final String in;
	private ArrayList<String> a = new ArrayList<>();

	Permutation(final String str) {
		in = str;
	}

	public void permute() {
		a.clear();
		permute(in, "");
	}

	public void permute(String l, String r) {
		// Base case, when all the letters are transferred over to right string
		if (l.isEmpty()) {
			a.add(r);
			return;
		}

		// Transfer a letter over to the right string.
		// The letter can be inserted in any position in the right string, so iterate through that.
		for (int i = r.length(); i >= 0; i--) {
			permute(l.substring(1), r.substring(0, i) + l.charAt(0) + r.substring(i));
		}
	}

	public ArrayList<String> getA() {
		return a;
	}
}