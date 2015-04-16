package ma.esoftech.esoftrade.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MetaObject implements Serializable {
	private static final long serialVersionUID = 1L;

	public MetaObject() {
		this.init();	    
	}
 

	@TableGenerator(name = "ELMO_GEN", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ELMO_GEN")
	@Column(name = "ELMO_ID", nullable = false, unique = true)
	private long id;
	@Column(name = "ELMO_CREATE_DATE")
	private Date createDate;
	@Column(name = "ELMO_DELETED")
	private boolean deleted = false;
	@Column(name = "ELMO_LAST_EDIT")
	private Date lastEdit;
	@ManyToOne
	@JoinColumn(name = "ELMO_CREATOR_ID")
	private User creator;
	@ManyToOne
	@JoinColumn(name = "ELMO_MODIFIER_ID")
	private User modifier;

	
	
	private void init(){
		 this.createDate=new Date();
	     this.lastEdit=new Date();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getLastEdit() {
		return lastEdit;
	}

	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getModifier() {
		return modifier;
	}

	public void setModifier(User modifier) {
		this.modifier = modifier;
	}

}
