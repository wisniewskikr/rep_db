package pl.kwi.daos;

import org.springframework.stereotype.Repository;

import pl.kwi.db.spring.AbstractDao;
import pl.kwi.entities.SurnameEntity;

@Repository
public class SurnameDao extends AbstractDao<SurnameEntity> {
	
	
	public SurnameDao(){
		setClazz(SurnameEntity.class);		
	}
	
}
