package com.nttdata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * HIBERNATE - TALLER 2 DAO GENERICO
 * 
 * @author DarknessYamii
 *
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Type of class */
	private Class<T> entityClass;

	/** Session Connection to the BBDD */
	private Session session;

	/**
	 * Constructor method
	 * 
	 * @param session
	 *
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(T paramT) {

		// Verify if session is working
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insertion
		session.save(paramT);
		session.flush();

		// Commit
		session.getTransaction().commit();

	}

	@Override
	public void update(T paramT) {
		// Verify if session is working
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insertion
		session.saveOrUpdate(paramT);

		// Commit
		session.getTransaction().commit();

	}

	@Override
	public void delete(T paramT) {
		// Verify if session is working
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insertion
		session.delete(paramT);

		// Commit
		session.getTransaction().commit();

	}

	@Override
	public T searchById(Long ID) {
		// Verify if session is working
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Search by ID (PK)
		T result = session.get(this.entityClass, ID);

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {
		// Verify if session is working
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Search every row
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();
		return list;
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
