package ma.esoftech.esoftrade.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "ELMO_COMMERCIAL_PROPOSAL")
public class CommercialProposal extends BusinessDocument {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="ELMO_DELIVERY_DATE")
	private Date deliveryDate;
	
	@Column(name="ELMO_SHIPPING_METHOD")
	@Enumerated(EnumType.STRING)
	private ShippingMethod shippingMethod;
	
	@Column(name="ELMO_VALIDITE_DUE_DATE")
	private Date validityDueDate;
	
	@Column(name="ELMO_PROPOSAL_STATUS")
	@Enumerated(EnumType.STRING)
	private ProposalStatus status;
	
	
	public CommercialProposal(){
		super();
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
	public ProposalStatus getStatus() {
		return status;
	}
	public void setStatus(ProposalStatus status) {
		this.status = status;
	}






	public enum ProposalStatus {
		draft, billed, sentOrSaved, notified, denied, delivred, notBilled, ordered
	}

}
