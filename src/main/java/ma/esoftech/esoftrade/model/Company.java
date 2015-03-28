package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Company {
@Id
@GeneratedValue
@Column(name="COMPANY_ID" ,nullable=false, unique=true)
private int company_id;
@OneToMany
@JoinColumn(name="Person_ID")
private Person person;
@Column(name="TYPE",nullable=false)
private String type;
@Column(name="NAME",nullable=false)
private String name;
@Column(name="AdresseONE", nullable=false)
private String AdresseOne;
@Column(name="AdresseTwo",nullable=false)
private String AdresseTwo;
@Column(name="Fax",nullable=false)
private String fax;
@Column(name="EMAIL",nullable=false)
private String email;
@Column(name="VILLE",nullable=false)
private String ville;
@Column(name="PAYS",nullable=false)
private String pays;

public Company(){
	
}
public int getCompany_id() {
	return company_id;
}
public void setCompany_id(int company_id) {
	this.company_id = company_id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAdresseOne() {
	return AdresseOne;
}
public void setAdresseOne(String adresseOne) {
	AdresseOne = adresseOne;
}
public String getAdresseTwo() {
	return AdresseTwo;
}
public void setAdresseTwo(String adresseTwo) {
	AdresseTwo = adresseTwo;
}
public String getFax() {
	return fax;
}
public void setFax(String fax) {
	this.fax = fax;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public String getPays() {
	return pays;
}
public void setPays(String pays) {
	this.pays = pays;
}

public Person getPerson(){
	return person;
}

public void setPerson(Person pers){
	this.person=pers;
}
}
