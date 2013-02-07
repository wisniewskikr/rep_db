package pl.kwi.daos;

import org.springframework.stereotype.Repository;

import pl.kwi.db.spring.AbstractDao;
import pl.kwi.entities.NameEntity;

@Repository
public class NameDao extends AbstractDao<NameEntity> {
	
	
	public NameDao(){
		setClazz(NameEntity.class);		
	}
	
}
