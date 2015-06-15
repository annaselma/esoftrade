package ma.esoftech.esoftrade.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
@Entity
@Table(name="ELMO_POSTE")
public class Poste extends MetaObject {
	private final static String PREFIX_REF_PO = "POST";
	private static final long serialVersionUID = 1L;
	@Column(name = "ELMO_REF", nullable = false, unique = true, length = 255)
	@Index(name = "ELMO_REF_INDEX")
	private String ref;

	@Column(name = "ELMO_COMMENT", length = 255)
	private String comment;
	@Column(name = "ELMO_NAME_POSTE")
	private String namePoste;
	@Column(name = "ELMO_NBPOSTE", length = 255)
	private Integer nbPoste;
	@Column(name = "ELMO_TYPE")
	private boolean productif = false;
	@Column(name = "ELMO_PRICE")
	// taux horaire sail/hours
	private float price;
	
@OneToMany
@JoinTable(
    name="ELMO_POST_FILE",
    joinColumns = @JoinColumn( name="ELMO_POST_ID"),
    inverseJoinColumns = @JoinColumn( name="ELMO_FILE_ID")
)
private Set<File> files=new HashSet<File>();


	public String getNamePoste() {
	return namePoste;
}
public void setNamePoste(String namePoste) {
	this.namePoste = namePoste;
}
public boolean isProductif() {
	return productif;
}
public void setProductif(boolean productif) {
	this.productif = productif;
}
public Set<File> getFiles() {
	return files;
}
public void setFiles(Set<File> files) {
	this.files = files;
}
	@ManyToOne
	 @JoinColumn(name="ELMO_POSTE_CATEGORY_ID" , nullable=false)
	 private CategoryPoste category;
	

public String getRef() {
	return ref;
}
public void setRef(String ref) {
	this.ref = ref;
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

public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public CategoryPoste getCategory() {
	return category;
}
public void setCategory(CategoryPoste category) {
	this.category = category;
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
