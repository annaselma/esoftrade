package ma.esoftech.esoftrade.model;

import javax.persistence.Column;

public class ProductQuantity {
   
	
	private long quantity;
	private Product product;
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public ProductQuantity(long quantity,Product product){
		this.quantity=quantity;
		this.product=product;
	}
	
}
