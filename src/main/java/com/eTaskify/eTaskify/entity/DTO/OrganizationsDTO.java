package com.eTaskify.eTaskify.entity.DTO;

import java.util.List;

public class OrganizationsDTO {

	private Integer id;
	private String name;
	private String email;
	private String password;
	private String username;
	private String address;
	private String phone;
	
    private List<StaffsDTO> staffsDTO;

    private List<TasksDTO> taskDTO;
    
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<StaffsDTO> getStaffsDTO() {
		return staffsDTO;
	}

	public void setStaffsDTO(List<StaffsDTO> staffsDTO) {
		this.staffsDTO = staffsDTO;
	}

	public List<TasksDTO> getTaskDTO() {
		return taskDTO;
	}

	public void setTaskDTO(List<TasksDTO> taskDTO) {
		this.taskDTO = taskDTO;
	}

}
