package com.example.Apifoot.repository;

import com.example.Apifoot.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
	 Page<Staff> findByEquipeId(Long equipeId, Pageable pageable);
	    Optional<Staff> findByIdAndEquipeId(Long id, Long equipeId);
}