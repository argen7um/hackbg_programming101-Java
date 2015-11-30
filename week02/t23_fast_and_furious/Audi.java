package week02.t23_fast_and_furious;

public class Audi extends Car {

	private int mileage;
	
	public Audi() {
		
	}
	
	public Audi(int mileage) {
		this.mileage = mileage;
	}
	
	public void setMileage(int mileage){
		this.mileage = mileage;
	}
	
	public int getMileage(){
		return mileage;
	}
}

