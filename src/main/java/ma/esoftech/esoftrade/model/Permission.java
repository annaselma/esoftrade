package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(name="ELMO_STATUS")
	@Enumerated(EnumType.STRING)
	private Module module;

	public enum Module{
		User,WareHouse,Product,Manufacturing,Poste,Role,Order,Invoice,DeliveryOrder,CommercialProposal
	}
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

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
