package ma.esoftech.esoftrade.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.FileAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.PosteAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.RoleAssociated;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class UserDTO {
private long id;
@NotEmpty
@Size(min=4, max=20)
private String login;
private boolean active;
private EditorDTO creator;
private Date createDate;
private EditorDTO modifier;
private Date lastEdit;
private String ref;
@NotEmpty(message="champs obligatoire")
@Size(min=2, max=20)
private String name;
@DateTimeFormat(pattern="dd/MM/yyyy")
@Past
@NotNull(message="nuulll")
private Date birdDay;

private String password;
@Size(max=50,min=5)
private String lastName;
@Size(max=50)
private String fonction;
@Size(max=50)
private String adresse1;
@Size(max=50)
private String adresse2;
@Size(max=10)
private String zipCode;
private String country;
private String city;
@Size(max=20)
private String telephone;
@Size(max=20)
private String telephonePro;
@Size(max=20)
private String fax;
private FileAssociatedDTO picture;
private String civilite;
@NotEmpty(message="Veillez saisir une adresse électronique valide")
@Email
private String email;
private PosteAssociatedDTO poste= new PosteAssociatedDTO();
private List<RoleAssociated>roles= new ArrayList<RoleAssociated>();
private List<String>permissions= new ArrayList<String>();
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public EditorDTO getCreator() {
	return creator;
}
public void setCreator(EditorDTO creator) {
	this.creator = creator;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
public String getRef() {
	return ref;
}
public void setRef(String ref) {
	this.ref = ref;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getFonction() {
	return fonction;
}
public void setFonction(String fonction) {
	this.fonction = fonction;
}
public String getAdresse1() {
	return adresse1;
}
public void setAdresse1(String adresse1) {
	this.adresse1 = adresse1;
}
public String getAdresse2() {
	return adresse2;
}
public void setAdresse2(String adresse2) {
	this.adresse2 = adresse2;
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
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getTelephonePro() {
	return telephonePro;
}
public void setTelephonePro(String telephonePro) {
	this.telephonePro = telephonePro;
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
public List<RoleAssociated> getRoles() {
	return roles;
}
public void setRoles(List<RoleAssociated> roles) {
	this.roles = roles;
}
public List<String> getPermissions() {
	return permissions;
}
public void setPermissions(List<String> permissions) {
	this.permissions = permissions;
}


public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}

public FileAssociatedDTO getPicture() {
	return picture;
}
public void setPicture(FileAssociatedDTO picture) {
	this.picture = picture;
}

public String getCivilite() {
	return civilite;
}
public void setCivilite(String civilite) {
	this.civilite = civilite;
}

public Date getBirdDay() {
	return birdDay;
}
public void setBirdDay(Date birdDay) {
	this.birdDay = birdDay;
}
public EditorDTO getModifier() {
	return modifier;
}
public void setModifier(EditorDTO modifier) {
	this.modifier = modifier;
}
public Date getLastEdit() {
	return lastEdit;
}
public void setLastEdit(Date lastEdit) {
	this.lastEdit = lastEdit;
}
public UserDTO(){
	setBirdDay(new Date());
}
public PosteAssociatedDTO getPoste() {
	return poste;
}
public void setPoste(PosteAssociatedDTO poste) {
	this.poste = poste;
}

}
