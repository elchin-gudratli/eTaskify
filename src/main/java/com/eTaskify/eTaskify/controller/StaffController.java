package com.eTaskify.eTaskify.controller;

import java.util.List;

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
import com.eTaskify.eTaskify.entity.Staffs;
import com.eTaskify.eTaskify.entity.DTO.StaffsDTO;
import com.eTaskify.eTaskify.service.StaffService;


@RestController
@RequestMapping("/api/staffs")
public class StaffController {

	private final StaffService staffService;

	public StaffController(StaffService staffService) {
		this.staffService = staffService;
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<Staffs>> getAllStaff(){
		return staffService.getAllStaff();
	}
	@GetMapping("getAllStaffOrganizations")
	public ResponseEntity<List<Staffs>> getAllStaffOrganizations(){
		return staffService.getAllStaffOrganizations();
	}
	
	@GetMapping("/staffProfile/{id}")
	public ResponseEntity<Staffs> getProfileStaff(@PathVariable Integer id){
		return staffService.getStaffDetails(id);	
	}
	@GetMapping("/staffOrganizationDetails/{id}")
	public ResponseEntity<Staffs> getStaffTaskOrganizationDetails(@PathVariable Integer id){
		return staffService.getStaffTaskOrganizationDetails(id);	
	}
	@PostMapping("/addStaff")
	public ResponseEntity<Staffs> addStaffPost(@RequestBody StaffsDTO staffDTO){
		return staffService.addStaff(staffDTO);
	}
	@DeleteMapping("/deleteStaff/{id}")
	public ResponseEntity<Staffs> deleteStaff(@PathVariable Integer id){
		return staffService.delete(id);
	}
	@PutMapping("/editStaff/{id}")
	public ResponseEntity<Staffs> updateStaff(@PathVariable Integer id, @RequestBody StaffsDTO staffDTO){
		return staffService.updateStaff(id, staffDTO);
	}
	
}
