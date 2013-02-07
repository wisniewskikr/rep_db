package pl.kwi.db.jpa;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {
	
	
	public final static String PROPS_MAIN_FILE_NAME = "project.properties";
	public final static String PROP_MAIN_PERSISTENCE_UNIT = "main.persistence-unit";
	private static Properties props;
	
	
	static {
		
		try {
			props = new Properties();
			props.load(JpaUtil.class.getResourceAsStream("/" + PROPS_MAIN_FILE_NAME));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static JpaTransManagement beginTransaction() {
		
		JpaTransManagement management = new JpaTransManagement();
		
		try {
			
			openEntityManager(management);
			openTransaction(management);
			
		} catch (Exception e) {
			management.addException(e);
		}
		
		return management;
		
	}
	
	public static void finishTransaction(JpaTransManagement management) {
		
		try {
			
			if(management.isException()){
				rollbackEntityTransaction(management);
			}else {
				commitEntityTransaction(management);
			}
			
			closeEntityManager(management);
			
		} catch (Exception e) {
			management.addException(e);
		}
	
	}
	
	
	// ************************************************************************************************************ //
	// *********************************************** HELP METHODS *********************************************** //
	// ************************************************************************************************************ //
	
	
	private static void openEntityManager(JpaTransManagement management) {
		
		String persistenceUnitName = props.getProperty(PROP_MAIN_PERSISTENCE_UNIT);
		EntityManager em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
		management.setEm(em);
		
	}
	
	private static void closeEntityManager(JpaTransManagement management) {
		
		EntityManager em = management.getEm();
		em.close();
		
	}
	
	private static void openTransaction(JpaTransManagement management) {
		
		try {
			EntityManager em = management.getEm(); 
			
			EntityTransaction tx = em.getTransaction();
			 tx.begin();
			 
			 management.setTx(tx);
			 
		} catch (Exception e) {
			management.addException(e);
		}
		
	}
	
	private static void commitEntityTransaction(JpaTransManagement management){
		
		EntityTransaction tx = management.getTx();
		
		try {
			
			tx.commit();
			
		} catch (Exception e) {
			management.addException(e);
			
			try {				
				tx.rollback();
			} catch (Exception e2) {
				management.addException(e2);
			}
			
		}
		
	}
	
	private static void rollbackEntityTransaction(JpaTransManagement management){
		
		try {
			EntityTransaction tx = management.getTx();
			tx.rollback();
		} catch (Exception e) {
			management.addException(e);
		}
		
	}
	
	
}
