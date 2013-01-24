package pl.kwi.services;

import pl.kwi.daos.NameDao;
import pl.kwi.entities.NameEntity;


public class NameService {
	
	private NameDao dao;
	
	public NameService(){
		dao = new NameDao(null);
	}
	
	public void createName(NameEntity name) throws Exception{
		dao.createName(name);
	}
	
	public NameEntity readName(Long id) throws Exception{
		return dao.readName(id);
	}
	
	public void updateName(NameEntity name) throws Exception{
		dao.updateName(name);
	}
	
	public void deleteName(Long id) throws Exception{
		dao.deleteName(id);
	}

}
