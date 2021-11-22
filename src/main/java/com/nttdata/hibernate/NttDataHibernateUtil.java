package com.nttdata.hibernate;
/**
 * HIBERNATE - TALLER 1
 * 
 * Class config
 * 
 * @author DarknessYamii
 *
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NttDataHibernateUtil {

	/** Sessions Factory */
	private static final SessionFactory SESSION_FACTORY;
	
	/** Generation of session factory */
	
	static {
		
		try {
			
			// Generation of config
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
			
		}catch (final Throwable ex) {
			
			// Error of init
			System.err.println("[ERROR] Configuracion de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}
	}
	
	/**
	 * Returns session factory
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
