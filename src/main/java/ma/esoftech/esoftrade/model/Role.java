package ma.esoftech.esoftrade.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ELMO_ROLE")
public class Role extends MetaObject {

	private static final long serialVersionUID = 1L;



	@Column(name="ELMO_ROLE" , nullable=false , length=255)
	private String role;	
	@ManyToMany
	@JoinTable(name="ELMO_PERM_ROLE" ,
	   joinColumns={
			@JoinColumn(name="ELMO_ROLE_ID" )
	} ,inverseJoinColumns={
			@JoinColumn(name="ELMO_PERMISSION_ID" )}
	)
	private Set<Permission> permissions=  new HashSet<Permission>();
	
	public Role(){
		super();
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
}
