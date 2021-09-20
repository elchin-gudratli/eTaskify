package com.eTaskify.eTaskify.entity.DTO;

import java.util.Date;
import java.util.List;

import com.eTaskify.eTaskify.entity.Staffs;

public class TasksDTO {

	private Integer id;
	private Integer organizationId;
	private String title;
	private String description;
	private Date deadline;
	private Boolean status;
	
	private List<StaffsDTO> staffsDTO;
	private List<OrganizationsDTO> organizationsDTO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<StaffsDTO> getStaffsDTO() {
		return staffsDTO;
	}

	public void setStaffsDTO(List<StaffsDTO> staffsDTO) {
		this.staffsDTO = staffsDTO;
	}

	public List<OrganizationsDTO> getOrganizationsDTO() {
		return organizationsDTO;
	}

	public void setOrganizationsDTO(List<OrganizationsDTO> organizationsDTO) {
		this.organizationsDTO = organizationsDTO;
	}

	
}
