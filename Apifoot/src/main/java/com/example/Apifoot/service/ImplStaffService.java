package com.example.Apifoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Apifoot.model.Staff;
import com.example.Apifoot.repository.StaffRepository;

public class ImplStaffService implements StaffService {
 
	@Autowired 
	
	StaffRepository srepos;
	
	
	@Override
	public Staff saveJoueur(Staff staff) {
		// TODO Auto-generated method stub
		return srepos.save(staff);
	}

	@Override
	public List<Staff> findAllStaffs() {
		// TODO Auto-generated method stub
		return srepos.findAll();
	}

}
