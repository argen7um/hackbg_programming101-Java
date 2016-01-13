package week06;

import java.io.Serializable;

import org.omg.PortableInterceptor.ORBInitInfoPackage.InvalidName;

public class UserInputChecker implements Serializable{
	
	interface Validator {
		public void Validate(String str);
	}

	class PersonNameValidator implements Validator {
		
		public void Validate(String str) throws IllegalArgumentException {
			String regex = "^[a-zA-Z]+$";
			if (!str.matches(regex)) { 
				throw new IllegalArgumentException("Not Valid Argument");
			}
		}
	}
	
	class BulgarianPhoneNumberValidator implements Validator {
		public void Validate(String str) throws IllegalArgumentException{
			String regex = "^359[1-9]+";
			if (!str.matches(regex)) { 
			    throw new IllegalArgumentException();
			}
		}
	}
		
	class PersonAgeValidator implements Validator {
		public void Validate(String str) {
			String regex = "[0-9]+";
			if (!str.matches(regex)) { 
				throw new IllegalArgumentException();
			}
		}
	}
	
	public static void main (String [] args) {
		
		UserInputChecker Validator = new UserInputChecker();
		UserInputChecker.PersonNameValidator nameValidater = Validator.new PersonNameValidator();
		String name = "Angel1";
		try {
			nameValidater.Validate(name);
			System.out.println("Valid");
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
}
