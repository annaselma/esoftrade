package ma.esoftech.esoftrade.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import ma.esoftech.esoftrade.DTO.associated.EditorDTO;
import ma.esoftech.esoftrade.DTO.associated.FileAssociatedDTO;

public class GammeDTO {

	private long id;
	private EditorDTO creator;
	private Date createDate;
	private EditorDTO modifier;
	private Date lastEdit;
	private String ref;
	private String designation;
	private String description;
	private Integer requeredQt=0;
	private Integer rejectedQt=0;
	private Integer createdQt=0;
	private Integer missingQt=0;
	private float cost;
	private String barreCode;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull
	private Date provisionalStartDate;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull
	private Date provisionalEndDate;
	private String observation;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull
	private Date startDate;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull
	private Date endDate;
	private float theocticalCost;
	private float realCost;
	private Integer waitingPrieces=0;
	private Integer createdQT=0;
	@NotEmpty(message="veillez indiquer au moins un poste")
    private String poste;
    private Integer nbposte=0;
    @NotEmpty(message="choisir un type")
	private String type;
	private boolean end;
	private  List<FileAssociatedDTO> files=new ArrayList<FileAssociatedDTO>();
	public GammeDTO() {
		setStartDate(new Date());
		setEndDate(new Date());
		setProvisionalStartDate(new Date());
		setProvisionalEndDate(new Date());
	}
	
	public List<FileAssociatedDTO> getFiles() {
		return files;
	}
	public void setFiles(List<FileAssociatedDTO> files) {
		this.files = files;
	}
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
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getRequeredQt() {
		return requeredQt;
	}
	public void setRequeredQt(Integer requeredQt) {
		this.requeredQt = requeredQt;
	}
	public Integer getRejectedQt() {
		return rejectedQt;
	}
	public void setRejectedQt(Integer rejectedQt) {
		this.rejectedQt = rejectedQt;
	}
	
	public Integer getCreatedQt() {
		return createdQt;
	}

	public void setCreatedQt(Integer createdQt) {
		this.createdQt = createdQt;
	}

	public Integer getMissingQt() {
		return missingQt;
	}
	public void setMissingQt(Integer missingQt) {
		this.missingQt = missingQt;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getBarreCode() {
		return barreCode;
	}
	public void setBarreCode(String barreCode) {
		this.barreCode = barreCode;
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
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
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
	public float getTheocticalCost() {
		return theocticalCost;
	}
	public void setTheocticalCost(float theocticalCost) {
		this.theocticalCost = theocticalCost;
	}
	public float getRealCost() {
		return realCost;
	}
	public void setRealCost(float realCost) {
		this.realCost = realCost;
	}
	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public Integer getWaitingPrieces() {
		return waitingPrieces;
	}
	public void setWaitingPrieces(Integer waitingPrieces) {
		this.waitingPrieces = waitingPrieces;
	}
	public Integer getCreatedQT() {
		return createdQT;
	}
	public void setCreatedQT(Integer createdQT) {
		this.createdQT = createdQT;
	}
	public String getPoste() {
		return poste;
	}
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNbposte() {
		return nbposte;
	}

	public void setNbposte(Integer nbposte) {
		this.nbposte = nbposte;
	}

	}
		
	