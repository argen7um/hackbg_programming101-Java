package week01;

public class T07_KthFac {
	
	public static long factorial(long n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	
	public static long kthFac(long k, long n) {
		if (k == 1) {
			return factorial(n);
		}
		return factorial(kthFac(k - 1, n));
	}

}
