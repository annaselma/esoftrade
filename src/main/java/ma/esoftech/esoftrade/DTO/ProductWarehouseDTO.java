package ma.esoftech.esoftrade.DTO;

import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.WarehouseAssociatedDTO;

public class ProductWarehouseDTO {
private ProductAssociatedDTO product;
private WarehouseAssociatedDTO warehouse;
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
public WarehouseAssociatedDTO getWarehouse() {
	return warehouse;
}
public void setWarehouse(WarehouseAssociatedDTO warehouse) {
	this.warehouse = warehouse;
}
public ProductWarehouseDTO() {
}
public ProductWarehouseDTO(ProductAssociatedDTO product,
		WarehouseAssociatedDTO warehouse, long quantity) {
	super();
	this.product = product;
	this.warehouse = warehouse;
	this.quantity = quantity;
}

}
