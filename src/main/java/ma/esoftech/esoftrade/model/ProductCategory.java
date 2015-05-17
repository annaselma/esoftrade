package ma.esoftech.esoftrade.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ELMO_PRODUCT_CATEGORY")
public class ProductCategory  extends MetaObject implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name="ELMO_NAME")
private String name;
	@Column(name="ELMO_DESCRIPTION")
private String description;
	
	public ProductCategory(){
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}




}
