package ma.esoftech.esoftrade.DTO;

import java.util.Date;

import javax.validation.constraints.NotNull;

import ma.esoftech.esoftrade.DTO.associated.CompanyAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.model.Company.ThirdStatus;
import ma.esoftech.esoftrade.model.Person.Civility;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ContactDTO {
	private long id;
	private EditorDTO creator;
	private Date createDate;
	private EditorDTO modifier;
	private Date lastEdit;
	@NotEmpty
	private String name;
	@NotEmpty
	private String lastName;
	private String adresse;
	private String zipCode;
	private String country;
	private String city;
	private String telephone;
	private String telephonePro;
	private String webSite;
	private Date birdDay;
	private String fax;
	@Email
	private String email;
	private ThirdStatus status;
	@NotNull(message="Tiers ne doit pas etre vide")
	private CompanyAssociatedDTO company;
	private String job;
	private Civility civility;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTelephonePro() {
		return telephonePro;
	}
	public void setTelephonePro(String telephonePro) {
		this.telephonePro = telephonePro;
	}
	public Date getBirdDay() {
		return birdDay;
	}
	public void setBirdDay(Date birdDay) {
		this.birdDay = birdDay;
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
	public ThirdStatus getStatus() {
		return status;
	}
	public void setStatus(ThirdStatus status) {
		this.status = status;
	}
	public CompanyAssociatedDTO getCompany() {
		return company;
	}
	public void setCompany(CompanyAssociatedDTO company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Civility getCivility() {
		return civility;
	}
	public void setCivility(Civility civility) {
		this.civility = civility;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
	
}
