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

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="ELMO_ROLE")
public class Role extends MetaObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Column(name="ELMO_ROLE" , nullable=false , length=255,unique=true)
	private String role;
	
	
	@ManyToMany
	@JoinTable(name="ELMO_PERM_ROLE" ,
	   joinColumns={
			@JoinColumn(name="ELMO_PERMISSION_ID" , nullable=false)
	} ,inverseJoinColumns={
			@JoinColumn(name="ELMO_ROLE_ID" , nullable=false)}
	)
	private List<Permission> permissions=  new ArrayList<Permission>();
	
	public Role(){
		super();
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
