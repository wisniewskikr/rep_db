package pl.kwi.db.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDaoUsers<T extends AbstractEntity> {
	
	
	@PersistenceContext(unitName="pu_users")
	private EntityManager em;
	private Class<T> clazz;
		
		
	public AbstractDaoUsers(){}
	
	public AbstractDaoUsers(EntityManager em) {
		this.em = em;
	}

	public void setClazz(final Class<T> clazz) {
		this.clazz = clazz;
	}

	public Long create(T entity) {		
		em.persist(entity);
		return entity.getId();
	}
	
	public T read(Long id){
		return em.find(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<? extends AbstractEntity> readAll(){
		
		return em.createQuery( "from " +  clazz.getName())
			       .getResultList();
	}
	
	public T update(T entity){		
		return em.merge(entity);
	}
	
	public void delete(T entity){
		entity = em.merge(entity);
		em.remove(entity);
	}
	
	public void delete(Long id, Class<? extends AbstractEntity> entityClass) {
		T entity = read(id);
		delete(entity);
	}
	
	
	// **************************************** //
	// *********** GETTERS AND SETTERS ******** //
	// **************************************** //
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}	

}
