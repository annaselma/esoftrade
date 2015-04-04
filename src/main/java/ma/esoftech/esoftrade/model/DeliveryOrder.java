package ma.esoftech.esoftrade.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "ELMO_DELIVERY_ORDER")
public class DeliveryOrder extends MetaObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String reference;
	private String customerReference;
	private Date deliveryDate;
	@Column(name="ELMO_WEIGHT")
	private double weight;
	
	@Column(name="ELMO_VOLUME")
	private double volume;

	@Column(name="ELMO_SHIPPING_METHOD")
	@Enumerated(EnumType.STRING)
	private ShippingMethod shippingMethod;
	
	@OneToMany
	@JoinColumn(name="ELMO_DELIVERY_ID")
	private List<DeliveryLine> deliveryLines;
	
	private Company customer;
	private List<File> attachedFiles;
	
	private DeliveryStatus deliveryStatus;
	
	public DeliveryOrder(){
		super();
	}
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public List<DeliveryLine> getDeliveryLines() {
		return deliveryLines;
	}

	public void setDeliveryLines(List<DeliveryLine> deliveryLines) {
		this.deliveryLines = deliveryLines;
	}

	public Company getCustomer() {
		return customer;
	}

	public void setCustomer(Company customer) {
		this.customer = customer;
	}

	public List<File> getAttachedFiles() {
		return attachedFiles;
	}

	public void setAttachedFiles(List<File> attachedFiles) {
		this.attachedFiles = attachedFiles;
	}

	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public enum DeliveryStatus {
		draft, sentOrSaved, reception, denied
	}

}
