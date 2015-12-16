package week4.Friday;

public class Rectangle implements GeometryFigures{
	
	private Point UpperLeft;
	private Point LowerRight;
	private Point LowerLeft;
	private Point UpperRight;
	
	public Rectangle(Point p1, Point p2) {
	
		UpperLeft = p1;
		LowerRight = p2;
		
		LowerLeft = new Point(p1.getX(), p2.getY());
		UpperRight = new Point(p2.getX(), p1.getY());
	}
	
	public Rectangle(Rectangle rect) {
		UpperLeft = rect.UpperLeft;
		LowerRight = rect.LowerRight;	
	}
	
	public Point getUpperLeft() {
		return UpperLeft;
	}

	public Point getLowerRight() {
		return LowerRight;
	}

	public Point getLowerLeft() {
		return LowerLeft;
	}

	public Point getUpperRight() {
		return UpperRight;
	}

	public Line getUpperLine(){
		return new Line(UpperLeft, UpperRight);
	}
	
	public Line getLowerLine() {
		return new Line(LowerLeft, LowerRight);
	}
	
	public Line getLeftLine() {
		return new Line(UpperLeft, LowerLeft);
	}
	
	public Line getRightLine() {
		return new Line(UpperRight, LowerRight);
	}
	
	public Integer getHeight() {
		return UpperLeft.getY() - LowerLeft.getY(); 
	}
	
	public Integer getWidth() {
		return UpperRight.getX() - UpperLeft.getX();
	}
	
	public Point getCenter() {
		Integer y = UpperLeft.getY() + LowerLeft.getY();
		Integer x = LowerRight.getX() + LowerLeft.getX();
		return new Point(x/2, y/2);
	}
	
	public Integer getPerimeter() {
		return (getHeight() + getWidth()) * 2;
	}
	
	public Integer getArea() {
		return getHeight() * getWidth();
	}
	
	public boolean equals(Rectangle r2) {
		return UpperLeft.equals(r2.UpperLeft) && LowerRight.equals(LowerRight);
	}

    public int hashCode() {
    	return UpperLeft.hashCode() + LowerLeft.hashCode();
    }
	
	public String toString() {
		//return UpperLeft.toString() + LowerRight.toString() + LowerLeft.toString() + UpperRight.toString();
		return "Rectangle[" + LowerLeft + ", (" + getHeight() + "," + getWidth() + ")]";
	}
 
	public static void main(String [] Args) {
		Rectangle rect = new Rectangle(new Point(1,3), new Point(5,1));
		System.out.println(rect);
		System.out.println(rect.getUpperLine());
		System.out.println(rect.getCenter());
		System.out.println(rect.getPerimeter());
		System.out.println(rect.getArea());
	}
}
