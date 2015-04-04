package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transaction {
@Id
@GeneratedValue
@Column(name="TRANSACTION_ID", nullable=false, length=255)
private int transaction_id;
@Column(name="TITLE", nullable=false, length=255)
private String title;
@Column(name="STATUS",nullable=false,length=255)
private int status;
@Column(name="DATE_CREATE", nullable=false, length=255)
private String date_create;
@Column(name="DATE_EDIT", nullable=false, length=255)
private String date_edit;
@Column(name="TAX", nullable=false, length=255)
private Float tax;
@Column(name="ALTERNATIVE_TAX", nullable=false, length=255)
private Float alternative_tax;
@Column(name="REDUCTION", nullable=false, length=255)
private Float reduction;
@Column(name="NOTE", nullable=false, length=255)
private String note;
public int getTransaction_id() {
	return transaction_id;
}
public void setTransaction_id(int transaction_id) {
	this.transaction_id = transaction_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getDate_create() {
	return date_create;
}
public void setDate_create(String date_create) {
	this.date_create = date_create;
}
public String getDate_edit() {
	return date_edit;
}
public void setDate_edit(String date_edit) {
	this.date_edit = date_edit;
}
public Float getTax() {
	return tax;
}
public void setTax(Float tax) {
	this.tax = tax;
}
public Float getAlternative_tax() {
	return alternative_tax;
}
public void setAlternative_tax(Float alternative_tax) {
	this.alternative_tax = alternative_tax;
}
public Float getReduction() {
	return reduction;
}
public void setReduction(Float reduction) {
	this.reduction = reduction;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}

/*@Column(name="CREATOR", nullable=false, length=255)
private Owner creator;*/
public Transaction(){}


}
