package com.soufiane.spring.dao;

import java.util.Collection;

import com.soufiane.spring.service.Personne;

public interface IDao {
	void init();
	Collection<Personne> getAll();
}
