package week3.Wednesday;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class OnOffCollection<E> extends ArrayList<E>{
	

	public boolean add(E e) {
		if (contains(e)) {
			remove(e);
			return false;
		} 
		if (e == null ) {
			return false;
		}
		super.add(e);
		return true;
	}

	public static void main(String[] args) {
		OnOffCollection<Integer> a = new OnOffCollection<Integer>();
		a.add(1);
		a.add(2);
		System.out.println(a);
		a.add(1);
		System.out.println(a);
	}

}
