package ma.esoftech.esoftrade.DTO;

import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;

public class ProductWarehouseDTO {
private ProductAssociatedDTO product;
private long quantity;
public ProductAssociatedDTO getProduct() {
	return product;
}
public void setProduct(ProductAssociatedDTO product) {
	this.product = product;
}
public long getQuantity() {
	return quantity;
}
public void setQuantity(long quantity) {
	this.quantity = quantity;
}
}
