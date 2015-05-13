package ma.esoftech.esoftrade.model;

public class ProductWarehouse {
	
private Product product;
private long quantity;


public ProductWarehouse(Product product, long quantity){
	this.product = product;
	System.out.println("qte "+quantity);
	this.quantity = quantity;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public long getQuantity() {
	return quantity;
}
public void setQuantity(long quantity) {
	this.quantity = quantity;
}
public ProductWarehouse(){}
}
