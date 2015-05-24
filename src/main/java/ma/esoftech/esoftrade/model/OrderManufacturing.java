package ma.esoftech.esoftrade.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name="ELMO_ORDERMANUFACTURING")
public class OrderManufacturing extends MetaObject implements Serializable {
	private final static String PREFIX_REF_OF="OF";
	private static final long serialVersionUID = 1L;
     
	@Column(name="ELMO_REF", nullable= false,unique=true,length= 255)
	@Index(name="ELMO_REF_INDEX")
	 private String ref;
	@Column(name="ELMO_TITLE",length=255)
	private String title;
	@Column(name="ELMO_DESCRIPTION",length=255)
	private String description;
	@Column(name="ELMO_BARRECODE",nullable=false,length=255)
	@Index(name="ELMO_CODE_INDEX")
	private String barreCode;
	@Column(name="ELMO_STATUS")
	@Enumerated(EnumType.STRING)
	private OFStatus status;
	public enum OFStatus{
		canceled,waiting,onProduction,charged,notcharged,end,blocked,inpreparation
	}
	@ManyToOne
	@JoinColumn(name = "ELMO_RESPONSIBLE_ID")
	private User responsible;
	@Column(name="ELMO_START",length=255)
	private Date startDate;
	@Column(name="ELMO_END",length=255)
	private Date endDate;
	@Column(name="ELMO_PROVSIONALSTART",length=255)
	private Date provisionalStartDate;
	@Column(name="ELMO_PROVSIONALDUE",length=255)
	private Date provisionalEndDate;
	
	@ManyToOne
	@JoinColumn(name = "ELMO_SUBCONSTRUCTOR_ID")
	private Company subconstructor;
	@Column(name="ELMO_TYPE",length=255)
	private Boolean type;
	@Column(name="ELMO_EXECUTEDQT")
	private Integer executedQT;
	@Column(name="ELMO_LANCHEDQT")
	private Integer lanchedQT;
	@Column(name="ELMO_REJECTEDQT")
	private Integer rejectQT;
	@Column(name="ELMO_REQUEREDQT")
	private Integer requeredQT;
	@Column(name="ELMO_TEAM")
	private String team;
	@ManyToOne
	@JoinColumn(name = "ELMO_CENTER_ID")
    private Warehouse center;
    
	@ManyToOne
	@JoinColumn(name = "ELMO_PICTURE_ID")
	 private File picture;
	@Column(name="ELMO_PRIORITY")
	@Enumerated(EnumType.STRING)
	private OFPRIORITY priority;
	public enum OFPRIORITY {
		Urgent,Low,Emergency,Medium,High,Critical
	}
	@ManyToOne
	 @JoinColumn(name="ELMO_PRODUCT_ID")
	 private Product product;
	
	@OneToMany
    @JoinTable(
        name="ELMO_MANUFACTURING_FILE",
        joinColumns = @JoinColumn( name="ELMO_MANUFACTURING_ID"),
        inverseJoinColumns = @JoinColumn( name="ELMO_FILE_ID")
    )
	private Set<File> files=new HashSet<File>();

	 public Set<File> getFiles() {
		return files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}
	
	public OrderManufacturing() {
		super();
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
	public void setPriority(OFPRIORITY priority) {
		this.priority = priority;
	}
	
	public Company getSubconstructor() {
		return subconstructor;
	}

	public void setSubconstructor(Company subconstructor) {
		this.subconstructor = subconstructor;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String generateReference(){
		String ref="";
		ref=ref.concat(PREFIX_REF_OF);
		ref=ref.concat(String.valueOf(this.getId()));
		ref=ref.concat("-");
		ref=ref.concat(String.valueOf(this.getCreateDate().getTime()));
		this.setRef(ref);
	return ref;}	
	
}
