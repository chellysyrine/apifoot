package com.example.Apifoot.repository;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Apifoot.model.Joueur;

public interface JoueurRepository  extends JpaRepository <Joueur , Long >{
	Page<Joueur> findByEquipeId(Long equipeId, Pageable pageable);
    Optional<Joueur> findByIdAndEquipeId(Long id, Long equipeId);
}
