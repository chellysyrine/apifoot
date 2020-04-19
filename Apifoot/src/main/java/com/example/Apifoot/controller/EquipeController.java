package com.example.Apifoot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Apifoot.exception.ResourceNotFoundException;
import com.example.Apifoot.model.Equipe;
import com.example.Apifoot.repository.EquipeRepository;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping("/equipes")
    public Page<Equipe> getAllEquipes(Pageable pageable) {
        return equipeRepository.findAll(pageable);
    }
    @GetMapping("/equipes/{id}")
    public ResponseEntity<Equipe> getEmployeeById(@PathVariable(value = "id") Long equipeId)
        throws ResourceNotFoundException {
        Equipe equipe = equipeRepository.findById(equipeId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + equipeId));
        return ResponseEntity.ok().body(equipe);
    }

    @PostMapping("/equipes")
    public Equipe createEquipe(@Valid @RequestBody Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @PutMapping("/equipes/{equipeId}")
    public Equipe updateEquipe(@PathVariable Long equipeId, @Valid @RequestBody Equipe equipeRequest) {
        return equipeRepository.findById(equipeId).map(equipe -> {
            equipe.setPays(equipeRequest.getPays());
            equipe.setDescription(equipeRequest.getDescription());
        
            return equipeRepository.save(equipe);
        }).orElseThrow(() -> new ResourceNotFoundException("EquipeId " + equipeId + " not found"));
    }


    @DeleteMapping("/equipes/{equipeId}")
    public ResponseEntity<?> deleteEquipe(@PathVariable Long equipeId) {
        return equipeRepository.findById(equipeId).map(equipe -> {
            equipeRepository.delete(equipe);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("EquipeId " + equipeId + " not found"));
    }

}