package ma.esoftech.esoftrade.DTO.associated;

public class OrderAssociatedDTO {
	private long id;
	private String reference;
	private String supplierReference;
	private String customerReference;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getSupplierReference() {
		return supplierReference;
	}
	public void setSupplierReference(String supplierReference) {
		this.supplierReference = supplierReference;
	}
	public String getCustomerReference() {
		return customerReference;
	}
	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}
	
}
