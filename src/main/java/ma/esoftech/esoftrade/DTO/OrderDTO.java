package ma.esoftech.esoftrade.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Index;

import ma.esoftech.esoftrade.DTO.associated.CompanyAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.FileAssociatedDTO;
import ma.esoftech.esoftrade.model.Company;
import ma.esoftech.esoftrade.model.File;
import ma.esoftech.esoftrade.model.OrderLine;
import ma.esoftech.esoftrade.model.ShippingMethod;
import ma.esoftech.esoftrade.model.BusinessDocument.PaymentType;
import ma.esoftech.esoftrade.model.OrderDocument.OrderStatus;
import ma.esoftech.esoftrade.model.OrderDocument.OrderType;

public class OrderDTO {
	private long id;
	private EditorDTO creator;
	private Date createDate;
	private EditorDTO modifier;
	private Date lastEdit;
	private String reference;
    private String customerReference;
    private PaymentType paymentType;
    private double netAmount=0;
    private double taxAmount=0;
    private double totalAmount=0;
    private double discount=0;
    private String summary;
	private String privateNote;
	private String publicNote;
	@NotNull(message="Tiers ne doit pas etre vide")
	private CompanyAssociatedDTO company;
	private String supplierReference;
	private Date deliveryDate;
	private ShippingMethod shippingMethod;
	private Date validityDueDate;
	private OrderStatus status;
	private OrderType type;
	private Set<OrderLineDTO> lines=new HashSet<OrderLineDTO>();
	private Set<FileAssociatedDTO> files=new HashSet<FileAssociatedDTO>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public EditorDTO getCreator() {
		return creator;
	}
	public void setCreator(EditorDTO creator) {
		this.creator = creator;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public EditorDTO getModifier() {
		return modifier;
	}
	public void setModifier(EditorDTO modifier) {
		this.modifier = modifier;
	}
	public Date getLastEdit() {
		return lastEdit;
	}
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
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
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPrivateNote() {
		return privateNote;
	}
	public void setPrivateNote(String privateNote) {
		this.privateNote = privateNote;
	}
	public String getPublicNote() {
		return publicNote;
	}
	public void setPublicNote(String publicNote) {
		this.publicNote = publicNote;
	}
	public CompanyAssociatedDTO getCompany() {
		return company;
	}
	public void setCompany(CompanyAssociatedDTO company) {
		this.company = company;
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
	public OrderType getType() {
		return type;
	}
	public void setType(OrderType type) {
		this.type = type;
	}
	public Set<OrderLineDTO> getLines() {
		return lines;
	}
	public void setLines(Set<OrderLineDTO> lines) {
		this.lines = lines;
	}
	public Set<FileAssociatedDTO> getFiles() {
		return files;
	}
	public void setFiles(Set<FileAssociatedDTO> files) {
		this.files = files;
	}
	
}
