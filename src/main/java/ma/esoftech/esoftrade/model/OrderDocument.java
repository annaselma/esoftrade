package ma.esoftech.esoftrade.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "ELMO_ORDER")
public class OrderDocument extends BusinessDocument{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String PREFIX_REF_CU="CU_";
	private final static String PREFIX_REF_SUP="SU_";
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

	@Column(name = "ELMO_STATUS",nullable=false)
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@Column(name = "ELMO_TYPE",nullable=false)
	@Enumerated(EnumType.STRING)
	private OrderType type;
	@OneToMany(cascade={CascadeType.REMOVE})
	@JoinColumn(name="ELMO_ORDER_ID")
	private Set<OrderLine> lines=new HashSet<OrderLine>();
   
	
	
	@OneToMany
    @JoinTable(
        name="ELMO_ORDER_FILE",
        joinColumns = @JoinColumn( name="ELMO_ORDER_ID"),
        inverseJoinColumns = @JoinColumn( name="ELMO_FILE_ID")
    )
	private Set<File> files=new HashSet<File>();
	
	public OrderDocument() {
		super();
	}

	public String getSupplierReference() {
		return supplierReference;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public Set<OrderLine> getLines() {
		return lines;
	}

	public void setLines(Set<OrderLine> lines) {
		this.lines = lines;
	}

	public Set<File> getFiles() {
		return files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
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
	public String generateReference(){
    	String ref="";
    	this.setReference(String.valueOf(this.getId()));
    	 this.setCustomerReference(PREFIX_REF_CU+String.valueOf(this.getId()+"_"+this.getCreateDate().getTime()));
    	 this.setSupplierReference(PREFIX_REF_SUP+String.valueOf(this.getId()+"_"+this.getCreateDate().getTime()));
    return ref;
    }

}
