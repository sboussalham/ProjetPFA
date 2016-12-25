package com.soufiane.spring.dao;

import java.util.ArrayList;
import java.util.Collection;

import com.soufiane.spring.service.Personne;

public class DaoImplList implements IDao{

	ArrayList<Personne> personnes = new ArrayList<>();
	@Override
	public void init() {
		Personne p1 = new Personne(1, "Alami", "Fouad");
		Personne p2 = new Personne(1, "Ben", "Samir");
		Personne p3 = new Personne(1, "Kadiri", "Azoz");	
		personnes.add(p1);
		personnes.add(p2);
		personnes.add(p3);
	}

	@Override
	public Collection<Personne> getAll() {
		return personnes;
	}

}
