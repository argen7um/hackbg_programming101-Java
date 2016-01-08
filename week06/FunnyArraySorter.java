package week06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class FunnyArraySorter {
	
	private int pivot;
	
	public FunnyArraySorter(int pivot) {
		this.pivot = pivot;
	}
	
	public void reversedSort(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		
		
	}
	
	public void pivotSubtractionSort(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (o1 - pivot > o2) {
					return 1;
				} else if ((o1 - pivot) == o2) {
					return 0;
				}
				return -1;
			}
		});
	}
	
	public void pivotDivisionSort(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (o1/pivot > o2) {
					return 1;
				} else if (o1/pivot == o2) {
					return 0;
				}
				return -1;
			}
		});
	}
	
	public static void main(String [] args) {
		FunnyArraySorter sorter = new FunnyArraySorter(5);
		List<Integer> arr = Arrays.asList(10, 12, 3, 4, 20);
		// sorter.reversedSort(arr);
		//sorter.pivotSubtractionSort(arr);
		sorter.pivotDivisionSort(arr);
		System.out.println(arr);
	}

}