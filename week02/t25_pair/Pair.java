package week02.t25_pair;

public class Pair {

	private Object a; 
	private Object b;
	
	public Pair(Object a, Object b) {
		this.a = a;
		this.b = b; 
	}
	
	public String toString() {
		return String.format("%s %s", a, b);
	}
	
	public void setFirst(Object a) {
		this.a = a;
	}
	
	public void setSecond(Object b) {
		this.b = b;
	}
	
	public Object getFirst() {
		return a;
	}
	
	public Object getSecond() {
		return b;
	}
	
	public boolean equals(Pair p) {
		return a.equals(p.a) && b.equals(p.b);
	}
	
	
}
