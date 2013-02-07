package pl.kwi.db.jdbc;

import java.sql.Connection;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	
	
	public final static String PROPS_MAIN_FILE_NAME = "project.properties";
	public final static String PROP_MAIN_DATASOURCE = "main.db.datasource.jndi";
	private static Properties props;
	
	
	static {
		
		try {
			props = new Properties();
			props.load(JdbcUtil.class.getResourceAsStream("/" + PROPS_MAIN_FILE_NAME));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static JdbcTransManagement beginTransaction(){
		
		JdbcTransManagement management = new JdbcTransManagement();
		
		try {
			openConnection(management);
		} catch (Exception e) {
			management.addException(e);
		}
		
		return management;
	}
	
	public static void finishTransaction(JdbcTransManagement management) {
		
		if(management.isException()){
			rollbackConnection(management);
		}else {
			commitConnection(management);
		}
		
		closeConnection(management);		
	}
	
	// ************************************************************************************************************ //
	// *********************************************** HELP METHODS *********************************************** //
	// ************************************************************************************************************ //
	
	private static void openConnection(JdbcTransManagement management) throws Exception{
				
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx
		    .lookup(props.getProperty(PROP_MAIN_DATASOURCE));
		Connection conn = ds.getConnection();
		conn.setAutoCommit(false);
		management.setConn(conn);
		
		
	}
	
	private static void commitConnection(JdbcTransManagement management){
		try {
			management.getConn().commit();
		} catch (Exception e) {
			management.addException(e);
		}
	}
	
	private static void rollbackConnection(JdbcTransManagement management){
		try {
			management.getConn().rollback();
		} catch (Exception e) {
			management.addException(e);
		}
	}
	
	private static void closeConnection(JdbcTransManagement management){
		try {
			if(management.getConn() != null){
				management.getConn().close();
			}
		} catch (Exception e) {
			management.addException(e);
		}
	}
	
}
