package ma.esoftech.esoftrade.DTO;

import java.util.Date;

import javax.validation.constraints.Size;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.PCategoryAssociatedDTO;

import org.hibernate.validator.constraints.NotEmpty;


public class ProductDTO {
     private long id;
     private String ref;
     @NotEmpty
     @Size(max=100,min=4)
     private String libelle;
	 private EditorDTO creator;
	 private Date createDate;
	 private EditorDTO modifier;
	 private Date lastEditor;
	 @NotEmpty
	 private Boolean purchasingState= true;
	 @NotEmpty
	 private Boolean sellingState= true;
	 private Integer desieredTreshold;
	 @NotEmpty
	 private Integer alertTreshold;
	 private String description;
	 @NotEmpty
	 private String nature;
	 private float wheight;
	 private float lenght;
	 private float surface;
	 @NotEmpty
	 private Integer quantity;
	 private float volume;
	 @NotEmpty
	 private float price;
	 private float picture;
	 private String barreCode;
	 private PCategoryAssociatedDTO category;
	 public ProductDTO(){
		 
	 }
	 public String getLibelle() {
		return libelle;
	}
	public void setlibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getAlertTreshold() {
		return alertTreshold;
	}
	
	public EditorDTO getModifier() {
		return modifier;
	}
	public void setModifier(EditorDTO modifier) {
		this.modifier = modifier;
	}
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
	
	public void setAlertTreshold(Integer alertTreshold) {
		this.alertTreshold = alertTreshold;
	}
	public Integer getDesieredTreshold() {
		return desieredTreshold;
	}
	public void setDesieredTreshold(Integer desieredTreshold) {
		this.desieredTreshold = desieredTreshold;
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
	public float getPicture() {
		return picture;
	}
	public void setPicture(float picture) {
		this.picture = picture;
	}
	public String getBarreCode() {
		return barreCode;
	}
	public void setBarreCode(String barreCode) {
		this.barreCode = barreCode;
	}
	public Date getLastEditor() {
		return lastEditor;
	}
	public void setLastEditor(Date lastEditor) {
		this.lastEditor = lastEditor;
	}
	 
		public PCategoryAssociatedDTO getCategory() {
			return category;
		}
		public void setCategory(PCategoryAssociatedDTO category) {
			this.category = category;
		}
	 
	 
}
