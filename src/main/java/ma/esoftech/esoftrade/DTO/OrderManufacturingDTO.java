package ma.esoftech.esoftrade.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.WarehouseAssociatedDTO;
import ma.esoftech.esoftrade.model.User;
import ma.esoftech.esoftrade.model.OrderManufacturing.OFPRIORITY;
import ma.esoftech.esoftrade.model.OrderManufacturing.OFStatus;
import org.hibernate.validator.constraints.NotEmpty;

public class OrderManufacturingDTO {
	private long id;
    private String ref;
    @NotEmpty
    @Size(max=20, min=2)
	private String title;
	private EditorDTO creator;
	private Date createDate;
	private EditorDTO modifier;
	private Date lastEdit;
	private String description;
	 @NotEmpty
	private String barreCode;
	private OFStatus status;
	private User responsible;
	private Date startDate;
	private Date dueDate;
	private Date endDate;
	private Date provisionalStartDate;
	private Date provisionalDueDate;
	private Boolean type;
	 @NotEmpty
	private Integer executedQT;
	 @NotEmpty
	private Integer lanchedQT;
	 @NotEmpty
	private Integer requeredQT;
	 @NotEmpty
	 @Size(max=20,min=2)
	private String team;
	private OFPRIORITY priority;
	private WarehouseAssociatedDTO warehouse=new WarehouseAssociatedDTO();
	private ProductAssociatedDTO product=new ProductAssociatedDTO () ;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBarreCode() {
		return barreCode;
	}
	public void setBarreCode(String barreCode) {
		this.barreCode = barreCode;
	}
	public OFStatus getStatus() {
		return status;
	}
	public void setStatus(OFStatus status) {
		this.status = status;
	}
	public User getResponsible() {
		return responsible;
	}
	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getProvisionalStartDate() {
		return provisionalStartDate;
	}
	public void setProvisionalStartDate(Date provisionalStartDate) {
		this.provisionalStartDate = provisionalStartDate;
	}
	public Date getProvisionalDueDate() {
		return provisionalDueDate;
	}
	public void setProvisionalDueDate(Date provisionalDueDate) {
		this.provisionalDueDate = provisionalDueDate;
	}
	public Boolean getType() {
		return type;
	}
	public void setType(Boolean type) {
		this.type = type;
	}
	public Integer getExecutedQT() {
		return executedQT;
	}
	public void setExecutedQT(Integer executedQT) {
		this.executedQT = executedQT;
	}
	public Integer getLanchedQT() {
		return lanchedQT;
	}
	public void setLanchedQT(Integer lanchedQT) {
		this.lanchedQT = lanchedQT;
	}
	public Integer getRequeredQT() {
		return requeredQT;
	}
	public void setRequeredQT(Integer requeredQT) {
		this.requeredQT = requeredQT;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public OFPRIORITY getPriority() {
		return priority;
	}
	public void setPriority(OFPRIORITY priority) {
		this.priority = priority;
	}
	public WarehouseAssociatedDTO getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(WarehouseAssociatedDTO warehouse) {
		this.warehouse = warehouse;
	}
	public ProductAssociatedDTO getProduct() {
		return product;
	}
	public void setProduct(ProductAssociatedDTO product) {
		this.product = product;
	}
	
}
