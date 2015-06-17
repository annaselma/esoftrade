package ma.esoftech.esoftrade.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
	@Column(name = "ELMO_FURNISHER_CODE", length = 255)
	private String supplierCode;

	@Index(name="ELMO_INDEX_CUSTOMER_CODE")
	@Column(name = "ELMO_CUSTOMER_CODE", length = 255)
	private String CustomerCode;
	
	@Column(name = "ELMO_WEBSITE", length = 255)
	private String webSite;
	
	@ManyToOne
	@JoinColumn(name = "ELMO_PICTURE_ID")
	 private File picture;

	 @OneToMany
	    @JoinTable(
	        name="ELMO_COMPANY_FILE",
	        joinColumns = @JoinColumn( name="ELMO_COMPANY_ID"),
	        inverseJoinColumns = @JoinColumn( name="ELMO_FILE_ID")
	    )private Set<File> files=new HashSet<File>();
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



	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public Set<File> getFiles() {
		return files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}


	
	

}
