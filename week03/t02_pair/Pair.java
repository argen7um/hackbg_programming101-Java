package week03.t02_pair;


public class Pair<K, V> {
	
	private K first;
	private V second;
	
	public K getFirst() {
		return first;
	}
	public void setFirst(K first) {
		this.first = first;
	}
	public V getSecond() {
		return second;
	}
	public void setSecond(V second) {
		this.second = second;
	}

	public String toString() {
		return String.format("%s %s", first, second);
	}
	
	public boolean equals(Pair<K, V> p) {
		return first.equals(p.first) && second.equals(p.second);
	}
	
	public static void main(String[] args) {
		
		Pair<Integer, String> p1 = new Pair<Integer, String>();
		Pair<Integer, String> p2 = new Pair<Integer, String>();
		System.out.println(p1.equals(p2));
		
	}
}
