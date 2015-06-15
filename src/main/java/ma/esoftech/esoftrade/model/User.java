package ma.esoftech.esoftrade.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Index;

@Entity
@Table(name="ELMO_OWNER")
public class User extends Person {
	
	private static final long serialVersionUID = 1L;
	private static final String PREFIX_REF_USER="US";
	
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
	@ManyToOne
	@JoinColumn(name = "ELMO_POSTE_ID")
	 private Poste poste;
	@ManyToOne
	@JoinColumn(name = "ELMO_USER_ID")
	 private File picture;
	 @ManyToMany
	 @JoinTable(name="ELMO_OWNER_ROLE" , 
	   joinColumns={
			@JoinColumn(name="ELMO_OWNER_ID" , nullable=false)
	} ,inverseJoinColumns={
			@JoinColumn(name="ELMO_ROLE_ID" , nullable=false)}
	)
	 private Set<Role> roles=new HashSet<Role>();
	 
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
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
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Poste getPoste() {
		return poste;
	}
	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	public String generateReference(){
		String ref="";
		ref=ref.concat(PREFIX_REF_USER);
		ref=ref.concat(String.valueOf(this.getId()));
		ref=ref.concat("-");
		ref=ref.concat(String.valueOf(this.getCreateDate().getTime()));
		this.setRef(ref);
	return ref;	
	}
	
}
