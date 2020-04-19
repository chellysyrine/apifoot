package com.example.Apifoot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Apifoot.exception.ResourceNotFoundException;
import com.example.Apifoot.model.Joueur;
import com.example.Apifoot.repository.EquipeRepository;
import com.example.Apifoot.repository.JoueurRepository;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class JoueurController {

    @Autowired
    private JoueurRepository joueurRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping("/equipes/{equipeId}/joueurs")
    public Page<Joueur> getAllJoueursByEquipeId(@PathVariable (value = "equipeId") Long equipeId,
                                                Pageable pageable) {
        return joueurRepository.findByEquipeId(equipeId, pageable);
    }

    @PostMapping("/equipes/{equipeId}/joueurs")
    public Joueur createJoueur(@PathVariable (value = "equipeId") Long equipeId,
                                 @Valid @RequestBody Joueur joueur) {
        return equipeRepository.findById(equipeId).map(equipe -> {
            joueur.setEquipe(equipe);
            return joueurRepository.save(joueur);
        }).orElseThrow(() -> new ResourceNotFoundException("EquipeId " + equipeId + " not found"));
    }

    @PutMapping("/equipes/{equipeId}/joueurs/{joueurId}")
    public Joueur updateJoueur(@PathVariable (value = "equipeId") Long equipeId,
                                 @PathVariable (value = "joueurId") Long joueurId,
                                 @Valid @RequestBody Joueur joueurRequest) {
        if(!equipeRepository.existsById(equipeId)) {
            throw new ResourceNotFoundException("EquipeId " + equipeId + " not found");
        }

        return joueurRepository.findById(joueurId).map(joueur -> {
            joueur.setNom(joueurRequest.getNom());
            joueur.setPrenom(joueurRequest.getPrenom());
            joueur.setPosition(joueurRequest.getPosition());
            return joueurRepository.save(joueur);
        }).orElseThrow(() -> new ResourceNotFoundException("JoueurId " + joueurId + "not found"));
    }

    @DeleteMapping("/equipes/{equipeId}/joueurs/{joueurId}")
    public ResponseEntity<?> deleteJoueur(@PathVariable (value = "equipeId") Long equipeId,
                              @PathVariable (value = "joueurId") Long joueurId) {
        return joueurRepository.findByIdAndEquipeId(joueurId, equipeId).map(joueur -> {
            joueurRepository.delete(joueur);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Joueur not found with id " + joueurId + " and equipeId " + equipeId));
    }
}