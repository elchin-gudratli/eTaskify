package com.eTaskify.eTaskify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="taskstaffs")
public class TaskStaffs {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="staff_id", referencedColumnName = "id")
	private Staffs staffId;
	
	@ManyToOne
	@JoinColumn(name = "task_id", referencedColumnName = "id")
	private Tasks taskId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Staffs getStaffId() {
		return staffId;
	}

	public void setStaffId(Staffs staffId) {
		this.staffId = staffId;
	}

	public Tasks getTaskId() {
		return taskId;
	}

	public void setTaskId(Tasks taskId) {
		this.taskId = taskId;
	}


}
