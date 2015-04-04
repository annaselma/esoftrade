package ma.esoftech.esoftrade.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role {
	@Id
	@GeneratedValue
	@Column(name="ROLE_ID" ,nullable=false , unique=true)
	private int id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Column(name="ROLE" , nullable=false , length=255)
	private String role;
	
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	@ManyToMany
	@JoinTable(name="PERM_ROLE" ,
	   joinColumns={
			@JoinColumn(name="PERMISSION_ID" , nullable=false)
	} ,inverseJoinColumns={
			@JoinColumn(name="ROLE_ID" , nullable=false)}
	)
	private List<Permission> permissions=  new ArrayList<Permission>();
	public Role(){}
}
