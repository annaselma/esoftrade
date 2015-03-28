package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERMISSION")
public class Permission {
	@Id
	@GeneratedValue
	@Column(name="PERMISSION_ID" ,nullable=false , unique=true)
	private int id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="LIBEL" , nullable=false , length=255)
	private String Libel;
	@Column(name="Description", nullable=false, length=255)
	private  String description;
	
	public String getLibel() {
		return Libel;
	}
	public void setLibel(String libel) {
		Libel = libel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Permission(){}
}
