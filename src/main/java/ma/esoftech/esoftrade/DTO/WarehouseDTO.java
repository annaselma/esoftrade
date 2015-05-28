package ma.esoftech.esoftrade.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.FileAssociatedDTO;

public class WarehouseDTO {
	private long id;
	private String ref;
	private EditorDTO creator;
	 private Date createDate;
	 private EditorDTO modifier;
	 private Date lastEdit;
	 private String description;
	 @Size(min=4,max=25)
	 private String name;
	 private String adresse;
	 @Size(max=10)
	 private String zipCode;
	 private String country;
	 private String city;
	 private boolean atelier=false;
	 private  List<FileAssociatedDTO> files=new ArrayList<FileAssociatedDTO>();
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isAtelier() {
		return atelier;
	}
	public void setAtelier(boolean atelier) {
		this.atelier = atelier;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public List<FileAssociatedDTO> getFiles() {
		return files;
	}
	public void setFiles(List<FileAssociatedDTO> files) {
		this.files = files;
	}
	 
	 
}
