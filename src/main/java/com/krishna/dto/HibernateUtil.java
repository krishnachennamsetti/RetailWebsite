package com.krishna.dto;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author krishnachennamsetti
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * This is a generic method used to build SessionFactory object
	 * @return SessionFactory object
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable exception) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("SessionFactory creation failed." + exception);
			throw new ExceptionInInitializerError(exception);
		}
	}

	/**
	 * Loads session factory object
	 * @return SessionFactory object
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Close caches and connection pools
	 */
	public static void shutdown() {
		getSessionFactory().close();
	}

}
