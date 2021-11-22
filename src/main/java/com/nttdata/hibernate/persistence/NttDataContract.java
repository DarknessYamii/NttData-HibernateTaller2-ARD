package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * HIBERNATE - TALLER 2
 * 
 * ENTITY OF TABLE NTTDATA_CONTRACT
 * 
 * @author DarknessYamii
 *
 */

@Entity
@Table(name = "NTTDATA_CONTRACT")
public class NttDataContract extends AbstractEntity implements Serializable {


	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identify (PK) */
	private Long contractId;

	/** Effective Date */
	private Date effectiveDate;

	/** Date of Expiry */
	private Date expiryDate;

	/** Salary */
	private String salary;

	/** Associate Client */
	private NttDataClient client;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getContractId() {
		return contractId;
	}

	/**
	 * 
	 * @param contractId the contractId to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * 
	 * @return the effectiveDate
	 */
	@Column(name = "EFFECTIVE_DATE", nullable = false)
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * 
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}


	/**
	 * 
	 * @return the expiryDate
	 */
	@Column(name = "EXPIRY_DATE", nullable = false)
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * 
	 * @param expiryDate
	 * 		the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * 
	 * @return the salary
	 */
	@Column(name = "SALARY", nullable = false)
	public String getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
	/**
	 * @return the client
	 */
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
	public NttDataClient getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the player to set
	 */
	public void setClient(NttDataClient client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "NttDataContract [contractId=" + contractId + ", salary=" + salary + ", client=" + client + "]";
	}
	@Transient
	public Class<?> getClase() {
		return NttDataContract.class;
	}

}
