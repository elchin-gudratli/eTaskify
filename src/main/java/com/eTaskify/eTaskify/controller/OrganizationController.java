package com.eTaskify.eTaskify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eTaskify.eTaskify.entity.Organizations;
import com.eTaskify.eTaskify.entity.DTO.OrganizationsDTO;
import com.eTaskify.eTaskify.service.OrganizationService;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
	
	private final OrganizationService organizationService;
	
	@Autowired
	public OrganizationController(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}
	@GetMapping("getAll")
	public ResponseEntity<List<Organizations>> getAllOrganizations(){
		return organizationService.getAllOrganization();
	}
	@GetMapping("getAllStaff")
	public ResponseEntity<List<Organizations>> getAllOrganizationsStaffs(){
		return organizationService.getAllOrganizationStaffs();
	}
	@GetMapping("/organizationProfile/{id}")
	public ResponseEntity<Organizations> getProfileOrganization(@PathVariable Integer id){
		return organizationService.getOrganizationDetail(id);	
	}
	@GetMapping("/organizationStaffProfile/{id}")
	public ResponseEntity<Organizations> getProfileOrganizationStaff(@PathVariable Integer id){
		return organizationService.getOrganizationStaffDetail(id);	
	}
	@PostMapping("/addOrganization")
	public ResponseEntity<Organizations> addOrganizationsPost(@RequestBody OrganizationsDTO organizationDTO){
		return organizationService.addOrganization(organizationDTO);
	}
	@DeleteMapping("/deleteOrganization/{id}")
	public ResponseEntity<Organizations> deleteOrganizations(@PathVariable Integer id){
		return organizationService.delete(id);
	}
	@PutMapping("/editOrganization/{id}")
	public ResponseEntity<Organizations> updateOrganization(@PathVariable Integer id, @RequestBody OrganizationsDTO organizationDTO){
		return organizationService.updateOrganization(id, organizationDTO);
	}

}
