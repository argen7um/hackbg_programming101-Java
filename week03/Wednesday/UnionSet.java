package week03.Wednesday;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class UnionSet {

	
	public static <T> Set<T> get(Set<T>...sets) {
		
		Set<T> result = new HashSet<>();
		Set<T> max_set = findBiggestSet(sets);
		for (T temp: max_set) {
			if (foundInAllSets(temp, sets)) {
				result.add(temp);
			}
		}
		return result;			
		}
		
	private static <T> boolean foundInAllSets(T element, Set<T> [] sets) {
		for (int i = 0; i < sets.length; i++) {
			if (!sets[i].contains(element)) {
				return false;
			}
		}
		return true;
	}

	public static <T> Set<T> findBiggestSet(Set<T> [] sets) {
	Set<T> max_set = sets[0];
	for (int i = 0; i < sets.length; i++) {
		if (sets[i].size() > max_set.size()) {
			max_set = sets[i]; 
		}
	}
	return max_set;
	}
	
	
	public static void main(String[] args) {
		
		Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(4,5,6));
		Set<Integer> set3 = new HashSet<>(Arrays.asList(5,6,7,8));
		
		Set<Integer> res = UnionSet.get(set1,set2,set3);
		System.out.println(res);
	}

}
