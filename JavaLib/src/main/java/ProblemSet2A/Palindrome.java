package ProblemSet2A;

public class Palindrome {
	public static boolean isPalindrome(char[] S) {
		return isPalindrome(S, 0);
	}

	public static boolean isPalindrome(char[] S, int index) {
		if (index > (S.length / 2) - 1) {
			return true;
		}

		int endIndex = S.length - 1 - index;
		if (S[index] == S[endIndex]) {
			return isPalindrome(S, index + 1);
		}
		return false;
	}
}
