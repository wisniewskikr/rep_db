package pl.kwi.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import pl.kwi.db.jpa.AbstractDao;
import pl.kwi.entities.NameEntity;

@Stateless
public class NameDao extends AbstractDao<NameEntity> {
	
	public NameDao() {
		setClazz(NameEntity.class);
	}
	
	public NameDao(EntityManager em){
		super(em);
		setClazz(NameEntity.class);
	}
	
}
