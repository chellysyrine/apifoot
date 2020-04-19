package com.example.Apifoot.service;

import java.util.List;


import com.example.Apifoot.model.Staff;

public interface StaffService {
	
	Staff saveJoueur(Staff staff);

	List<Staff> findAllStaffs();

}
