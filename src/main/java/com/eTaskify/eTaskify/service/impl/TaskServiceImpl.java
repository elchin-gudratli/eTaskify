package com.eTaskify.eTaskify.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.eTaskify.eTaskify.entity.Organizations;
import com.eTaskify.eTaskify.entity.TaskStaffs;
import com.eTaskify.eTaskify.entity.Tasks;
import com.eTaskify.eTaskify.entity.DTO.OrganizationsDTO;
import com.eTaskify.eTaskify.entity.DTO.StaffsDTO;
import com.eTaskify.eTaskify.entity.DTO.TasksDTO;
import com.eTaskify.eTaskify.entity.repository.OrganizationRepository;
import com.eTaskify.eTaskify.entity.repository.StaffRepository;
import com.eTaskify.eTaskify.entity.repository.TaskRepository;
import com.eTaskify.eTaskify.entity.repository.TaskStaffRepository;
import com.eTaskify.eTaskify.service.TaskService;

@Service
@Transactional
public class TaskServiceImpl implements TaskService{
	
	private final TaskRepository taskRepository;
	
	private final StaffRepository staffRepository;
	
	private final TaskStaffRepository taskStaffRepository;
	
	private final OrganizationRepository organizationRepository;
	
	public TaskServiceImpl(TaskRepository taskRepository,StaffRepository staffRepository,TaskStaffRepository taskStaffRepository,OrganizationRepository organizationRepository) {
		this.taskRepository = taskRepository;
		this.staffRepository=staffRepository;
		this.taskStaffRepository=taskStaffRepository;
		this.organizationRepository=organizationRepository;
	}

	@Override
	public ResponseEntity getAllTasks() {
		List<Tasks> list = taskRepository.findAll();
		List<TasksDTO> tkList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (Tasks t : list) {
				TasksDTO taskDTO = new TasksDTO();
				taskDTO.setTitle(t.getTitle());
				taskDTO.setDescription(t.getDescription());
				taskDTO.setDeadline(t.getDeadline());
				taskDTO.setStatus(t.getStatus());
				taskDTO.setOrganizationId(t.getOrganizationId());
				tkList.add(taskDTO);
			}
			return ResponseEntity.ok(tkList);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity getAllTasksStaff() {
		List<Tasks> list = taskRepository.findAll();
		List<TasksDTO> tkList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (Tasks t : list) {
				TasksDTO taskDTO = new TasksDTO();
				taskDTO.setId(t.getId());
				taskDTO.setTitle(t.getTitle());
				taskDTO.setDescription(t.getDescription());
				taskDTO.setDeadline(t.getDeadline());
				taskDTO.setStatus(t.getStatus());
				taskDTO.setOrganizationId(t.getOrganizationId());
				List<TaskStaffs> staffList = taskStaffRepository.findAllByStaffId(t.getId());
				List<StaffsDTO> sList= new ArrayList<>();
				for(TaskStaffs s : staffList) {
					StaffsDTO sDTO= new StaffsDTO();
					sDTO.setId(s.getStaffId().getId());
					sDTO.setName(s.getStaffId().getName());
					sDTO.setSurname(s.getStaffId().getSurname());
					sDTO.setEmail(s.getStaffId().getEmail());
					sDTO.setPassword(s.getStaffId().getPassword());
					sList.add(sDTO);
				
				}
				List<Organizations> oLists = organizationRepository.findAllByTaskId(t.getOrganizationId());
				List<OrganizationsDTO> orList = new ArrayList<>();
				for (Organizations n : oLists) {
					OrganizationsDTO notDTO = new OrganizationsDTO();
					notDTO.setId(n.getId());
					notDTO.setName(n.getName());
					orList.add(notDTO);
				}
				taskDTO.setOrganizationsDTO(orList);
				taskDTO.setStaffsDTO(sList);
				tkList.add(taskDTO);
			}
			return ResponseEntity.ok(tkList);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	
	@Override
	public Tasks getById(Integer id) {
		return taskRepository.findById(id).get();
	}

	@Override
	public ResponseEntity<Tasks> getTasksDetail(Integer id) {
		
		Tasks task = taskRepository.getTaskDetail(id);
		if (task != null) {
			return ResponseEntity.ok(task);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@Override
	public ResponseEntity getTasksStaffDetail(Integer id) {
		Tasks task = taskRepository.getTaskDetail(id);
		List<TasksDTO> tkList = new ArrayList<>();
		if (task == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} 
		TasksDTO taskDTO = new TasksDTO();
		taskDTO.setTitle(task.getTitle());
		taskDTO.setDescription(task.getDescription());
		taskDTO.setDeadline(task.getDeadline());
		taskDTO.setStatus(task.getStatus());
		taskDTO.setOrganizationId(task.getOrganizationId());
		List<TaskStaffs> staffList = taskStaffRepository.findAllByStaffId(task.getId());
		List<StaffsDTO> sList= new ArrayList<>();
		for(TaskStaffs s : staffList) {
			StaffsDTO sDTO= new StaffsDTO();
			sDTO.setId(s.getStaffId().getId());
			sDTO.setName(s.getStaffId().getName());
			sDTO.setSurname(s.getStaffId().getSurname());
			sDTO.setEmail(s.getStaffId().getEmail());
			sDTO.setPassword(s.getStaffId().getPassword());
			sList.add(sDTO);
		
		}
		List<Organizations> oLists = organizationRepository.findAllByTaskId(task.getOrganizationId());
		List<OrganizationsDTO> orList = new ArrayList<>();
		for (Organizations n : oLists) {
			OrganizationsDTO notDTO = new OrganizationsDTO();
			notDTO.setId(n.getId());
			notDTO.setName(n.getName());
			orList.add(notDTO);
		}
		taskDTO.setOrganizationsDTO(orList);
		taskDTO.setStaffsDTO(sList);
		tkList.add(taskDTO);
	
	   return ResponseEntity.ok(tkList);
	}

	
	@Override
	public ResponseEntity<Tasks> addTasks(TasksDTO taskDTO) {
		Tasks tasks=new Tasks();
		tasks.setTitle(taskDTO.getTitle());
		tasks.setDescription(taskDTO.getDescription());
		tasks.setDeadline(taskDTO.getDeadline());
		tasks.setStatus(taskDTO.getStatus());
		tasks.setOrganizationId(taskDTO.getOrganizationId());
		taskRepository.save(tasks);
		return ResponseEntity.ok(tasks);
	}

	@Override
	public ResponseEntity<Tasks> delete(Integer id) {
		Optional<Tasks> tasksOptional = taskRepository.findById(id);
		if (tasksOptional.isPresent()) {
			taskRepository.deleteById(id);
			return ResponseEntity.ok(tasksOptional.get());
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Tasks> updateTasks(Integer id, TasksDTO taskDTO) {
		Tasks task = getById(id);
		if(task != null) {
			if (taskDTO.getTitle() != null) {
				task.setTitle(taskDTO.getTitle());
			}
			if (taskDTO.getDescription() != null) {
				task.setDescription(taskDTO.getDescription());
			}
			if (taskDTO.getDeadline() != null) {
				task.setDeadline(taskDTO.getDeadline());
			}
			if (taskDTO.getStatus() != null) {
				task.setStatus(taskDTO.getStatus());
			}
			if (taskDTO.getOrganizationId() != null) {
				task.setOrganizationId(taskDTO.getOrganizationId());
			}
			
		}else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		taskRepository.save(task);
		return ResponseEntity.ok(task);
	}

	

}
