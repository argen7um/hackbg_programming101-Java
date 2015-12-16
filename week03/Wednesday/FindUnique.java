package week03.Wednesday;

import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;
import java.util.Collection;
import java.util.Arrays;

public class FindUnique {

	
	public static <T> T find(Collection<T> collection) {
		T temp; 
		List<T> list = new LinkedList<T>();
		HashSet<T> set = new HashSet<>();
		list.addAll(collection);
		while (list.size() > 0) {
			temp = list.remove(0);
            if (set.contains(temp)) {
				continue;
			}
			if (!list.contains(temp)) {
				return temp;
			}
			set.add(temp);
		}
		return null;		
	}
	
	public static void main(String[] args) {
		Collection<Integer> ints = Arrays.asList(1,2,3,4,5,5,1,2);
		Integer res = FindUnique.find(ints);
		System.out.println(res);
	}

}
