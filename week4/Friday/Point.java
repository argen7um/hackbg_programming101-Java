package week4.Friday;

public class Point {

	private static final Integer x_initial = 0;
	private static final Integer y_initial = 0;
	final private Integer x;
	final private Integer y;

	public Point(Integer x, Integer y) {
		this.y = y;
		this.x = x;
	}
	
	
	public Point(Point p) {
		x = p.x;
		y = p.y;
	}

	public Point() {
		x = x_initial;
		y = y_initial;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	public String toString() {
		return "Point(" + x + "," + y + ")";
	}

	public boolean equals(Point p2) {
		return x.equals(p2.x) && y.equals(p2.y);
	}

	public int hashCode() {
		int hash = 17;
		hash = hash * 23 + x.hashCode();
		hash = hash * 23 + y.hashCode();
		return hash;
	}
	
	public static void main(String [] Args) {
		Point p = new Point(2,5);
		System.out.println(p);
	}
	
	public static Line Add(Point p1, Point p2) {
		return new Line(p1, p2);
	}
}
