package ma.esoftech.esoftrade.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
@Entity
@Table(name="ELMO_WAREHOUSE")
public class Warehouse extends MetaObject implements Serializable{
	private static final String PREFIX_REF_USER="ENT";
	private static final long serialVersionUID = 1L;
	@Column(name="ELMO_ref", nullable= false,unique=true,length= 255)
	@Index(name="ELMO_REF_INDEX")
	 private String ref;
	@Column(name="ELMO_NAMEW", nullable= false,length= 255)
	public String name;
	@Column(name="ELMO_ADRESSEW",length= 255)
	public String adresse;
	@Column(name="ELMO_DESCRIPTIONW", length= 1000)
	public String Description;
	@Column(name="ELMO_ZIP_CODEW",length=255)
	private String zipCode;
	@Column(name="ELMO_COUNTRYW",length=255)
	private String country;
	@Column(name="ELMO_CITYW",length=255)
	private String city;
	@Column(name="ELMO_STATUSW", nullable=false, length=255)
	private boolean open =true;
	
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String generateReference(){
		String ref="";
		ref=ref.concat(PREFIX_REF_USER);
		ref=ref.concat(String.valueOf(this.getId()));
		ref=ref.concat("-");
		ref=ref.concat(String.valueOf(this.getCreateDate().getTime()));
		this.setRef(ref);
	return ref;	
	}
}
