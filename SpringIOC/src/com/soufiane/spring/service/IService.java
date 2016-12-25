package com.soufiane.spring.service;

import java.util.Collection;

public interface IService {
	void init();
	Collection<Personne> getAll();
}
