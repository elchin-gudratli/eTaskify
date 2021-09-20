package com.eTaskify.eTaskify.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eTaskify.eTaskify.entity.OrganizationStaff;

@Repository
public interface OrganizationStaffRepository extends JpaRepository<OrganizationStaff,Integer>{

	
	@Query(value="select o from OrganizationStaff o where o.organization_id.id=:Id")
	List<OrganizationStaff> findAllByStaffId(@Param("Id") Integer id);
	
	@Query(value="select o from OrganizationStaff o where o.staff_id.id=:Id")
	List<OrganizationStaff> findAllByOrganizationId(@Param("Id") Integer id);
}
