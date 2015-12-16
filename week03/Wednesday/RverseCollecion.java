package week03.Wednesday;

import java.util.Collection;
import java.util.Stack;
import java.util.ArrayList;

public class RverseCollecion {
	
	public static <T> void  reverse (Collection<T> collection) {
		Stack<T> s = new Stack<>(); 
		for (T temp: collection) {
			s.add(temp);
		}
		collection.clear();
		while (!s.isEmpty()) {
			collection.add(s.pop());
		}
	}
	
	public static void main(String [] args) {
		ArrayList<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		System.out.println(l);
		RverseCollecion.reverse(l);
		System.out.println(l);
	}

}
