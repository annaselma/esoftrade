package ma.esoftech.esoftrade.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name="ELMO_THEOTICALCOST")
	private float theocticalCost;
	@Column(name="ELMO_REALCOST")
	private float realCost;
	@Column(name="ELMO_WAITINGPIECES")
	private Integer waitingPrieces;
	@Column(name="ELMO_CREATEDQT")
	private Integer createdQT;
	private Set<User>workedPerson;
	private boolean type;
}
