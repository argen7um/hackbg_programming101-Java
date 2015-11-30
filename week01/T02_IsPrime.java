package week01;

public class T02_IsPrime {

	private static boolean[] primes;

	public static void sieve(int n) {
		primes = new boolean[n + 1];
		for (int i = 2; i < primes.length / 2; i++) {
			if (!primes[i]) {
				for (int j = i * i; j < primes.length; j = j + i) {
					primes[j] = true;
				}
			}
		}
	}

	public static boolean isPrime(int n) {
		sieve(n);
		return !primes[n];
	}

	public static void main(String[] args) {
		System.out.println(13 + ": " + isPrime(13));
		System.out.println(16 + ": " + isPrime(16));
		System.out.println(101 + ": " + isPrime(101));
		System.out.println(29 + ": " + isPrime(29));
		for (int i = 0; i < primes.length; i++) {
			if (!primes[i]) {
				System.out.println(i + ": " + !primes[i]);
			}
		}
	}

}
