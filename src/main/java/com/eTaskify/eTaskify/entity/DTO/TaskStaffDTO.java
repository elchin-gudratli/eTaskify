package com.eTaskify.eTaskify.entity.DTO;

import com.eTaskify.eTaskify.entity.Staffs;
import com.eTaskify.eTaskify.entity.Tasks;

public class TaskStaffDTO {

	private Integer id;
	private Staffs staffId;
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
