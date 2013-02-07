package pl.kwi.services;

import javax.persistence.EntityManager;

import pl.kwi.daos.NameDao;
import pl.kwi.entities.NameEntity;


public class NameService {
	
	private NameDao dao;
	
	public NameService(EntityManager em){
		dao = new NameDao(em);
	}
	
	public void createName(NameEntity name) throws Exception{
		dao.create(name);
	}
	
	public NameEntity readName(Long id) throws Exception{
		return dao.read(id);
	}
	
	public void updateName(NameEntity name) throws Exception{
		dao.update(name);
	}
	
	public void deleteName(Long id) throws Exception{
		dao.delete(id, NameEntity.class);
	}

}
