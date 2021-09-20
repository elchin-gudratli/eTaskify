package com.eTaskify.eTaskify.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.eTaskify.eTaskify.entity.Tasks;
import com.eTaskify.eTaskify.entity.DTO.TasksDTO;


public interface TaskService {
	
    ResponseEntity<List<Tasks>> getAllTasks();
	
    ResponseEntity<List<Tasks>> getAllTasksStaff();
    
    Tasks getById(Integer id);
    
    ResponseEntity<Tasks> getTasksDetail(Integer id);
	
    ResponseEntity<Tasks> getTasksStaffDetail(Integer id);
    
	ResponseEntity<Tasks> addTasks(TasksDTO taskDTO);
	
	ResponseEntity<Tasks> delete(Integer id);
	
	ResponseEntity<Tasks> updateTasks(Integer id, TasksDTO taskDTO);
}
