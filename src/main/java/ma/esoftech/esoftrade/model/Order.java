package ma.esoftech.esoftrade.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import ma.esoftech.esoftrade.model.CommercialProposal.ProposalStatus;

@Entity
@Table(name = "ELMO_ORDER")
public class Order extends MetaObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ELMO_SUPPLIER_REF", unique = true)
	@Index(name = "ELMO_INDEX_SUPPLIER_REF")
	private String supplierReference;

	@Column(name = "ELMO_DELIVERY_DATE")
	private Date deliveryDate;

	@Column(name = "ELMO_SHIPPING_METHOD")
	@Enumerated(EnumType.STRING)
	private ShippingMethod shippingMethod;

	@Column(name = "ELMO_VALIDITE_DUE_DATE")
	private Date validityDueDate;

	@Column(name = "ELMO_PROPOSAL_STATUS",nullable=false)
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@ManyToOne
	@JoinColumn(name="COMMERCIAL_PROPOSAL_ID")
	private CommercialProposal commercialProposal;

	public Order() {
		super();
	}

	public String getSupplierReference() {
		return supplierReference;
	}

	public void setSupplierReference(String supplierReference) {
		this.supplierReference = supplierReference;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public Date getValidityDueDate() {
		return validityDueDate;
	}

	public void setValidityDueDate(Date validityDueDate) {
		this.validityDueDate = validityDueDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public enum OrderType {
		customerOrder, supplierOrder
	}

	public enum OrderStatus {
		draft, billed, sentOrSaved, notified, denied, delivred, notBilled
	}

}
