package ma.esoftech.esoftrade.DTO;

import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;

public class ProductQuantityDTO {

	private long quantity;
	private ProductAssociatedDTO product;
	public ProductQuantityDTO() {
		// TODO Auto-generated constructor stub
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public ProductAssociatedDTO getProduct() {
		return product;
	}
	public void setProduct(ProductAssociatedDTO product) {
		this.product = product;
	}
	
}
