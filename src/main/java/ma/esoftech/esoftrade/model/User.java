package ma.esoftech.esoftrade.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Index;

@Entity
@Table(name="ELMO_OWNER")
public class User extends Person {
	
	private static final long serialVersionUID = 1L;
	
	public User(){
		super();
	}

	@Column(name="ELMO_DISABLE", nullable=false, length=255)
	private boolean active =true;
	
	@Index(name="ELMO_INDEX_LOGIN")
	@Column(name="ELMO_LOGIN" ,length=255 , nullable=false, unique=true)
	private String login;
	
	@Column(name="ELMO_PASSWD" ,length=255 , nullable=false)
	private String passwd;
	
	@Column(name="ELMO_lAST_NAME" ,length=255 )
	private String lastName;
	@Column(name="EMO_fonction",length=255)
	private String fonction;
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	@Column(name="ELMO_PICTURE" ,length=255 )
	private String picture;
	 @ManyToMany()
	 @JoinTable(name="ELMO_OWNER_ROLE" ,
	   joinColumns={
			@JoinColumn(name="ELMO_OWNER_ID" , nullable=false)
	} ,inverseJoinColumns={
			@JoinColumn(name="ELMO_ROLE_ID" , nullable=false)}
	)
	 private List<Role> roles=new ArrayList<Role>();
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
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
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
