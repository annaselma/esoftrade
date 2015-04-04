package ma.esoftech.esoftrade.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "ELMO_COMPANY")
public class Company extends Person {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Index(name="ELMO_INDEX_FURNISHER_CODE")
	@Column(name = "ELMO_FURNISHER_CODE", unique=true, length = 255)
	private String supplierCode;

	@Index(name="ELMO_INDEX_CUSTOMER_CODE")
	@Column(name = "ELMO_CUSTOMER_CODE", unique=true, length = 255)
	private String CustomerCode;
	
	@Column(name = "ELMO_WEBSITE", length = 255)
	private String webSite;
	
	@Column(name = "ELMO_LOGO", length = 255)
	private String logo;
	
	@OneToMany
	@JoinColumn(name = "ELMO_COMPANY_ID")
	private List<Contact> contacts;

	public Company() {
			super();
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getCustomerCode() {
		return CustomerCode;
	}

	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	

}
