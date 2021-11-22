package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * 
 * HIBERNATE - TALLER 2
 * 
 * DAO TABLE NTTDATA_CONTRACT
 * 
 * @author DarknessYamii
 *
 */
public class NttDataContractDaoImpl extends CommonDaoImpl<NttDataContract> implements NttDataContractDaoI{

	/** Conexion Session to BBDD */
	private Session session;
	
	/**
	 * CONSTRUCTOR METHOD
	 */
	public NttDataContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<NttDataContract> searchByIdContract(final int ID) {
		
		// Verify open session.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Get contract by ID .
		final List<NttDataContract> contractList = session
				.createQuery("FROM NttDataContract WHERE client.ID ='"+ID+"'").list();
		
		// Result.

		return contractList;
	}

	@Override
	public List<NttDataContract> searchBySalaryAndName(final String salary, final String name) {
		
		// Consult
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NttDataContract> cquery = cb.createQuery(NttDataContract.class);
		final Root<NttDataContract> rootC = cquery.from(NttDataContract.class);
		final Join<NttDataContract, NttDataClient> pJoinC = rootC.join("client");
		
		// Where
		final Predicate pr1 = cb.like(pJoinC.<String> get("name"), name);
		final Predicate pr2 = cb.gt(pJoinC.getParent().<String> get("salary").as(Double.class), Double.valueOf(salary));
		
		// Consult
		cquery.select(rootC).where(cb.and(pr1, pr2));
		
		// Order by desc depending on salary
		cquery.orderBy(cb.desc(pJoinC.getParent().<String> get("salary")));
		
		// Consult execution
		final List<NttDataContract> results = session.createQuery(cquery).getResultList();
		
		return results;
	}
	
	
	
	
}
