package ma.esoftech.esoftrade.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="OWNER")

public class Owner extends Person {
	
	private static final long serialVersionUID = 1L;

	@Column(name="DISABLE", nullable=false, length=255)
	private boolean disable;
	@Column(name="LOGIN" ,length=255 , nullable=false, unique=true)
	private String login;
	@Column(name="PASSWD" ,length=255 , nullable=false)
	private String passwd;
	 @ManyToMany
	 @JoinTable(name="OWNER_ROLE" ,
	   joinColumns={
			@JoinColumn(name="OWNER_ID" , nullable=false)
	} ,inverseJoinColumns={
			@JoinColumn(name="ROLE_ID" , nullable=false)}
	)
	 private List<Role> roles=new ArrayList<Role>();
	public boolean getDisable() {
		return disable;
	}
	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Owner (){}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public void setDisable(boolean disable) {
		this.disable = disable;
	}
}
