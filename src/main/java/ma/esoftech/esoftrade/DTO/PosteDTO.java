package ma.esoftech.esoftrade.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.FileAssociatedDTO;

public class PosteDTO {
	private long id;
	private String ref;
	private EditorDTO creator;
	private Date createDate;
	private EditorDTO modifier;
	private Date lastEdit;
	private String comment;
	private String namePoste;
	private Integer nbPoste;
	private boolean productif;
	private float price;
	private PosteCategoryDTO category= new PosteCategoryDTO();
	private List<FileAssociatedDTO> files = new ArrayList<FileAssociatedDTO>();
public PosteDTO() {
}
public String getRef() {
	return ref;
}
public void setRef(String ref) {
	this.ref = ref;
}

public String getNamePoste() {
	return namePoste;
}
public void setNamePoste(String namePoste) {
	this.namePoste = namePoste;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public Integer getNbPoste() {
	return nbPoste;
}
public void setNbPoste(Integer nbPoste) {
	this.nbPoste = nbPoste;
}
public boolean isProductif() {
	return productif;
}
public void setProductif(boolean productif) {
	this.productif = productif;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public List<FileAssociatedDTO> getFiles() {
	return files;
}
public void setFiles(List<FileAssociatedDTO> files) {
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
public PosteCategoryDTO getCategory() {
	return category;
}
public void setCategory(PosteCategoryDTO category) {
	this.category = category;
}

}
