package ma.esoftech.esoftrade.model;

import java.io.Serializable;
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
@Table(name="ELMO_NOMENCLATURE")
public class Nomenclature extends MetaObject implements Serializable{
	private final static String PREFIX_REF_NC="NC";
	private static final long serialVersionUID = 1L;
	@Column(name="ELMO_REF", nullable= false,unique=true,length= 255)
	@Index(name="ELMO_REF_INDEX")
private String ref;
	@Column(name="ELMO_DESCRIPTION",length=255)
private String description;
	@Column(name="ELMO_REQUEREDQT")
private Integer requeredQt;
	@Column(name="ELMO_REJECTEDQT")
private Integer rejectedQt;
	@Column(name="ELMO_USEDQT")
private Integer usedQt;
	@Column(name="ELMO_MISSINGQT")
private Integer missingQt;
	@Column(name="ELMO_COST")
private float cost;

	 @ManyToOne
	 @JoinColumn(name="ELMO_PRODUCT_ID")
	 private Product product;
	
public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
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
public Integer getRequeredQt() {
	return requeredQt;
}
public void setRequeredQt(Integer requeredQt) {
	this.requeredQt = requeredQt;
}
public Integer getRejectedQt() {
	return rejectedQt;
}
public void setRejectedQt(Integer rejectedQt) {
	this.rejectedQt = rejectedQt;
}
public Integer getUsedQt() {
	return usedQt;
}
public void setUsedQt(Integer usedQt) {
	this.usedQt = usedQt;
}
public Integer getMissingQt() {
	return missingQt;
}
public void setMissingQt(Integer missingQt) {
	this.missingQt = missingQt;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}
public Nomenclature() {
	super();
}
public String generateReference(){
	String ref="";
	ref=ref.concat(PREFIX_REF_NC);
	ref=ref.concat(String.valueOf(this.getId()));
	ref=ref.concat("-");
	ref=ref.concat(String.valueOf(this.getCreateDate().getTime()));
	this.setRef(ref);
return ref;}	

}
