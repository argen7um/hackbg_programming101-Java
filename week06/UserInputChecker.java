package week06;

public class UserInputChecker {
	
	interface Validator {
		public boolean Validate(String str);
	}

	class PersonNameValidator implements Validator {
		
		public boolean Validate(String str) {
			String regex = "^[a-zA-Z]+$";
			if (str.matches(regex)) { 
			    return true;
			}
			return false;
		}
	}
	
	class BulgarianPhoneNumberValidator implements Validator {
		public boolean Validate(String str) {
			String regex = "^359[1-9]+";
			if (str.matches(regex)) { 
			    return true;
			}
			return false;
		}
	}
		
	class PersonAgeValidator implements Validator {
		public boolean Validate(String str) {
			String regex = "[0-9]+";
			if (str.matches(regex)) { 
				return true;
			}
			return false;
		}
	}
	
	public static void main (String [] args) {
		
		UserInputChecker Validator = new UserInputChecker();
		UserInputChecker.PersonNameValidator nameValidater = Validator.new PersonNameValidator();
		String name = "Angel1";
		System.out.println(nameValidater.Validate(name));
		
	}
	
}
