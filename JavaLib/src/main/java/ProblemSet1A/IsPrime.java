package ProblemSet1A;

public class IsPrime {
	public static void main(String[] args) {
		int n = 13;
		for (int i = 0; i < n; i++) {
			System.out.println(i + (isPrime(i) == 1 ? " <-- is prime" : ""));
		}
	}

	public static int isPrime(int num) {
		if (num < 2) return 0;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return 0;
		}
		return 1;
	}
}
