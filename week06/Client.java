package week06;

import java.io.Serializable;

import week06.UserInputChecker.PersonNameValidator;

public class Client implements Serializable {
	
	private String firstName;
	private String lastName;
	private int age;
	private UserInputChecker Validator = new UserInputChecker();
	
	public String toString () {
		return String.format("Client(%s %s - %s)", firstName, lastName, age);
	}
	
	public String getFirstName(){  
		return firstName;
	}

	public void setFirstName(String firstName) throws IllegalArgumentException {
		UserInputChecker.PersonNameValidator nameValidater = Validator.new PersonNameValidator();
		nameValidater.Validate(firstName);
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws IllegalArgumentException {
		UserInputChecker.PersonNameValidator nameValidater = Validator.new PersonNameValidator();
		nameValidater.Validate(lastName);
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws IllegalArgumentException{
		if (age > 200) {
			throw new IllegalArgumentException("Not Valid age");
		}
		this.age = age;
	}
	
	public Client(String firstName, String lastName, int age) {
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
	}

}
