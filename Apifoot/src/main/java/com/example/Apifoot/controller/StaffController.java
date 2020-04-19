package com.example.Apifoot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Apifoot.exception.ResourceNotFoundException;
import com.example.Apifoot.model.Staff;
import com.example.Apifoot.repository.EquipeRepository;
import com.example.Apifoot.repository.StaffRepository;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping("/equipes/{equipeId}/staffs")
    public Page<Staff> getAllStaffsByEquipeId(@PathVariable (value = "equipeId") Long equipeId,
                                                Pageable pageable) {
        return staffRepository.findByEquipeId(equipeId, pageable);
    }

    @PostMapping("/equipes/{equipeId}/staffs")
    public Staff createStaff(@PathVariable (value = "equipeId") Long equipeId,
                                 @Valid @RequestBody Staff staff) {
        return equipeRepository.findById(equipeId).map(equipe -> {
            staff.setEquipe(equipe);
            return staffRepository.save(staff);
        }).orElseThrow(() -> new ResourceNotFoundException("EquipeId " + equipeId + " not found"));
    }

    @PutMapping("/equipes/{equipeId}/staffs/{staffId}")
    public Staff updateStaff(@PathVariable (value = "equipeId") Long equipeId,
                                 @PathVariable (value = "staffId") Long staffId,
                                 @Valid @RequestBody Staff staffRequest) {
        if(!equipeRepository.existsById(equipeId)) {
            throw new ResourceNotFoundException("EquipeId " + equipeId + " not found");
        }

        return staffRepository.findById(staffId).map(staff -> {
            staff.setType(staffRequest.getType());
            staff.setDescription(staffRequest.getDescription());
            return staffRepository.save(staff);
        }).orElseThrow(() -> new ResourceNotFoundException("StaffId " + staffId + "not found"));
    }

    @DeleteMapping("/equipes/{equipeId}/staffs/{staffId}")
    public ResponseEntity<?> deleteStaff(@PathVariable (value = "equipeId") Long equipeId,
                              @PathVariable (value = "staffId") Long staffId) {
        return staffRepository.findByIdAndEquipeId(staffId, equipeId).map(staff -> {
            staffRepository.delete(staff);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Staff not found with id " + staffId + " and equipeId " + equipeId));
    }
}