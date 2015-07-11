package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ELMO_DOCUMENT_LINE")
public class OrderLine extends MetaObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="ELMO_SEQ",nullable=false)
	private long sequence;

	@Column(name="ELMO_SUMMARY",length=511)
	private String summary;
	
	@Column(name="ELMO_TAX_RATE",nullable=false)
	private double taxRate=0;
	
	@Column(name="ELMO_UNIT_PRICE",nullable=false)
	private double unitPrice=0;
	
	@Column(name="ELMO_QTE")
	private long  quantity;
	
	@Column(name="ELMO_REDUCTION_RATE")
	private double reductionRate=0;
	
	@ManyToOne
	@JoinColumn(name = "ELMO_PRODUCT_ID")
	private Product product;
	
	public OrderLine(){
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

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getReductionRate() {
		return reductionRate;
	}

	public void setReductionRate(double reductionRate) {
		this.reductionRate = reductionRate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
