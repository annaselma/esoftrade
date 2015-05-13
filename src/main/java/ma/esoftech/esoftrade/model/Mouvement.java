package ma.esoftech.esoftrade.model;

import java.io.Serializable;

import javax.persistence.Column;
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
	@Column(name="ELMO_MOTIF", nullable= false,length= 255)
	private String motif;
	@Column(name="ELMO_QUANTITY", nullable= false)
	private int quantity;
//	private Invoice invoice;
	
	@Enumerated(EnumType.STRING)
	private MouvementType type;
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MouvementType getType() {
		return type;
	}

	public void setType(MouvementType type) {
		this.type = type;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@ManyToOne
	@JoinColumn(name="ELMO_PRODUCT_ID")
	private Product product;

//	@ManyToOne
//	@JoinColumn(name="ELMO_Order_ID")
//	private Order supplierOrder;
	
	@ManyToOne
	@JoinColumn(name="ELMO_Warehouse_ID")
	private Warehouse warehouse;
	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public enum MouvementType{
		invoice,shipping,supplierOrder,stockCorrection,manufacturing,transfertStock
	}
	
}


