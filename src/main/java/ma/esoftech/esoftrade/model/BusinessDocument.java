package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Index;



@MappedSuperclass
public abstract class BusinessDocument extends MetaObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="ELMO_REF",nullable=false,length=255,unique=true)
	@Index(name="ELMO_INDEX_REF")
	private String reference;
	
	@Column(name="ELMO_CUSTOMER_REF",nullable=false,length=255,unique=true)
    private String customerReference;
	
	@Column(name="ELMO_PAYMENT_TYPE",nullable=false,length=255)
	@Enumerated(EnumType.STRING)
    private PaymentType paymentType;
	

	
	@Column(name="ELMO_NET_AMOUNT",nullable=false)
    private double netAmount=0;
	
	@Column(name="ELMO_TAX_AMOUNT",nullable=false)
    private double taxAmount=0;
	
	@Column(name="ELMO_TOTAL_AMOUNT",nullable=false)
    private double totalAmount=0;
	
	@Column(name="ELMO_DISCOUNT",nullable=false)
    private double discount=0;
	
	@Column(name="ELMO_SUMMARY")
    private String summary;
	
	@Column(name="ELMO_PRIVATE_NOTE",length=511)
	private String privateNote;
	@Column(name="ELMO_PUBLIC_NOTE",length=511)
	private String publicNote;
	@ManyToOne
	@JoinColumn(name="ELMO_COMPANY_ID")
	private Company company;
	public BusinessDocument(){
		super();
		initialize();
	}
	
	private void initialize(){
		setDiscount(0);
		setNetAmount(0);
		setTaxAmount(0);
		setTotalAmount(0);

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
	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	public enum PaymentType{
		cheque,transfert,creditCard,TIP,cash,levy
	}
}
