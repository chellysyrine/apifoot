package com.example.Apifoot.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "joueurs")
public class Joueur  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @NotNull
  @Lob
  private String nom;
  
  @NotNull
  @Lob
  private String prenom;
  
  @NotNull
  @Lob
  private String position;
  

  @ManyToOne(fetch = FetchType.LAZY)
//   @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "equipe_id", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
//   @OnDelete(action = OnDeleteAction.CASCADE)
//   @JsonIgnore
  private Equipe equipe;


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public String getPosition() {
	return position;
}


public void setPosition(String position) {
	this.position = position;
}


public Equipe getEquipe() {
	return equipe;
}


public void setEquipe(Equipe equipe) {
	this.equipe = equipe;
}


public String getPrenom() {
	return prenom;
}


public void setPrenom(String prenom) {
	this.prenom = prenom;
}

  
  
  
 
  
  
}