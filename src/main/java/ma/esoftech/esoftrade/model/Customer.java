package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")

public class Customer {

	@Id
	@GeneratedValue
	@Column(name="Custumer_ID", nullable=false, unique= true )
      private int custumer_Id;
	@Column(name="NAME",nullable= false, length= 255)
	private String name;
	@Column(name="FIRST_NAME",nullable=false,length=255)	
	private String firstName;
	@Column(name="CIVILITY",nullable=false,length=255)
	private String civility;
	@Column(name="STATUS")
	private boolean status;
	
	@Column(name="TYPE")
	private int type;
	@Column(name="EMAIL")
	private String emails;
	
	public int getCustumer_Id() {
		return custumer_Id;
	}

	public void setCustumer_Id(int custumer_Id) {
		this.custumer_Id = custumer_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCivility() {
		return civility;
	}

	public void setCivility(String civility) {
		this.civility = civility;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="TEL")
	private String tel;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="COUNTRY")
	private String country;

	public Customer() {
	}
}
