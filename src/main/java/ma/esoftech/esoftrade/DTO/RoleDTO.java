package ma.esoftech.esoftrade.DTO;

import java.util.Date;
import java.util.List;

public class RoleDTO {

	private long id;
	private String name;
	
	private Date createDate;
	private Date lastEditDate;
	private EditorDTO creator;
	private EditorDTO modifier;
	private List<String> permissions;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public EditorDTO getCreator() {
		return creator;
	}
	public void setCreator(EditorDTO creator) {
		this.creator = creator;
	}
	public EditorDTO getModifier() {
		return modifier;
	}
	public void setModifier(EditorDTO modifier) {
		this.modifier = modifier;
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
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	private RoleDTO(){}
	public Date getLastEditDate() {
		return lastEditDate;
	}
	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}
}
