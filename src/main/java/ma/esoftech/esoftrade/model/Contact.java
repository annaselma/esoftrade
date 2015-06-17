package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ELMO_CONTACT")
public class Contact extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ELMO_STATUT")
	private boolean statut;

	@Column(name = "ELMO_LAST_NAME", length = 255, nullable = false)
	private String lastName;

	
	@Column(name = "ELMO_JOB", length = 255)
	private String job;
	
	@Column(name = "ELMO_TYPE", length = 255)
	private String type;

	@ManyToOne
	 @JoinColumn(name="ELMO_COMPANY_ID")
	private Company company;
	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	


	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Contact() {
	}

}
