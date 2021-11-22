package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * HIBERNATE - TALLER 2
 * 
 * DAO of NTTDATA_CLIENT
 * 
 * @author DarknessYamii
 *
 */
public interface NttDataClientDaoI extends CommonDaoI<NttDataClient>  {

	/**
	 * Search by Name and firstName
	 * @param name, firstName
	 * @return List<NttDataClient>
	 */
	
	public List<NttDataClient> searchByNameAndFirstName(final String name, final String firstName);
	
	/**
	 * Search by Name
	 * @param name
	 * @return List<NttDataClient>
	 */
	public List<NttDataClient> searchByName(final String name);


	
}
