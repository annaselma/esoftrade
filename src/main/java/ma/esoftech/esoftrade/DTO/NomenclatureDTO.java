package ma.esoftech.esoftrade.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.FileAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;

public class NomenclatureDTO {
private long id;
private EditorDTO creator;
private Date createDate;
private EditorDTO modifier;
private Date lastEdit;
private String ref;
private String description;
private Integer requeredQt;
private Integer rejectedQt;
private Integer usedQt;
private Integer missingQt;
private float cost;
public String getRef() {
	return ref;
}
public void setRef(String ref) {
	this.ref = ref;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Integer getRequeredQt() {
	return requeredQt;
}
public void setRequeredQt(Integer requeredQt) {
	this.requeredQt = requeredQt;
}
public Integer getRejectedQt() {
	return rejectedQt;
}
public void setRejectedQt(Integer rejectedQt) {
	this.rejectedQt = rejectedQt;
}
public Integer getUsedQt() {
	return usedQt;
}
public void setUsedQt(Integer usedQt) {
	this.usedQt = usedQt;
}
public Integer getMissingQt() {
	return missingQt;
}
public void setMissingQt(Integer missingQt) {
	this.missingQt = missingQt;
}
public float getCost() {
	return cost;
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
public ProductAssociatedDTO getProduct() {
	return product;
}
public void setProduct(ProductAssociatedDTO product) {
	this.product = product;
}
public List<FileAssociatedDTO> getFiles() {
	return files;
}
public void setFiles(List<FileAssociatedDTO> files) {
	this.files = files;
}
public void setCost(float cost) {
	this.cost = cost;
}
private ProductAssociatedDTO product=new ProductAssociatedDTO();
private  List<FileAssociatedDTO> files=new ArrayList<FileAssociatedDTO>();
}
