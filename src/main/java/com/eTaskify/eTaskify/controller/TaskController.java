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

import com.eTaskify.eTaskify.entity.Staffs;
import com.eTaskify.eTaskify.entity.Tasks;
import com.eTaskify.eTaskify.entity.DTO.TasksDTO;
import com.eTaskify.eTaskify.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	@GetMapping("getAll")
	public ResponseEntity<List<Tasks>> getAllTasks(){
		return taskService.getAllTasks();
	}
	@GetMapping("getAllTaskStaff")
	public ResponseEntity<List<Tasks>> getAllTasksStaff(){
		return taskService.getAllTasksStaff();
	}
	@GetMapping("/taskProfile/{id}")
	public ResponseEntity<Tasks> getProfileTasks(@PathVariable Integer id){
		return taskService.getTasksDetail(id);	
	}
	@GetMapping("/taskStaffProfile/{id}")
	public ResponseEntity<Tasks> getTasksStaffDetail(@PathVariable Integer id){
		return taskService.getTasksStaffDetail(id);	
	}
	@PostMapping("/addTask")
	public ResponseEntity<Tasks> addTaskPost(@RequestBody TasksDTO taskDTO){
		return taskService.addTasks(taskDTO);
	}
	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<Tasks> deleteStaff(@PathVariable Integer id){
		return taskService.delete(id);
	}
	@PutMapping("/editTask/{id}")
	public ResponseEntity<Tasks> updateStaff(@PathVariable Integer id, @RequestBody TasksDTO taskDTO){
		return taskService.updateTasks(id, taskDTO);
	}
	
}
