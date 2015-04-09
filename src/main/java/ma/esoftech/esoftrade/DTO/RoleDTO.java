package ma.esoftech.esoftrade.DTO;

import java.util.Date;
import java.util.List;

public class RoleDTO {

	private long id;
	private String name;
	private String creator;
	private Date createDate;
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	private List<String> permissions;
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
}
