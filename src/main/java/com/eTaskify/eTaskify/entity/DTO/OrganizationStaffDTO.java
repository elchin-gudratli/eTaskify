package com.eTaskify.eTaskify.entity.DTO;

public class OrganizationStaffDTO {

	private Integer id;
	private OrganizationsDTO organizations;
	private StaffsDTO staffs;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public OrganizationsDTO getOrganizations() {
		return organizations;
	}
	public void setOrganizations(OrganizationsDTO organizations) {
		this.organizations = organizations;
	}
	public StaffsDTO getStaffs() {
		return staffs;
	}
	public void setStaffs(StaffsDTO staffs) {
		this.staffs = staffs;
	}
}
