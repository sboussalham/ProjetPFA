package com.soufiane.spring.service;

import java.util.Collection;

import com.soufiane.spring.dao.IDao;

public class ServiceImpl implements IService {
	private IDao dao;

	public ServiceImpl(IDao dao) {
		super();
		this.dao = dao;
	}

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void init()
	{
		dao.init();
	}
	
	@Override
	public synchronized Collection<Personne> getAll(){
		return dao.getAll();
	}
}
