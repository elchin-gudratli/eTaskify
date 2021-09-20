package com.eTaskify.eTaskify.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eTaskify.eTaskify.entity.OrganizationStaff;
import com.eTaskify.eTaskify.entity.Organizations;
import com.eTaskify.eTaskify.entity.Staffs;
import com.eTaskify.eTaskify.entity.TaskStaffs;
import com.eTaskify.eTaskify.entity.DTO.OrganizationsDTO;
import com.eTaskify.eTaskify.entity.DTO.StaffsDTO;
import com.eTaskify.eTaskify.entity.DTO.TaskStaffDTO;
import com.eTaskify.eTaskify.entity.DTO.TasksDTO;
import com.eTaskify.eTaskify.entity.repository.OrganizationRepository;
import com.eTaskify.eTaskify.entity.repository.OrganizationStaffRepository;
import com.eTaskify.eTaskify.entity.repository.StaffRepository;
import com.eTaskify.eTaskify.entity.repository.TaskStaffRepository;
import com.eTaskify.eTaskify.service.StaffService;


@Service
@Transactional
public class StaffServiceImpl implements StaffService{
	
	private final StaffRepository staffRepository;
	
	private final OrganizationRepository organizationRepository;
	
	private final OrganizationStaffRepository organizationStaffRepository;
	
	private final TaskStaffRepository taskStaffRepository;
	
	@Autowired
	public StaffServiceImpl(StaffRepository staffRepository,OrganizationRepository organizationRepository,OrganizationStaffRepository organizationStaffRepository,TaskStaffRepository taskStaffRepository) {
		this.staffRepository = staffRepository;
		this.organizationRepository = organizationRepository;
		this.organizationStaffRepository=organizationStaffRepository;
		this.taskStaffRepository=taskStaffRepository;
	}


	@Override
	public ResponseEntity getAllStaff() {
		List<Staffs> list = staffRepository.findAll();
		List<StaffsDTO> stList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (Staffs s : list) {
				StaffsDTO staffsDTO = new StaffsDTO();
				staffsDTO.setId(s.getId());
				staffsDTO.setName(s.getName());
				staffsDTO.setSurname(s.getSurname());
				staffsDTO.setEmail(s.getEmail());
				staffsDTO.setPassword(s.getPassword());
				stList.add(staffsDTO);
			}
			return ResponseEntity.ok(stList);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@Override
	public ResponseEntity getAllStaffOrganizations() {
		List<Staffs> list = staffRepository.findAll();
		List<StaffsDTO> stList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (Staffs s : list) {
				StaffsDTO staffsDTO = new StaffsDTO();
				staffsDTO.setId(s.getId());
				staffsDTO.setName(s.getName());
				staffsDTO.setSurname(s.getSurname());
				staffsDTO.setEmail(s.getEmail());
				staffsDTO.setPassword(s.getPassword());	
				List<OrganizationStaff> oList = organizationStaffRepository.findAllByOrganizationId(s.getId());
				List<OrganizationsDTO> orList = new ArrayList<>();
				for(OrganizationStaff o : oList) {
					OrganizationsDTO oDTO = new OrganizationsDTO();
					oDTO.setName(o.getOrganization_id().getName());
					oDTO.setEmail(o.getOrganization_id().getEmail());
					oDTO.setPassword(o.getOrganization_id().getPassword());
					oDTO.setPhone(o.getOrganization_id().getPhone());
					oDTO.setAddress(o.getOrganization_id().getAddress());
					oDTO.setId(o.getOrganization_id().getId());
					oDTO.setUsername(o.getOrganization_id().getUsername());
					orList.add(oDTO);
			}
				List<TaskStaffs> tList = taskStaffRepository.findAllByTaskId(s.getId());
				List<TasksDTO> taList = new ArrayList<>();
				for(TaskStaffs t : tList) {
					TasksDTO tDTO = new TasksDTO();
					tDTO.setId(t.getTaskId().getId());
					tDTO.setTitle(t.getTaskId().getTitle());
					tDTO.setDescription(t.getTaskId().getDescription());
					tDTO.setDeadline(t.getTaskId().getDeadline());
					tDTO.setStatus(t.getTaskId().getStatus());
					tDTO.setOrganizationId(t.getTaskId().getOrganizationId());
					
					taList.add(tDTO);
			}
				staffsDTO.setTaskDTO(taList);
				staffsDTO.setOrganizationsDTO(orList);
				stList.add(staffsDTO);
			}
			return ResponseEntity.ok(stList);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public Staffs getById(Integer id) {
		return staffRepository.findById(id).get();
	}
	
	@Override
	public ResponseEntity<Staffs> getStaffDetails(Integer id) {
		Staffs staff = staffRepository.getStaffDetail(id);
		if (staff != null) {
			return ResponseEntity.ok(staff);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}


	@Override
	public ResponseEntity getStaffTaskOrganizationDetails(Integer id) {
		Staffs s = staffRepository.getStaffDetail(id);
		List<StaffsDTO> stList = new ArrayList<>();
		if (s == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		StaffsDTO staffsDTO = new StaffsDTO();
		staffsDTO.setId(s.getId());
		staffsDTO.setName(s.getName());
		staffsDTO.setSurname(s.getSurname());
		staffsDTO.setEmail(s.getEmail());
		staffsDTO.setPassword(s.getPassword());	
		List<OrganizationStaff> oList = organizationStaffRepository.findAllByOrganizationId(s.getId());
		List<OrganizationsDTO> orList = new ArrayList<>();
		for(OrganizationStaff o : oList) {
			OrganizationsDTO oDTO = new OrganizationsDTO();
			oDTO.setName(o.getOrganization_id().getName());
			oDTO.setEmail(o.getOrganization_id().getEmail());
			oDTO.setPassword(o.getOrganization_id().getPassword());
			oDTO.setPhone(o.getOrganization_id().getPhone());
			oDTO.setAddress(o.getOrganization_id().getAddress());
			oDTO.setId(o.getOrganization_id().getId());
			oDTO.setUsername(o.getOrganization_id().getUsername());
			orList.add(oDTO);
	}
		List<TaskStaffs> tList = taskStaffRepository.findAllByTaskId(s.getId());
		List<TasksDTO> taList = new ArrayList<>();
		for(TaskStaffs t : tList) {
			TasksDTO tDTO = new TasksDTO();
			tDTO.setId(t.getTaskId().getId());
			tDTO.setTitle(t.getTaskId().getTitle());
			tDTO.setDescription(t.getTaskId().getDescription());
			tDTO.setDeadline(t.getTaskId().getDeadline());
			tDTO.setStatus(t.getTaskId().getStatus());
			tDTO.setOrganizationId(t.getTaskId().getOrganizationId());
			
			taList.add(tDTO);
	}
		staffsDTO.setTaskDTO(taList);
		staffsDTO.setOrganizationsDTO(orList);
		stList.add(staffsDTO);
	    return ResponseEntity.ok(stList);
	}

	@Override
	public ResponseEntity<Staffs> addStaff(StaffsDTO staffDTO) {
		Staffs staffs = new Staffs();
		staffs.setName(staffDTO.getName());
		staffs.setSurname(staffDTO.getSurname());
		staffs.setEmail(staffDTO.getEmail());
		staffs.setPassword(staffDTO.getPassword());
		staffRepository.save(staffs);
		return ResponseEntity.ok(staffs);
	}

	@Override
	public ResponseEntity<Staffs> delete(Integer id) {
		Optional<Staffs> staffOptional = staffRepository.findById(id);
		if (staffOptional.isPresent()) {
			staffRepository.deleteById(id);
			return ResponseEntity.ok(staffOptional.get());
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Staffs> updateStaff(Integer id, StaffsDTO staffDTO) {
		Staffs staff = getById(id);
		if (staff != null) {
			if (staffDTO.getName() != null) {
				staff.setName(staffDTO.getName());
			}
			if (staffDTO.getSurname() != null) {
				staff.setSurname(staffDTO.getSurname());
			}
			if (staffDTO.getEmail() != null) {
				staff.setEmail(staffDTO.getEmail());
			}
			
			if (staffDTO.getPassword() != null) {
				staff.setPassword(staffDTO.getPassword());
			}
			
		  } else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		staffRepository.save(staff);
		return ResponseEntity.ok(staff);
	}



}
