package ma.esoftech.esoftrade.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name="ELMO_TITLE",nullable=false,length=255)
	private String title;
	@Column(name="ELMO_DESCRIPTION",length=255)
	private String description;
	@Column(name="ELMO_BARRECODE",nullable=false,length=255)
	@Index(name="ELMO_CODE_INDEX")
	private String barreCode;
	
	@Enumerated(EnumType.STRING)
	private OFStatus status;
	public enum OFStatus{
		wating,onProduction,charged,notcharged,end,blocked,inpreparation
	}
	
	private User responsible;
	@Column(name="ELMO_START",length=255)
	private Date startDate;
	@Column(name="ELMO_DUE",length=255)
	private Date dueDate;
	@Column(name="ELMO_END",length=255)
	private Date endDate;
	@Column(name="ELMO_PROVSIONALSTART",length=255)
	private Date provisionalStartDate;
	@Column(name="ELMO_PROVSIONALDUE",length=255)
	private Date provisionalDueDate;
	@Column(name="ELMO_SUBCONSTRUCTOR")
	private Company subconstructor;
	@Column(name="ELMO_TYPE",length=255)
	private Boolean type;
	@Column(name="ELMO_EXECUTEDQT")
	private Integer executedQT;
	@Column(name="ELMO_LANCHEDQT")
	private Integer lanchedQT;
	@Column(name="ELMO_REQUEREDQT")
	private Integer requeredQT;
	@Column(name="ELMO_TEAM")
	private String team;
	@Enumerated(EnumType.STRING)
	private OFPRIORITY priority;
	public enum OFPRIORITY {
		Urgent,Low,Emergency,Medium,High,Critical
	}
	
	@ManyToOne
	 @JoinColumn(name="ELMO_PRODUCT_ID" , nullable=false)
	 private Product product;
	
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
	
	public String generateReference(){
		String ref="";
		ref=ref.concat(PREFIX_REF_OF);
		ref=ref.concat(String.valueOf(this.getId()));
		ref=ref.concat("-");
		ref=ref.concat(String.valueOf(this.getCreateDate().getTime()));
		this.setRef(ref);
	return ref;}	
	
}
