package pl.kwi.services;

import pl.kwi.daos.SurnameDao;
import pl.kwi.entities.SurnameEntity;


public class SurnameService {
	
	private SurnameDao dao;
	
	public SurnameService(){
		dao = new SurnameDao(null);
	}
	
	public void createSurname(SurnameEntity surname) throws Exception{
		dao.createSurname(surname);
	}
	
	public SurnameEntity readSurname(Long id) throws Exception{
		return dao.readSurname(id);
	}
	
	public void updateSurname(SurnameEntity surname) throws Exception{
		dao.updateSurname(surname);
	}
	
	public void deleteSurname(Long id) throws Exception{
		dao.deleteSurname(id);
	}

}
