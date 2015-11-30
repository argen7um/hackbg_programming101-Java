package week02.t23_fast_and_furious;

public class Main {

	public static void main(String[] args) {
		Car vw = new Volkswagen();
		System.out.println(vw.isEcoFriendly(false));
		Car audi = new Audi();
		System.out.println(audi.isEcoFriendly(false));
		Car bmw = new BMW();
		System.out.println(bmw.isEcoFriendly(false));
		Car skoda = new Skoda();
		System.out.println(skoda.isEcoFriendly(false));
		Car honda = new Honda();
		System.out.println(honda.isEcoFriendly(false));
		Audi a8 = new Audi(250);
		System.out.println(a8.getMileage());
	}

}
