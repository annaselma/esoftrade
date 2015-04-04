package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ELMO_DELEVERY_LINE")
public class DeliveryLine extends MetaObject {
	
	@Column(name="ELMO_SEQ",nullable=false)
	private long sequence;

	@Column(name="ELMO_SUMMARY",length=1024)
	private String summary;
	
	@Column(name="ELMO_QTE")
	private long  quantity;
	
	@Column(name="ELMO_WEIGHT")
	private double weight;
	
	@Column(name="ELMO_VOLUME")
	private double volume;
	
	@Column(name="ELMO_SHIPPING_QTE")
	private long shippingQte;
	
	@ManyToOne
	@JoinColumn(name = "ELMO_PRODUCT_ID")
	private Product product;
	
	public DeliveryLine(){
		super();
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public long getShippingQte() {
		return shippingQte;
	}

	public void setShippingQte(long shippingQte) {
		this.shippingQte = shippingQte;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
