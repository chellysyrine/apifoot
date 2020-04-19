package com.example.Apifoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Apifoot.model.Joueur;
import com.example.Apifoot.repository.JoueurRepository;

public class ImplJoueurService implements JoueurService {

@Autowired 
 
JoueurRepository jrepos;
	
	
	@Override
	public Joueur saveJoueur(Joueur joueur) {
		// TODO Auto-generated method stub
		return jrepos.save(joueur);
	}

	@Override
	public List<Joueur> findAllJoueurs() {
		// TODO Auto-generated method stub
		return jrepos.findAll();
	}

}
