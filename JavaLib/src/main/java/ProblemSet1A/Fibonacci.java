package ProblemSet1A;

import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Get user inputs
		int n = 10;
		do {
			System.out.println("Enter length of fibonacci sequence: ");
			n = scan.nextInt();
		} while (n <= 2);

		int n1, n2 = 0;
		do {
			System.out.println("Enter 1st number: ");
			n1 = scan.nextInt();
		} while (n1 <= -1);

		do {
			System.out.println("Enter 2st number: ");
			n2 = scan.nextInt();
		} while (n2 <= -1);

		System.out.println("Fibonacci sequence is beloow:::");
		System.out.println(generateFibonacci(n, n1, n2));
	}

	public static String generateFibonacci(int n, int n1, int n2) {
		ArrayList<Integer> seq = new ArrayList<>(n);
		seq.add(n1);
		seq.add(n2);

		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(seq.get(0)).append(", ").append(seq.get(1));

		for (int i = 2; i < n; i++){
			seq.add(seq.get(i - 2) + seq.get(i - 1));
			strBuilder.append(", ").append(seq.get(i));
		}

		return strBuilder.toString();
	}
}
