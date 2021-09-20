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
import com.eTaskify.eTaskify.entity.Tasks;
import com.eTaskify.eTaskify.entity.DTO.OrganizationsDTO;
import com.eTaskify.eTaskify.entity.DTO.StaffsDTO;
import com.eTaskify.eTaskify.entity.DTO.TasksDTO;
import com.eTaskify.eTaskify.entity.repository.OrganizationRepository;
import com.eTaskify.eTaskify.entity.repository.OrganizationStaffRepository;
import com.eTaskify.eTaskify.entity.repository.StaffRepository;
import com.eTaskify.eTaskify.entity.repository.TaskRepository;
import com.eTaskify.eTaskify.entity.repository.TaskStaffRepository;
import com.eTaskify.eTaskify.service.OrganizationService;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService{

	private final OrganizationRepository organizationRepository;
	
	private final StaffRepository staffRepository;
	
	private final TaskRepository taskRepository;
	
	private final OrganizationStaffRepository organizationStaffRepository;
	
	private final TaskStaffRepository taskStaffRepository;
	
	@Autowired
	public OrganizationServiceImpl(OrganizationRepository organizationRepository,StaffRepository staffRepository,OrganizationStaffRepository organizationStaffRepository,TaskStaffRepository taskStaffRepository,TaskRepository taskRepository) {
		this.organizationRepository = organizationRepository;
		this.staffRepository = staffRepository;
		this.organizationStaffRepository=organizationStaffRepository;
		this.taskStaffRepository=taskStaffRepository;
		this.taskRepository=taskRepository;
	}

	@Override
	public ResponseEntity getAllOrganization() {
		List<Organizations> list = organizationRepository.findAll();
		List<OrganizationsDTO> stList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (Organizations o : list) {
				OrganizationsDTO organizationDTO = new OrganizationsDTO();
				organizationDTO.setId(o.getId());
				organizationDTO.setName(o.getName());
				organizationDTO.setEmail(o.getEmail());
				organizationDTO.setPassword(o.getPassword());
				organizationDTO.setAddress(o.getAddress());
				organizationDTO.setPhone(o.getPhone());
				organizationDTO.setUsername(o.getUsername());
				
				stList.add(organizationDTO);
			}
			return ResponseEntity.ok(stList);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@Override
	public ResponseEntity getAllOrganizationStaffs() {
		List<Organizations> list = organizationRepository.findAll();
		List<OrganizationsDTO> stList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (Organizations o : list) {
				OrganizationsDTO organizationDTO = new OrganizationsDTO();
				organizationDTO.setId(o.getId());
				organizationDTO.setName(o.getName());
				organizationDTO.setEmail(o.getEmail());
				organizationDTO.setPassword(o.getPassword());
				organizationDTO.setAddress(o.getAddress());
				organizationDTO.setPhone(o.getPhone());
				organizationDTO.setUsername(o.getUsername());
				List<OrganizationStaff> oList = organizationStaffRepository.findAllByStaffId(o.getId());
				List<StaffsDTO> stDTOList = new ArrayList<>();
				for(OrganizationStaff s : oList) {
					StaffsDTO staffDTO = new StaffsDTO();
					staffDTO.setName(s.getStaff_id().getName());
					staffDTO.setSurname(s.getStaff_id().getSurname());
					staffDTO.setEmail(s.getStaff_id().getEmail());
					staffDTO.setPassword(s.getStaff_id().getPassword());
					staffDTO.setId(s.getStaff_id().getId());
					List<TaskStaffs> tList = taskStaffRepository.findAllByTaskId(s.getId());
					List<TasksDTO> taskDTOList = new ArrayList<>();
					for(TaskStaffs t : tList) {
						TasksDTO tDTO=new TasksDTO();
						tDTO.setId(t.getTaskId().getId());
						tDTO.setTitle(t.getTaskId().getTitle());
						tDTO.setDescription(t.getTaskId().getDescription());
						tDTO.setDeadline(t.getTaskId().getDeadline());
						tDTO.setStatus(t.getTaskId().getStatus());
						tDTO.setOrganizationId(t.getTaskId().getOrganizationId());
						taskDTOList.add(tDTO);
					}
					staffDTO.setTaskDTO(taskDTOList);
					stDTOList.add(staffDTO);
				}
				organizationDTO.setStaffsDTO(stDTOList);
				stList.add(organizationDTO);
			}
			return ResponseEntity.ok(stList);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}


	@Override
	public Organizations getById(Integer id) {
		return organizationRepository.findById(id).get();
	}
	
	@Override
	public ResponseEntity<Organizations> getOrganizationDetail(Integer id) {
		Organizations organization = organizationRepository.getOrganizationDetail(id);
		if (organization != null) {
			return ResponseEntity.ok(organization);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	
	}
	
	@Override
	public ResponseEntity getOrganizationStaffDetail(Integer id) {
		Organizations o = organizationRepository.getOrganizationDetail(id);
		List<OrganizationsDTO> stList = new ArrayList<>();
		if (o == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
				OrganizationsDTO organizationDTO = new OrganizationsDTO();
				organizationDTO.setId(o.getId());
				organizationDTO.setName(o.getName());
				organizationDTO.setEmail(o.getEmail());
				organizationDTO.setPassword(o.getPassword());
				organizationDTO.setAddress(o.getAddress());
				organizationDTO.setPhone(o.getPhone());
				organizationDTO.setUsername(o.getUsername());
				List<OrganizationStaff> oList = organizationStaffRepository.findAllByStaffId(o.getId());
				List<StaffsDTO> stDTOList = new ArrayList<>();
				for(OrganizationStaff s : oList) {
					StaffsDTO staffDTO = new StaffsDTO();
					staffDTO.setName(s.getStaff_id().getName());
					staffDTO.setSurname(s.getStaff_id().getSurname());
					staffDTO.setEmail(s.getStaff_id().getEmail());
					staffDTO.setPassword(s.getStaff_id().getPassword());
					staffDTO.setId(s.getStaff_id().getId());
					List<TaskStaffs> tList = taskStaffRepository.findAllByTaskId(s.getId());
					List<TasksDTO> taskDTOList = new ArrayList<>();
					for(TaskStaffs t : tList) {
						TasksDTO tDTO=new TasksDTO();
						tDTO.setId(t.getTaskId().getId());
						tDTO.setTitle(t.getTaskId().getTitle());
						tDTO.setDescription(t.getTaskId().getDescription());
						tDTO.setDeadline(t.getTaskId().getDeadline());
						tDTO.setStatus(t.getTaskId().getStatus());
						tDTO.setOrganizationId(t.getTaskId().getOrganizationId());
						taskDTOList.add(tDTO);
					}
					staffDTO.setTaskDTO(taskDTOList);
					stDTOList.add(staffDTO);
				}
				
				organizationDTO.setStaffsDTO(stDTOList);
				stList.add(organizationDTO);
				return ResponseEntity.ok(stList);
			}
			
	

	@Override
	public ResponseEntity<Organizations> addOrganization(OrganizationsDTO organizationsDTO) {
		Organizations organizations = new Organizations();
		organizations.setName(organizationsDTO.getName());
		organizations.setEmail(organizationsDTO.getEmail());
		organizations.setPassword(organizationsDTO.getPassword());
		organizations.setAddress(organizationsDTO.getAddress());
		organizations.setPhone(organizationsDTO.getPhone());
		organizations.setUsername(organizationsDTO.getUsername());
		organizationRepository.save(organizations);
		return ResponseEntity.ok(organizations);
	}


	@Override
	public ResponseEntity<Organizations> delete(Integer id) {
		Optional<Organizations> organizationOptional = organizationRepository.findById(id);
		if (organizationOptional.isPresent()) {
			organizationRepository.deleteById(id);
			return ResponseEntity.ok(organizationOptional.get());
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	
	}

	@Override
	public ResponseEntity<Organizations> updateOrganization(Integer id, OrganizationsDTO organizationsDTO) {
		Organizations organization = getById(id);
		if (organization != null) {
			if (organizationsDTO.getName() != null) {
			organization.setName(organizationsDTO.getName());
			}
			if (organizationsDTO.getEmail() != null) {
				organization.setEmail(organizationsDTO.getEmail());
			}
			
			if (organizationsDTO.getPassword() != null) {
				organization.setPassword(organizationsDTO.getPassword());
			}
			
			if (organizationsDTO.getAddress() != null) {
				organization.setAddress(organizationsDTO.getAddress());
			}
			
			if (organizationsDTO.getPhone() != null) {
				organization.setPhone(organizationsDTO.getPhone());
			}
			
			if (organizationsDTO.getUsername() != null) {
				organization.setUsername(organizationsDTO.getUsername());
			}
			
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(organization);
	}

	
 
}