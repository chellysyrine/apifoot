package com.example.Apifoot.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "staffs")
public class Staff  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Lob
  private String type;
  
  @NotNull
  @Lob
  private String description;
  
  

  @ManyToOne(fetch = FetchType.LAZY)
//   @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "equipe_id", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  
//  @OnDelete(action = OnDeleteAction.CASCADE)
//  @JsonIgnore
  private Equipe equipe;



public String getType() {
	return type;
}



public void setType(String type) {
	this.type = type;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public Equipe getEquipe() {
	return equipe;
}



public void setEquipe(Equipe equipe) {
	this.equipe = equipe;
}
  
  
  
}