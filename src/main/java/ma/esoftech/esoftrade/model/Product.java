package ma.esoftech.esoftrade.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
@Entity
@Table(name="ELMO_PRODUCT")
public class Product  extends MetaObject implements Serializable {
	private final static String PREFIX_REF_PRODUCT="PR";
	private static final long serialVersionUID = 1L;
     
	@Column(name="ELMO_ref", nullable= false,unique=true,length= 255)
	@Index(name="ELMO_REF_INDEX")
	 private String ref;
	@Column(name="ELMO_Libelle",nullable=false,length=255)
	private String libelle;
	@Column(name="ELMO_PURCHASINGSTATE", nullable= false)
	 private Boolean purchasingState= true;
	@Column(name="ELMO_SELLINGSTATE", nullable= false)
	 private Boolean sellingState= true;
	@Column(name="ELMO_DESIERED_TRESHOLD", length= 255)
	 private Integer desieredTreshold;
	@Column(name="ELMO_ALERT_TRESHOLD",nullable=false,length= 255)
	 private Integer alertTreshold;
	@Column(name="ELMO_NATURE",nullable=false, length=255)
	private String nature;
	
	@Column(name="ELMO_DESCRIPTION",length= 1000)
	 private String description;
	@Column(name="ELMO_WHEIGHT")
	 private float wheight;
	@Column(name="ELMO_LENGHT")
	 private float lenght;
	@Column(name="ELMO_SURFACE")
	 private float surface;
	@Column(name="ELMO_VOLUME")
	 private float volume;
	@Column(name="ELMO_PRICE",nullable=false)
	 private float price;
	@Column(name="ELMO_PICTURE",length= 255)
	 private String picture;
	@Column(name="ELMO_BARRECODE", unique=true,length= 255)
	 private String barreCode;

	 public Product(){
		 super();
	 }

	 @ManyToOne
	 @JoinColumn(name="ELMO_PRODUCT_CATEGORY_ID" , nullable=false)
	 private ProductCategory category;
	 
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Boolean getPurchasingState() {
		return purchasingState;
	}

	public void setPurchasingState(Boolean purchasingState) {
		this.purchasingState = purchasingState;
	}

	public Boolean getSellingState() {
		return sellingState;
	}

	public void setSellingState(Boolean sellingState) {
		this.sellingState = sellingState;
	}

	public Integer getDesieredTreshold() {
		return desieredTreshold;
	}

	public void setDesieredTreshold(Integer desieredTreshold) {
		this.desieredTreshold = desieredTreshold;
	}

	public Integer getAlertTreshold() {
		return alertTreshold;
	}

	public void setAlertTreshold(Integer alertTreshold) {
		this.alertTreshold = alertTreshold;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getWheight() {
		return wheight;
	}

	public void setWheight(float wheight) {
		this.wheight = wheight;
	}

	public float getLenght() {
		return lenght;
	}

	public void setLenght(float lenght) {
		this.lenght = lenght;
	}

	public float getSurface() {
		return surface;
	}

	public void setSurface(float surface) {
		this.surface = surface;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getBarreCode() {
		return barreCode;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public void setBarreCode(String barreCode) {
		this.barreCode = barreCode;
	}
	
	public String generateReference(){
		String ref="";
		ref=ref.concat(PREFIX_REF_PRODUCT);
		ref=ref.concat(String.valueOf(this.getId()));
		ref=ref.concat("-");
		ref=ref.concat(String.valueOf(this.getCreateDate().getTime()));
		this.setRef(ref);
	return ref;	
	}
}
