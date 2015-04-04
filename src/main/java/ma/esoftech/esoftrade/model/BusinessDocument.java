package ma.esoftech.esoftrade.model;

import java.util.List;

import javax.persistence.Column;
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
    private String paymentType;
	
	@Column(name="ELMO_PAYMENT_TERM",nullable=false,length=255)
    private String paymentTerm;
	
	@Column(name="ELMO_NET_AMOUNT",nullable=false)
    private double netAmount;
	
	@Column(name="ELMO_TAX_AMOUNT",nullable=false)
    private double taxAmount;
	
	@Column(name="ELMO_TOTAL_AMOUNT",nullable=false)
    private double totalAmount;
	
	@Column(name="ELMO_DISCOUNT",nullable=false)
    private double discount;
	
	@Column(name="ELMO_SUMMARY")
    private String summary;
	/*TODO corriger cette annotation suivante*/
	@ManyToOne
	@JoinColumn(name="ELMO_ATTACHED_FILE_ID")
    private List<File> attachedFiles;
	
	@ManyToOne
	@JoinColumn(name="ELMO_DOCUMENT_LINE_ID")
    private List<DocumentLine> documentLines;
	
	
	
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

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
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

	public List<File> getAttachedFiles() {
		return attachedFiles;
	}

	public void setAttachedFiles(List<File> attachedFiles) {
		this.attachedFiles = attachedFiles;
	}

	public List<DocumentLine> getDocumentLines() {
		return documentLines;
	}

	public void setDocumentLines(List<DocumentLine> documentLines) {
		this.documentLines = documentLines;
	}
	
	
	
	
	
}
