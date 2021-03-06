package com.eTaskify.eTaskify.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "task")
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "organization_id")
	private Integer organizationId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="status")
	private Boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}


}
