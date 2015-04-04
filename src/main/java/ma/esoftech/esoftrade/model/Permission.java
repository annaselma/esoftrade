package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ELMO_PERMISSION")
public class Permission extends MetaObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ELMO_LABEL", nullable = false, length = 255)
	private String label;
	@Column(name = "ELMO_DESCRIPTION", length = 255)
	private String description;

	public Permission() {

		super();

	}

	public String getLabel() {
		return label;
	}

	
	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
