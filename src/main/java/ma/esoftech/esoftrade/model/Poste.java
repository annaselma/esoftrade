package ma.esoftech.esoftrade.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
@Entity
@Table(name="ELMO_POSTE")
public class Poste extends MetaObject {
	private final static String PREFIX_REF_PO="PO";
	private static final long serialVersionUID = 1L;
	@Column(name="ELMO_REF", nullable= false,unique=true,length= 255)
	@Index(name="ELMO_REF_INDEX")
private String ref;
	@Column(name="ELMO_DESCRIPTION",length= 255)
private String description;
	@Column(name="ELMO_COMMENT",length= 255)
private String comment;
	@Column(name="ELMO_NBPOSTE",length= 255)
private Integer nbPoste;
private Set<User>Personnel= new HashSet<User>();
public String getRef() {
	return ref;
}
public void setRef(String ref) {
	this.ref = ref;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public Integer getNbPoste() {
	return nbPoste;
}
public void setNbPoste(Integer nbPoste) {
	this.nbPoste = nbPoste;
}
public Set<User> getPersonnel() {
	return Personnel;
}
public void setPersonnel(Set<User> personnel) {
	Personnel = personnel;
}
public String generateReference(){
	String ref="";
	ref=ref.concat(PREFIX_REF_PO);
	ref=ref.concat(String.valueOf(this.getId()));
	ref=ref.concat("-");
	ref=ref.concat(String.valueOf(this.getCreateDate().getTime()));
	this.setRef(ref);
return ref;}	
public Poste() {
 super();
}

}
