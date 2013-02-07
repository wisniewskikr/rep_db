package pl.kwi.daos;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import pl.kwi.db.jpa.AbstractDao;
import pl.kwi.entities.SurnameEntity;

@Repository
public class SurnameDao extends AbstractDao<SurnameEntity> {
	
	public SurnameDao() {
		setClazz(SurnameEntity.class);
	}
	
	public SurnameDao(EntityManager em){
		super(em);
		setClazz(SurnameEntity.class);
	}
	
}
