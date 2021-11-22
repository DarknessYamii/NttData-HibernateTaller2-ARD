package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * HIBERNATE - TALLER 2
 * 
 * DAO GENERICO
 * 
 * @author DarknessYamii
 *
 * @param <T>
 */

public interface CommonDaoI<T> {

	/**
	 * Insert new row in BBDD
	 * @param paramT
	 * 	 */
	public void insert(final T paramT);
	
	/**
	 * Update one row in BBDD
	 * @param paramT
	 */

	public void update(final T paramT);
	
	/**
	 * Delete a row in BBDD
	 * @param paramT
	 */

	public void delete(final T paramT);
	
	/**
	 * Seach a row by ID in BBDD
	 * @param paramT
	 */

	public T searchById(final Long ID);

	
	/**
	 * Search every row in BBDD
	 * @return List<T>
	 */

	public List<T> searchAll();

}

