package com.eTaskify.eTaskify.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.eTaskify.eTaskify.entity.Staffs;
import com.eTaskify.eTaskify.entity.DTO.StaffsDTO;


public interface StaffService {

    ResponseEntity<List<Staffs>> getAllStaff();
    
    ResponseEntity<List<Staffs>> getAllStaffOrganizations();
	
    Staffs getById(Integer id);
    
    ResponseEntity<Staffs> getStaffDetails(Integer id);
    
    ResponseEntity<Staffs> getStaffTaskOrganizationDetails(Integer id);
	
	ResponseEntity<Staffs> addStaff(StaffsDTO staffDTO);
	
	ResponseEntity<Staffs> delete(Integer id);
	
	ResponseEntity<Staffs> updateStaff(Integer id, StaffsDTO staffDTO);
}
