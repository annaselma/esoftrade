package ma.esoftech.esoftrade.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.FileAssociatedDTO;
import ma.esoftech.esoftrade.model.Company.Effective;
import ma.esoftech.esoftrade.model.Company.ThirdStatus;
import ma.esoftech.esoftrade.model.Company.ThirdType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;


public class CompanyDTO {
	
	private long id;
	private EditorDTO creator;
	private Date createDate;
	private EditorDTO modifier;
	private Date lastEdit;
	@NotEmpty
	private String name;
	private String adresse;
	private String zipCode;
	private String country;
	private String city;
	private String telephone;
	private String telephonePro;
	private Date birdDay;
	private String fax;
	@Email
	private String email;
	private String supplierCode;
	private String customerCode;
	private boolean customer;
	private boolean supplier;
	private ThirdStatus status;
	private Integer capital=0;
	private Effective effective;
	private ThirdType type;
	private String webSite;
	private FileAssociatedDTO  picture;
    private Set<FileAssociatedDTO> files=new HashSet<FileAssociatedDTO>();
    public CompanyDTO(){
    	
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public boolean isCustomer() {
		return customer;
	}
	public void setCustomer(boolean customer) {
		this.customer = customer;
	}
	public boolean isSupplier() {
		return supplier;
	}
	public void setSupplier(boolean supplier) {
		this.supplier = supplier;
	}
	public ThirdStatus getStatus() {
		return status;
	}
	public void setStatus(ThirdStatus status) {
		this.status = status;
	}
	public Integer getCapital() {
		return capital;
	}
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	public Effective getEffective() {
		return effective;
	}
	public void setEffective(Effective effective) {
		this.effective = effective;
	}
	public ThirdType getType() {
		return type;
	}
	public void setType(ThirdType type) {
		this.type = type;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public FileAssociatedDTO getPicture() {
		return picture;
	}
	public void setPicture(FileAssociatedDTO picture) {
		this.picture = picture;
	}
	public Set<FileAssociatedDTO> getFiles() {
		return files;
	}
	public void setFiles(Set<FileAssociatedDTO> files) {
		this.files = files;
	}
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
    
}
