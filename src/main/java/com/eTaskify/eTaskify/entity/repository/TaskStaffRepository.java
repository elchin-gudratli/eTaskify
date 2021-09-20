package com.eTaskify.eTaskify.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eTaskify.eTaskify.entity.OrganizationStaff;
import com.eTaskify.eTaskify.entity.TaskStaffs;

@Repository
public interface TaskStaffRepository extends JpaRepository<TaskStaffs, Integer>{

	@Query(value="select t from TaskStaffs t where t.taskId.id=:Id")
	List<TaskStaffs> findAllByTaskId(@Param("Id") Integer id);
	
	@Query(value="select o from TaskStaffs o where o.taskId.id=:Id")
	List<TaskStaffs> findAllByStaffId(@Param("Id") Integer id);
}
