package ProblemSet1A;

import java.util.Arrays;

public class Pset1 {
	public static boolean isAllCharacterUnique(String sIn) {
		int[] charCount = new int[128];
		for (int i = 0; i < sIn.length(); i++) {
			char c = sIn.charAt(i);
			if (charCount[c] == 1) {
				return false;
			}
			charCount[c]++;
		}
		return true;
	}
	public static boolean isPermutation(String sIn1, String sIn2) {
		int[] charCount1 = new int[128], charCount2 = new int[128];

		if (sIn1.length() != sIn2.length()) return false;

		for (int i = 0; i < sIn1.length(); i++) {
			char c1 = sIn1.charAt(i), c2 = sIn2.charAt(i);
			charCount1[c1]++;
			charCount2[c2]++;
		}

		return Arrays.equals(charCount1, charCount2);
	}
}
