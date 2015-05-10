package ma.esoftech.esoftrade.DTO;

import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;

public class ProductWarehouseDTO {
private ProductAssociatedDTO product;
private int quanity;
public ProductAssociatedDTO getProduct() {
	return product;
}
public void setProduct(ProductAssociatedDTO product) {
	this.product = product;
}
public int getQuanity() {
	return quanity;
}
public void setQuanity(int quanity) {
	this.quanity = quanity;
}

}
