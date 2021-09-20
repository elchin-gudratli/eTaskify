package com.eTaskify.eTaskify.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.eTaskify.eTaskify.entity.Organizations;
import com.eTaskify.eTaskify.entity.DTO.OrganizationsDTO;



public interface OrganizationService {

	    ResponseEntity<List<Organizations>> getAllOrganization();
		
	    ResponseEntity<List<Organizations>> getAllOrganizationStaffs();
	    
	    Organizations getById(Integer id);
	   
		ResponseEntity<Organizations> getOrganizationDetail(Integer id);
		
		ResponseEntity<Organizations> getOrganizationStaffDetail(Integer id);
		
		ResponseEntity<Organizations> addOrganization(OrganizationsDTO organizationsDTO);
				
		ResponseEntity<Organizations> delete(Integer id);
		
		ResponseEntity<Organizations> updateOrganization(Integer id, OrganizationsDTO organizationsDTO);
}
