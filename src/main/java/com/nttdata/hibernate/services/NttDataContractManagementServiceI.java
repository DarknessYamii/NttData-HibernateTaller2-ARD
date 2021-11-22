package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NttDataContract;
/**
 * HIBERNATE - TALLER 2
 * 
 * Interface of service Contract
 * 
 * @author DarknessYamii
 *
 */
public interface NttDataContractManagementServiceI {

	/**
	 * Insert new contract.
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final NttDataContract newContract);

	/**
	 * Update an existent contract.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final NttDataContract updatedContract);

	/**
	 * Delete an existent contract
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final NttDataContract deletedContract);

	/**
	 * Get values by ID
	 * 
	 * @param contractId
	 */
	public NttDataContract searchById(final Long contractId);

	
	/**
	 * Get contracts by clientId
	 * @param clientId
	 * @return
	 */
	public List<NttDataContract> searchByIdClient(final int clientId);
	/**
	 * Get every contract.
	 * 
	 * @return List<NttDataContract>
	 */
	public List<NttDataContract> searchAll();
	
	/**
	 * Get Salary and Client by ID
	 * @param salary
	 * @param ID
	 * @return List<NttDataContract>
	 */
	public List<NttDataContract> searchBySalaryAndName(final String salary, final String name);
}


