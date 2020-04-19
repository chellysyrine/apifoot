package com.example.Apifoot.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Apifoot.model.Equipe;
import com.example.Apifoot.repository.EquipeRepository;


@Service
public class ImplEquipeService implements equipeservice {

	@Autowired 
	EquipeRepository erepos;
	
	@Override
	public Equipe saveEquipe(Equipe equipe) {
		// TODO Auto-generated method stub
		return  erepos.save(equipe);
	}

	@Override
	public List<Equipe> findAllEquipes() {
		// TODO Auto-generated method stub
		return erepos.findAll();
	}


	
	
	
}
