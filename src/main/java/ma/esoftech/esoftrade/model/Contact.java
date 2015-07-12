package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ma.esoftech.esoftrade.model.Company.ThirdStatus;

@Entity
@Table(name = "ELMO_CONTACT")
public class Contact extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Column(name = "ELMO_LAST_NAME", length = 255, nullable = false)
	private String lastName;

	
	@Column(name = "ELMO_JOB", length = 255)
	private String job;
	
	@Column(name = "ELMO_STATUS", length = 255)
	@Enumerated(EnumType.STRING)
	private ThirdStatus status;

	@ManyToOne
	 @JoinColumn(name="ELMO_COMPANY_ID")
	private Company company;
	
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



	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	

	public ThirdStatus getStatus() {
		return status;
	}

	public void setStatus(ThirdStatus status) {
		this.status = status;
	}

	public Contact() {
	}

}
