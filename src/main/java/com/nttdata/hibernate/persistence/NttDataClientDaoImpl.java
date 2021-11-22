package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * HIBERNATE - TALLER 2
 * 
 * DAO of table NTTDATA_CLIENT
 * 
 * @author DarknessYamii
 *
 */
public class NttDataClientDaoImpl extends CommonDaoImpl<NttDataClient> implements NttDataClientDaoI {

	/** Session Connection BBDD */
	private Session session;

	/**
	 * Constructor Method
	 */
	public NttDataClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<NttDataClient> searchByNameAndFirstName(final String name, final String firstName) {
		// Verify if session is working
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		// Get every client with name and firstName
		final List<NttDataClient> clientList = session.createQuery("FROM NttDataClient WHERE name LIKE '" + name	+"' AND firstName LIKE '" +firstName + "'").list();
		return clientList;
	}

	/** Criteria Consult */
	@Override
	public List<NttDataClient> searchByName(final String name) {
		
		// Consult
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NttDataClient> cquery = cb.createQuery(NttDataClient.class);
		final Root <NttDataClient> rootC = cquery.from(NttDataClient.class);
		
		// Where
		final Predicate pr1 = cb.like(rootC.<String> get("name"),name);

		// Consult
		cquery.select(rootC).where(cb.and(pr1));
			
		// Execute consult
		final List<NttDataClient> result = session.createQuery(cquery).getResultList();
		System.out.println("Nombres por " + name);
		return result;
	}

	
	
	
}
