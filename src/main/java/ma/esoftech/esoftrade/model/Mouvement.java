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
	private int quantity=0;
	@Column(name="ELMO_PRICE")
	private float price=0f;
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
	@ManyToOne
	 @JoinColumn(name="ELMO_ORDERMANUFACTURING_ID")
	 private OrderManufacturing ofabrication;
	@ManyToOne
	 @JoinColumn(name="ELMO_ORDER_ID")
	 private OrderDocument orderDocument;
	

	
	public OrderManufacturing getOfabrication() {
		return ofabrication;
	}

	public void setOfabrication(OrderManufacturing ofabrication) {
		this.ofabrication = ofabrication;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public OrderDocument getOrderDocument() {
		return orderDocument;
	}

	public void setOrderDocument(OrderDocument orderDocument) {
		this.orderDocument = orderDocument;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public enum MouvementType{
		invoice,shipping,supplierOrder,stockCorrection,manufacturing,transfertStock,customerOrder
	}


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}


