package com.example.Apifoot.service;

import java.util.List;

import com.example.Apifoot.model.*;;

public interface JoueurService {

	Joueur saveJoueur(Joueur joueur);

	List<Joueur> findAllJoueurs();


}