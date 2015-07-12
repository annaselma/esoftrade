package ma.esoftech.esoftrade.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	private static final String PREFIX_REF_CUSTOMER = "CU";
	private static final String PREFIX_REF_SUPPLIER = "SU";
	@Index(name="ELMO_INDEX_FURNISHER_CODE")
	@Column(name = "ELMO_FURNISHER_CODE", length = 255)
	private String supplierCode;

	@Index(name="ELMO_INDEX_CUSTOMER_CODE")
	@Column(name = "ELMO_CUSTOMER_CODE", length = 255)
	private String customerCode;
	
	@Column(name="ELMO_CUSTOMER")
	private boolean customer;
	@Column(name="ELMO_SUPPLIER")
	private boolean supplier;
	@Column(name="ELMO_STATUS")
	@Enumerated(EnumType.STRING)
	private ThirdStatus status;
	@Column(name="ELMO_CAPITAL")
	private int capital;
	@Column(name="ELMO_EFFECTIVE")
	@Enumerated(EnumType.STRING)
	private Effective effective;
	@Column(name="ELMO_TYPE")
	@Enumerated(EnumType.STRING)
	private ThirdType type;
	
	
	@Column(name = "ELMO_WEBSITE", length = 255)
	private String webSite;
	
	@ManyToOne
	@JoinColumn(name = "ELMO_PICTURE_ID")
	 private File picture;

	 @OneToMany(cascade={CascadeType.REMOVE})
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
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
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

	public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
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


	public enum ThirdType{
		SMEs_SMIs,wholesaler,administration,auther,GE,particular
	}
	public enum ThirdStatus{
		inActivity,closed
	}
    public enum Effective{
    	oneToFive,sixToTen,elevenToFifty,fifty_oneToHandred,GreatherThanHandred
    }
    public enum CompanyType{
    	customer,supplier,all
    }
	
	
    public String generateReference(){
		String ref="";
		ref=ref.concat(PREFIX_REF_CUSTOMER);
		ref=ref.concat(String.valueOf(this.getId()));
		ref=ref.concat("-");
		ref=ref.concat(String.valueOf(this.getCreateDate().getTime()));
		this.setCustomerCode(ref);
		ref="";
		ref=ref.concat(PREFIX_REF_SUPPLIER);
		ref=ref.concat(String.valueOf(this.getId()));
		ref=ref.concat("-");
		ref=ref.concat(String.valueOf(this.getCreateDate().getTime()));
		this.setSupplierCode(ref);
		generateRef();
	return ref;	
	}
    private  void generateRef(){
		this.setRef(String.valueOf(this.getId()));
    	
    }

}
