package ma.esoftech.esoftrade.DTO;

import java.util.Date;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.WarehouseAssociatedDTO;
import ma.esoftech.esoftrade.model.Mouvement.MouvementType;

public class Transfertdto {
	private long id;
	private EditorDTO creator;
	 private Date createDate;
	 private EditorDTO modifier;
	 private Date lastEdit;
	 private String motif;
	 private int quantity;
	private MouvementType type;
	private WarehouseAssociatedDTO source=new WarehouseAssociatedDTO();
	private WarehouseAssociatedDTO target= new WarehouseAssociatedDTO();
	private ProductAssociatedDTO product=new ProductAssociatedDTO () ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public EditorDTO getCreator() {
		return creator;
	}
	public void setCreator(EditorDTO creator) {
		this.creator = creator;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public EditorDTO getModifier() {
		return modifier;
	}
	public void setModifier(EditorDTO modifier) {
		this.modifier = modifier;
	}
	public Date getLastEdit() {
		return lastEdit;
	}
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MouvementType getType() {
		return type;
	}
	public void setType(MouvementType type) {
		this.type = type;
	}
	public WarehouseAssociatedDTO getSource() {
		return source;
	}
	public void setSource(WarehouseAssociatedDTO source) {
		this.source = source;
	}
	public WarehouseAssociatedDTO getTarget() {
		return target;
	}
	public void setTarget(WarehouseAssociatedDTO target) {
		this.target = target;
	}
	public ProductAssociatedDTO getProduct() {
		return product;
	}
	public void setProduct(ProductAssociatedDTO product) {
		this.product = product;
	}

public Transfertdto() {
}
}
