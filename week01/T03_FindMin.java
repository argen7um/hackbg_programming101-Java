package week01;

public class T03_FindMin {

	public static int findMin(int [] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
	
		return min;
	}
	
}
