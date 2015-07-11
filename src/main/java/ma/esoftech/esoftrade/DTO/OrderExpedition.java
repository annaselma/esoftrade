package ma.esoftech.esoftrade.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.WarehouseAssociatedDTO;

public class OrderExpedition{
	public OrderExpedition(){}
	@NotNull(message="produit ne doit pas etre vide")
	private ProductAssociatedDTO product;
	@NotNull(message="entrepot ne doit pas etre vide")
	private WarehouseAssociatedDTO warehouse;
	private long qte;
	private float price;
	public ProductAssociatedDTO getProduct() {
		return product;
	}
	public void setProduct(ProductAssociatedDTO product) {
		this.product = product;
	}
	public WarehouseAssociatedDTO getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(WarehouseAssociatedDTO warehouse) {
		this.warehouse = warehouse;
	}
	public long getQte() {
		return qte;
	}
	public void setQte(long qte) {
		this.qte = qte;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}