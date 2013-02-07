package pl.kwi.db.jpa;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTransManagement {
	
	
	private EntityManager em;
	private EntityTransaction tx;
	private List<Exception> exceptions = new ArrayList<Exception>();
	
	
	public void addException(Exception e){
		exceptions.add(e);
	}
	
	public boolean isException(){
		
		boolean result = false;
		
		if(!exceptions.isEmpty()){
			result = true;
		}
		
		return result;
		
	}
	
	public Exception crateJoinedException() {
		
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    for (Exception exception : exceptions) {
	    	exception.printStackTrace(pw);
		}	    
	    pw.close();
	    return new Exception(sw.toString());
		
	}
	
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public EntityTransaction getTx() {
		return tx;
	}
	public void setTx(EntityTransaction tx) {
		this.tx = tx;
	}
		

}
