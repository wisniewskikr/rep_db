package pl.kwi.services;

import javax.persistence.EntityManager;

import pl.kwi.daos.SurnameDao;
import pl.kwi.entities.SurnameEntity;


public class SurnameService {
	
	private SurnameDao dao;
	
	public SurnameService(EntityManager em){
		dao = new SurnameDao(em);
	}
	
	public void createSurname(SurnameEntity surname) throws Exception{
		dao.create(surname);
	}
	
	public SurnameEntity readSurname(Long id) throws Exception{
		return dao.read(id);
	}
	
	public void updateSurname(SurnameEntity surname) throws Exception{
		dao.update(surname);
	}
	
	public void deleteSurname(Long id) throws Exception{
		dao.delete(id, SurnameEntity.class);
	}

}
