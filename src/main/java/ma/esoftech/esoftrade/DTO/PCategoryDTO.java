package ma.esoftech.esoftrade.DTO;

import java.util.Date;

public class PCategoryDTO {

	private long id;
	private String creator;
	 private Date createDate;
	 private Date modifier;
	 private String name;
	 private String description;
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
	public Date getModifier() {
		return modifier;
	}
	public void setModifier(Date modifier) {
		this.modifier = modifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
	 private PCategoryDTO(){}
}
