package ma.esoftech.esoftrade.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="INVOICE")
public class Invoice {

	@Transient
	public static final int PAID=1;
	@Transient
	public static final int PARTIALLY_PAID_STATE=2;
	@Transient
	public static final int UNPAID=3;
	
	
	
	@Id
	@Column(name="INVOICE_ID" ,nullable=false, unique=true)
	private String invoiceId;
	@OneToOne
	@JoinColumn(name="Order_ID")
	private Order order;
	@Column(name="START_DATE")
	private Date   startDate;
	@Column(name="DUE_DATE")
	private Date   dueDate;
	@Column(name="AMOUNT_TO_PAY")
	private float  amountToPay;
	@Column(name="REST_TO_PAY")
	private float restToPay;
	@Column(name="STATUS")
	private int status;
	
	public Invoice(){
	}


	public String getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(java.util.Date date) {
		this.startDate = date;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public float getAmountToPay() {
		return amountToPay;
	}


	public void setAmountToPay(float amountToPay) {
		this.amountToPay = amountToPay;
	}


	public float getRestToPay() {
		return restToPay;
	}


	public void setRestToPay(float restToPay) {
		this.restToPay = restToPay;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
public Order geOrder(){
	return order;
}
public void  setOrder(Order ord){
 this.order= ord;	
}



	

	
}
