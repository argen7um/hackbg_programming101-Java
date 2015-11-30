package week01;

public class T01_IsOdd {
	
	
	public static boolean isOdd (int n) {
		
		if (n % 2 == 0) {
			return false;
		} else
			return true;
		
	}

	public static void main(String[] args) {
		
		System.out.println(2 + ": " + isOdd(2));
		System.out.println(3 + ": " + isOdd(3));

	}

}
