package week01;

public class T04_FindKthMInElement {
	
	public static int[] sort(int [] arr) {
		int temp;
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	
	public static int findKthMinElement(int k, int [] arr) {
		arr = sort(arr);
		return arr[k - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {23,15,8,10,2,5,3};
		a = sort(a);
		for (int i = 0; i < a.length; i++) {
			
		
		System.out.println( a[i] );
		}

		System.out.println(findKthMinElement(3, a));
	}

}
