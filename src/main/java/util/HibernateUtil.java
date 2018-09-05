package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Class to bridge the hibernate.cfg.xml file to the connection to the database.
 * 
 * @author Baracho
 * 
 * @since July 19, 2018
 *
 * @version 1.0
 *
 */
public class HibernateUtil {

	/**
	 * Static variables
	 */

	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * 
	 */
	public HibernateUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Class operations
	 */

	private static SessionFactory buildSessionFactory() {

		try {

			Configuration config = new Configuration();

			config.configure("hibernate.cfg.xml");

			StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();

			standardServiceRegistryBuilder.applySettings(config.getProperties());

			StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.build();

			return config.buildSessionFactory(standardServiceRegistry);

		} catch (Throwable e) {
			// TODO: handle exception

			System.err.println("\n Initial creation of the SessioFactory object failed. Error: " + e.getMessage());

			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}