package week03.Wednesday;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UnionSet2 {
	
	public static <T> Set<T> union(Collection<T> ... collections) {
		Set<T> res = new HashSet<>(collections[0]); 
		for (Collection<T> collection: collections) {
			res.retainAll(collection);
		}
		return res;
	}

	
	public static void main(String[] args) {
		
		Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(4,5,6));
		Set<Integer> set3 = new HashSet<>(Arrays.asList(5,6,7,8));
		
		Set<Integer> res = UnionSet2.union(set1,set2,set3);
		System.out.println(res);
	}
	
}
