package week04.Friday;


public class Line implements Comparable<Line>{
	
	private Point p1;
	private Point p2;
    public final double len;
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		len = getLength();
	}
	
	public Line(Line L) {
		p1 = L.p1;
		p2 = L.p2;
		len = L.len;
	}
	
	private double getLength() {
		double x = Math.pow(p1.getX() - p2.getX(), 2);
		double y = Math.pow(p1.getY() - p2.getY(), 2);
		return Math.sqrt(x + y);
	}
	
	public int hashCode() {
	    int hash = 17;
	    hash = hash * 23 + p1.hashCode();
	    hash = hash * 23 + p2.hashCode();
	    return hash;
	}
	
	public boolean equals(Line l2) {
		return (p1.equals(l2.p1) && (p2.equals(l2.p2)) || (p1.equals(l2.p2) && (p2.equals(l2.p1))));
	}
	
	public int compareTo(Line l2) {
		if (len > l2.len) {
			return 1;
		} else if (len == l2.len) {
			return 0;
		} else {
			return 1;
		}
	}
	
	public String toString() {
		return "Line[" + p1 + "," + p2 + "]";
	}
	
	public static void main(String [] Args) {
		Line l1 = new Line(new Point(0,3), new Point(0,4)); 
		Line l2 = new Line(new Point(0,6), new Point(0,4)); 
		System.out.println(l1.compareTo(l2));
		System.out.println(l1.len);
	}
	
}
