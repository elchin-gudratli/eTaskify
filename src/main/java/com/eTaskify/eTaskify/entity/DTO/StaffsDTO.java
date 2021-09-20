package com.eTaskify.eTaskify.entity.DTO;

import java.util.List;

import com.eTaskify.eTaskify.entity.Organizations;

public class StaffsDTO {

	private Integer id;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String password;
	

	
	private List<TasksDTO> taskDTO;

	private List<OrganizationsDTO> organizationsDTO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<TasksDTO> getTaskDTO() {
		return taskDTO;
	}

	public void setTaskDTO(List<TasksDTO> taskDTO) {
		this.taskDTO = taskDTO;
	}

	public List<OrganizationsDTO> getOrganizationsDTO() {
		return organizationsDTO;
	}

	public void setOrganizationsDTO(List<OrganizationsDTO> organizationsDTO) {
		this.organizationsDTO = organizationsDTO;
	}

	

	
}
