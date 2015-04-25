package ma.esoftech.esoftrade.DTO;

import java.util.Date;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.PCategoryAssociatedDTO;

public class PCategoryDTO {

	private long id;
	private EditorDTO creator;
	 private Date createDate;
	 private EditorDTO modifier;
	 private Date lastEdit;
	 private String description;
	 private String name;
	
	public Date getLastEdit() {
		return lastEdit;
	}
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	 
	 public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private PCategoryDTO(){}
}
