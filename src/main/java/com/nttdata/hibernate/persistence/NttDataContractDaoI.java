package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * HIBERNATE - TALLER 2
 * 
 * DAO TABLE NTTDATA_CONTRACT
 * 
 * @author DarknessYamii
 *
 */

public interface NttDataContractDaoI extends CommonDaoI<NttDataContract>{

	/**
	 * 	Search by clientID every contract setted
	 * @param clientId
	 * @return List<NttDataContract>
	 */
	public List<NttDataContract> searchByIdContract(final int clientId);
	
	/**
	 * Search by Salary every contract and Client
	 * @param salary
	 * @return List<NttDataContract>
	 */
	public List<NttDataContract> searchBySalaryAndName(final String salary, final String name);
	
	
}
