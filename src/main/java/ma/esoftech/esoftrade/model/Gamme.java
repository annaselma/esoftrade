package ma.esoftech.esoftrade.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
@Entity
@Table(name="ELMO_GAMME")
public class Gamme extends MetaObject{
	private final static String PREFIX_REF_G="GA";
	private static final long serialVersionUID = 1L;
     
	@Column(name="ELMO_REF", nullable= false,unique=true,length= 255)
	@Index(name="ELMO_REF_INDEX")
	 private String ref;
	@Column(name="ELMO_DESIGNATION",length=255)
	private String designation;
	@Column(name="ELMO_DESCRIPTION",length=255)
	private String description;
	@Column(name="ELMO_BARRECODE",length=255)
	@Index(name="ELMO_CODE_INDEX")
	private String barreCode;
	@Column(name="ELMO_PROVISIONAL_STARTDATE")
	private Date provisionalStartDate;
	@Column(name="ELMO_PROVISIONAL_ENDATE")
	private Date provisionalEndDate;
	@Column(name="ELMO_OBSERVATION",length=255)
	private String observation;
	@Column(name="ELMO_STARTDATE")
	private Date startDate;
	@Column(name="ELMO_ENDATE")
	private Date endDate;
	@Column(name="ELMO_WAITINGPIECES")
	private Integer waitingPrieces;
	@Column(name="ELMO_REJECTEDPIECES")
	private Integer rejectedQt;
	@Column(name="ELMO_CREATEDPIECES")
	private Integer createdQt;
	@Column(name="ELMO_NBPOSTE")
    private Integer nbposte;
    @Column(name="ELMO_TYPE",length=255)
	private String type;
    @Column(name="ELMO_END")
	private boolean end;
    @Column(name="ELMO_TIME")
	private Integer time;
	@ManyToOne
	@JoinColumn(name="ELMO_POST_ID")
	private Poste poste;
    @OneToMany
    @JoinTable(
        name="ELMO_GAMME_FILE",
        joinColumns = @JoinColumn( name="ELMO_GAMME_ID"),
        inverseJoinColumns = @JoinColumn( name="ELMO_FILE_ID")
    )private Set<File> files=new HashSet<File>();
    
   
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

	public Set<File> getFiles() {
		return files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}

	public Integer getWaitingPrieces() {
		return waitingPrieces;
	}

	public void setWaitingPrieces(Integer waitingPrieces) {
		this.waitingPrieces = waitingPrieces;
	}

	public String isType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Gamme() {
		super();
	}
	
	public boolean isEnd() {
		return end;
	}

	public Integer getNbposte() {
		return nbposte;
	}

	public void setNbposte(Integer nbposte) {
		this.nbposte = nbposte;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getType() {
		return type;
	}




	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public String generateReference(){
    	String ref="";
    	ref=ref.concat(PREFIX_REF_G);
    	ref=ref.concat(String.valueOf(this.getId()));
    	ref=ref.concat("-");
    	ref=ref.concat(String.valueOf(this.getCreateDate().getTime()));
    	this.setRef(ref);
    return ref;}	
}
