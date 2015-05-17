package ma.esoftech.esoftrade.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ELMO_MOUVEMENT")
public class Mouvement extends MetaObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String motif;
	private Product product;
	private Warehouse warehouse;
	private int quantity;
	private Invoice invoice;
	private Order supplierOrder;
	
	@Enumerated(EnumType.STRING)
	private MouvementType type;
	
	@ManyToOne
	@JoinColumn(name="ELMO_PRODUCT_ID")
	private Product produit;

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public enum MouvementType{
		invoice,shipping,supplierOrder,stockCorrection,manufacturing
	}
	
}


