package week3.Wednesday;

import java.util.Collection;
import java.util.ArrayList;

public class RotateElements {
	
	//private static ArrayList<T> list  = new ArrayList<T>();
	
	public static <T> void rotate(Collection<T> collection, int rotateStep ) {
		ArrayList<T> list  = new ArrayList<T>();
		for (T temp: collection) {
			list.add(temp);
		}
		T temp;
		
		if (rotateStep > 0) {
			for (int i = 0; i < rotateStep; i++) {
				temp = list.remove(list.size() - 1);
				list.add(0,temp);
			}
		} else {
			for (int i = 0; i > rotateStep; i--) {
				temp = list.remove(0);
				list.add(temp);
			}
			
		}
		collection.clear();
		collection.addAll(list);
	}
		
	public static void main(String [] Args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		
		//RotateElements<Integer> r =  new RotateElements<Integer>();
		RotateElements.rotate(a, -2);
		System.out.println(a);
	}
}
