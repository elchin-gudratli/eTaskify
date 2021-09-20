package com.eTaskify.eTaskify.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eTaskify.eTaskify.entity.Staffs;

@Repository
public interface StaffRepository extends JpaRepository<Staffs, Integer>{

	Staffs getById(Integer id);
	
	@Query(value = "select s from Staffs s  where s.id =:staffId")
	Staffs getStaffDetail(@Param("staffId") Integer id);
	
	
}
