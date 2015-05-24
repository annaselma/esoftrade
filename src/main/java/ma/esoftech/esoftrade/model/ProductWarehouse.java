package ma.esoftech.esoftrade.model;

public class ProductWarehouse {
	
private Product product;
private Warehouse warehouse;
private long quantity;


public ProductWarehouse(Product product, long quantity){
	this.product = product;
	System.out.println("produuuuuuct"+product.getId());
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
public Warehouse getWarehouse() {
	return warehouse;
}
public ProductWarehouse( Warehouse warehouse, long quantity) {
	super();
	this.warehouse = warehouse;
	this.quantity = quantity;
}
public ProductWarehouse( Product product,Warehouse warehouse, long quantity) {
	super();
	this.product = product;
	this.warehouse = warehouse;
	this.quantity = quantity;
}
public void setWarehouse(Warehouse warehouse) {
	this.warehouse = warehouse;
}
public ProductWarehouse(){}
}
