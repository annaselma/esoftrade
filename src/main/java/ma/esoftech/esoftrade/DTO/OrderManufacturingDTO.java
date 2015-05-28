package ma.esoftech.esoftrade.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.FileAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.UserAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.WarehouseAssociatedDTO;

import ma.esoftech.esoftrade.model.OrderManufacturing.OFPRIORITY;
import ma.esoftech.esoftrade.model.OrderManufacturing.OFStatus;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

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
	private String barreCode;
	private OFStatus status;
	private UserAssociatedDTO responsible;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull
	private Date startDate;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull
	private Date endDate;
	private Date provisionalStartDate;
	private Date provisionalEndDate;
	private Boolean type;
	private Integer rejectQT=0;
	private Integer executedQT=0;
	private Integer lanchedQT=1;
	private Integer requeredQT=0;
	private Integer restToDoQT=0;
	 @NotEmpty
	 @Size(max=20,min=2)
	private String team;
	private OFPRIORITY priority;
	private float unitCost;
	private float unitCostTheory;
	private float totalRealCost;
	private float totalTheoryCost;
	private Integer deadline=0;
	private Integer progress=0;
	private FileAssociatedDTO picture=null;
	public FileAssociatedDTO getPicture() {
		return picture;
	}
	public void setPicture(FileAssociatedDTO picture) {
		this.picture = picture;
	}
	@NotNull(message="produit ne doit pas être null")
	private ProductAssociatedDTO product=null;
	@NotNull(message="centre ne doit pas être null")
	private WarehouseAssociatedDTO center=null;
	private  List<FileAssociatedDTO> files=new ArrayList<FileAssociatedDTO>();
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
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	
	public Date getProvisionalEndDate() {
		return provisionalEndDate;
	}
	public void setProvisionalEndDate(Date provisionalEndDate) {
		this.provisionalEndDate = provisionalEndDate;
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
	public Integer getRestToDoQT() {
		return restToDoQT;
	}
	public void setRestToDoQT(Integer restToDoQT) {
		this.restToDoQT = restToDoQT;
	}
	public void setPriority(OFPRIORITY priority) {
		this.priority = priority;
	}
	
	
	public List<FileAssociatedDTO> getFiles() {
		return files;
	}
	public void setFiles(List<FileAssociatedDTO> files) {
		this.files = files;
	}
	public OrderManufacturingDTO() {
		setStartDate(new Date() );
		setEndDate(new Date());
	}
	public ProductAssociatedDTO getProduct() {
		return product;
	}
	public void setProduct(ProductAssociatedDTO product) {
		this.product = product;
	}
	public UserAssociatedDTO getResponsible() {
		return responsible;
	}
	public void setResponsible(UserAssociatedDTO responsible) {
		this.responsible = responsible;
	}
	public Integer getRejectQT() {
		return rejectQT;
	}
	public void setRejectQT(Integer rejectQT) {
		this.rejectQT = rejectQT;
	}
	public WarehouseAssociatedDTO getCenter() {
		return center;
	}
	public void setCenter(WarehouseAssociatedDTO center) {
		this.center = center;
	}
	public float getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}
	public float getUnitCostTheory() {
		return unitCostTheory;
	}
	public void setUnitCostTheory(float unitCostTheory) {
		this.unitCostTheory = unitCostTheory;
	}
	public float getTotalRealCost() {
		return totalRealCost;
	}
	public void setTotalRealCost(float totalRealCost) {
		this.totalRealCost = totalRealCost;
	}
	public float getTotalTheoryCost() {
		return totalTheoryCost;
	}
	public void setTotalTheoryCost(float totalTheoryCost) {
		this.totalTheoryCost = totalTheoryCost;
	}
	public Integer getDeadline() {
		this.deadline= (int) Math.floor(this.endDate.getTime()-new Date().getTime());
		this.deadline=this.deadline/1000;
		this.deadline=this.deadline/3600;
		this.deadline=this.deadline/24;
		return deadline;
	}
	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}
	public Integer getProgress() {
		this.progress=(int) Math.floor((this.executedQT/this.lanchedQT)*100);
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	
}
