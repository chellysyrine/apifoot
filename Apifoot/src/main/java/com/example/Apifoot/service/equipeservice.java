package com.example.Apifoot.service;

import java.util.List;

import com.example.Apifoot.model.*;;

public interface equipeservice {

	Equipe saveEquipe(Equipe equipe);

	List<Equipe> findAllEquipes();


}