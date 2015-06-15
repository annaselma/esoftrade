package ma.esoftech.esoftrade.DTO.associated;

public class PosteAssociatedDTO {
	private long id;
    private String ref;
    private String namePoste;
    private float price;
    private boolean productif;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getNamePoste() {
		return namePoste;
	}
	public void setNamePoste(String namePoste) {
		this.namePoste = namePoste;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isProductif() {
		return productif;
	}
	public void setProductif(boolean productif) {
		this.productif = productif;
	}
    
}
