package ma.esoftech.esoftrade.converter;

import ma.esoftech.esoftrade.DTO.UserDTO;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Customer {
	 
	@NotEmpty //make sure name is not empty
	private String name;
 
	@Range(min = 1, max = 150) //age need between 1 and 150
	private int age;

	private UserDTO user;
	private String reference;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
 
	//getter and setter methods
 
}