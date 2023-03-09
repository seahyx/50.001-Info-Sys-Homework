package ProblemSet2B.week1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class DemoClass {
	public static void main(String[] args) {
		// Can't use scanner in Android Studio so deal with this
		Scanner scan = new Scanner(System.in);

		// Get user inputs
		int n = 10;
		do {
			System.out.println("Enter size of random int list to generate: ");
			n = scan.nextInt();
		} while (n <= 0);

		int upperBound = 1000;
		do {
			System.out.println("Enter upper bound of rng: ");
			upperBound = scan.nextInt();
		} while (upperBound <= 1);

		scan.close();

		// Generate list of random integers
		ArrayList<Integer> randList = generateRandomNumberList(n, upperBound);
		// Get sum of random number list
		int sum = 0;
		System.out.println("Size: " + n + "\nUpper Bound: " + upperBound);
		for (Iterator<Integer> randIter = randList.iterator(); randIter.hasNext();) {
			int num = randIter.next();
			System.out.println(num);
			sum += num;
		}
		System.out.println("-----------\nSum: " + sum);
	}

	/**
	 * Generates a random number {@code ArrayList<Integer>} of size {@code n}, bounded by {@code upperBound}.
	 * @param n Size of array.
	 * @param upperBound Upperbound of the random numbers generated.
	 * @return Array of random integers.
	 */
	public static ArrayList<Integer> generateRandomNumberList(int n, int upperBound) {
		Random rand = new Random();
		ArrayList<Integer> generatedList = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			generatedList.add(rand.nextInt(upperBound));
		}
		return generatedList;
	}
}