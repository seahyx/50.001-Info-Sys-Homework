package ProblemSet2A;

public class PalindromeTest {
	public static void main(String[] args) {
		String[] testCases = {
				"abba",
				"abdcba",
				"ZZaZZ",
				"123421"
		};

		for (String s: testCases) {
			System.out.println(s + " - " + Palindrome.isPalindrome(s.toCharArray()));
		}
	}
}
