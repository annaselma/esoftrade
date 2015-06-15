package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ELMO_POSCATEGORY")
public class CategoryPoste extends MetaObject {
	private static final long serialVersionUID = 1L;

	@Column(name="ELMO_PNAME")
	private String name;
		@Column(name="ELMO_PDESCRIPTION")
	private String description;
public CategoryPoste() {
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