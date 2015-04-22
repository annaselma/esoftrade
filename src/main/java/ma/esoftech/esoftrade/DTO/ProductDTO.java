package ma.esoftech.esoftrade.DTO;

import java.util.Date;


public class ProductDTO {
     private long id;
     private String ref;
	 private String creator;
	 private Date createDate;
	 private Date modifier;
	 private Boolean purchasingState= true;
	 private Boolean sellingState= true;
	 private Integer desieredTreshold;
	 private Integer alertTreshold;
	 private String description;
	 private float wheight;
	 private float lenght;
	 private float surface;
	 private float volume;
	 private float price;
	 private float picture;
	 private String barreCode;
	 
	 public ProductDTO(){
		 
	 }
	 public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
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
	
	public Date getModifier() {
		return modifier;
	}
	public void setModifier(Date modifier) {
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
	 
	 
}
