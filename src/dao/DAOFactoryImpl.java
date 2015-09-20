package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactoryImpl {

	
	private static final String PERSISTENCE_NAME       = "news";
	private EntityManagerFactory factory ;
	EntityManager em ;
	
	DAOFactoryImpl(){
		factory = Persistence.createEntityManagerFactory( PERSISTENCE_NAME);
		em = factory.createEntityManager();
	}
	
	public EntityManager getEntityManager(){
		return em ;
	}
	
	
}
