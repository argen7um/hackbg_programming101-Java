package week01;

public class T05_GetAverage {

	
	public static int getAverage(int [] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum/arr.length;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
