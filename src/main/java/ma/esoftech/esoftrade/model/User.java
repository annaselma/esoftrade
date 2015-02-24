package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")

public class User {
	@Id
	@GeneratedValue
	@Column(name="USER_ID", nullable=false)
private int id;
	@Column(name="FirstNAME",nullable= false, length= 255)
private String firstName;
	@Column(name="lastNAME",nullable= false, length= 255)
private String lastName;
public User(){
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

}
