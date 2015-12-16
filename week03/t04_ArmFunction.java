package week03;

public class t04_ArmFunction {
	
	
	public static <T1 extends Number, T2 extends Number> double sum(T1 n1, T2 n2) {
		
		return n1.doubleValue() + n2.doubleValue(); 
		
	}
	
    public static <T1 extends Number, T2 extends Number> double subs(T1 n1, T2 n2) {
		
		return n1.doubleValue() - n2.doubleValue(); 
		
	}
    
    public static <T1 extends Number, T2 extends Number> double mult(T1 n1, T2 n2) {
		
		return n1.doubleValue() + n2.doubleValue(); 
		
	}
    
    public static <T1 extends Number, T2 extends Number> double div(T1 n1, T2 n2) {
		
		return n1.doubleValue() / n2.doubleValue(); 
		
	}
    
    public static void main() {
    	System.out.println("sum :" + t04_ArmFunction. sum(3, 4));
    }

}
