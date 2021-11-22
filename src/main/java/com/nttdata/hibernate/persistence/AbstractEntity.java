package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 
 * HIBERNATE - TALLER 2
 * 
 * ABSTRACT ENTITY
 * 
 * @author DarknessYamii
 *
 */

@MappedSuperclass
public abstract class AbstractEntity implements Serializable{

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;
	
	/** Usuario who update */
	private String updatedUser;
	
	/** Day updated */
	private Date updatedDate;
	
	
	/**
	 * @return the updatedUser
	 */

	@Column(name = "AUDIT_UPDATE_USER", nullable = false)
	public String getUpdatedUser()
	{
		return updatedUser;
	}
	
	/**
	 * @param updatedUser
	 * 			the updateUser to set
	 */

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
		}

	/**
	 * @return the updateDate
	 */

	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	
	/**
	 * @param updatedDate
	 * 	the updatedDate to set
	 */

	
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}


