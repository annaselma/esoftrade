package ma.esoftech.esoftrade.DTO;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;

public class RoleDTO {

	private long id;
	@NotEmpty
	@Size(min=1, max=20)
	private String role;
	
	private Date createDate;
	private Date lastEdit;
	private EditorDTO creator;
	private EditorDTO modifier;
	private List<PermissionDTO> permissions;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<PermissionDTO> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<PermissionDTO> permissions) {
		this.permissions = permissions;
	}
	public RoleDTO(){}
	public Date getLastEdit() {
		return lastEdit;
	}
	public void setLastEdit(Date lastEdit) {
		this.lastEdit= lastEdit;
	}
}
