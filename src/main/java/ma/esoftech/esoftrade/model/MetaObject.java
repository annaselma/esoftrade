package ma.esoftech.esoftrade.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ELMO_MetaObject")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class MetaObject implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	@Column(name="ELMO_ID",nullable= false, unique=true)
	private long  id;
	@Column(name="ELMO_CREATE_DATE",nullable= false)
	private Date createDate;
	@Column(name="ELMO_DELETED",nullable= false)
	private boolean deleted=false;
	@Column(name="ELMO_LAST_EDIT",nullable= false)
	private Date lastEdit;
	@ManyToOne
	@JoinColumn(name="ELMO_CREATOR_ID")
	private Owner creator;
	@ManyToOne
	@JoinColumn(name="ELMO_MODIFIER_ID")
	private Owner modifier;
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
	public Owner getCreator() {
		return creator;
	}
	public void setCreator(Owner creator) {
		this.creator = creator;
	}
	public Owner getModifier() {
		return modifier;
	}
	public void setModifier(Owner modifier) {
		this.modifier = modifier;
	}
	
}
