package ma.esoftech.esoftrade.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.FileAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.PCategoryAssociatedDTO;

import org.hibernate.validator.constraints.NotEmpty;


public class ProductDTO {
     private long id;
     private String ref;
     @NotEmpty
     @Size(max=20, min=2)
     private String libelle;
	 private EditorDTO creator;
	 private Date createDate;
	 private EditorDTO modifier;
	 private Date lastEdit;
	 private Boolean purchasingState= false;
	 private Boolean sellingState= false;
	 @Min(1)
	 @NotNull
	 private Integer desieredTreshold=0;
	 @Min(1)
	 @NotNull
	 private Integer alertTreshold=0;
	 private String description;
	 @NotEmpty
	 private String nature;
	 private float wheight;
	 private float lenght;
	 private float surface;
	 private float volume;
	 @NotNull
	 private float price;
	 private FileAssociatedDTO picture=new FileAssociatedDTO();
	 @NotEmpty
	 @Size(min=2)
	 private String barreCode;
	 @NotNull(message="la catégorie ne doit pas etre vide")
	 private PCategoryAssociatedDTO category=new PCategoryAssociatedDTO();
	 private String department;
	 private  List<FileAssociatedDTO> files=new ArrayList<FileAssociatedDTO>();
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	public FileAssociatedDTO getPicture() {
		return picture;
	}
	public void setPicture(FileAssociatedDTO picture) {
		this.picture = picture;
	}
	public String getBarreCode() {
		return barreCode;
	}
	public void setBarreCode(String barreCode) {
		this.barreCode = barreCode;
	}
	public Date getLastEdit() {
		return lastEdit;
	}
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}
	 
		public PCategoryAssociatedDTO getCategory() {
			return category;
		}
		public void setCategory(PCategoryAssociatedDTO category) {
			this.category = category;
		}
		public List<FileAssociatedDTO> getFiles() {
			return files;
		}
		public void setFiles(List<FileAssociatedDTO> files) {
			this.files = files;
		}
	 
	 
}
