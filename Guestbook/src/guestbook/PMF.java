package guestbook;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * The PersistanceManagerFactory, which is a singleton
 * 
 * Google:
 * A PersistenceManagerFactory instance takes time to initialize. Thankfully,
 * you only need one instance for your application, and this instance can be
 * stored in a static variable to be used by multiple requests and multiple
 * classes. An easy way to do this is to create a singleton wrapper class for
 * the static instance
 * 
 * @author Wouter M. Everse
 */
public final class PMF {
	private static final PersistenceManagerFactory pmfInstance = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

	/** Singleton has private constructor */
	private PMF() {
	}

	public static PersistenceManagerFactory get() {
		return pmfInstance;
	}
}