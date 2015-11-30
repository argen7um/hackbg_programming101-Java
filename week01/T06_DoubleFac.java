package week01;

public class T06_DoubleFac {
	
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
	
	public static long doubleFac(long n) {
		return kthFac(2, n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(doubleFac(2));
		
	}

}
