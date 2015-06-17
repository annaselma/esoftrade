package ma.esoftech.esoftrade.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Index;

//import com.mchange.v2.c3p0.impl.NewProxyResultSet;

@MappedSuperclass
public  abstract class Person extends MetaObject implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="ELMO_REF",nullable= false,unique=true,length= 255)
	@Index(name="ELMO_REF_INDEX")
	private String ref;
	@Column(name="ELMO_NAME", length= 255)
	private String name;
	@Column(name="ELMO_ADRESSE",length=255)
	private String adresse;
	@Column(name="ELMO_ZIP_CODE",length=255)
	private String zipCode;
	@Column(name="ELMO_COUNTRY",length=255)
	private String country;
	@Column(name="ELMO_CITY",length=255)
	private String city;
	@Column(name="ELMO_TEL",length=255)
	private String telephone;
	@Column(name="ELMO_TELPRO",length=255)
	private String telephonePro;
	@Column(name="ELMO_BIRDAY",length=255)
	private Date birdDay;
	@Column(name="ELMO_FAX",length=255)
	private String fax;
	@Column(name="ELMO_CIVILITY")
	@Enumerated(EnumType.STRING)
	private Civility civility;
	

	@Column(name="ELMO_EMAIL")
	private String email;
	
	
	public Person(){
		
			super();
		
	}
	public Date getBirdDay() {
		return birdDay;
	}
	public void setBirdDay(Date birdDay) {
		this.birdDay = birdDay;
	}
	public String  getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTelephonePro() {
		return telephonePro;
	}
	public void setTelephonePro(String telephone_pro) {
		this.telephonePro = telephone_pro;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Civility getCivility() {
		return civility;
	}

	public void setCivility(Civility civility) {
		this.civility = civility;
	}

	public enum Civility{
		Mr,Ms,Mrs,Docteur,Maitre
	}
	
	
}
