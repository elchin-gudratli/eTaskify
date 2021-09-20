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
@Table(name="organization_staff")
public class OrganizationStaff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="organization_id", referencedColumnName = "id")
	private Organizations organization_id;
	
	@ManyToOne
	@JoinColumn(name = "staff_id", referencedColumnName = "id")
	private Staffs staff_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Organizations getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(Organizations organization_id) {
		this.organization_id = organization_id;
	}

	public Staffs getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Staffs staff_id) {
		this.staff_id = staff_id;
	}


}
