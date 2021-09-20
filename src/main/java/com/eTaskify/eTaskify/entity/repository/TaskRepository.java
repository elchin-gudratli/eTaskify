package com.eTaskify.eTaskify.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eTaskify.eTaskify.entity.TaskStaffs;
import com.eTaskify.eTaskify.entity.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Integer>{

	@Query(value = "select t from Tasks t where t.id =:taskId")
	Tasks getTaskDetail(@Param("taskId") Integer id);
	
	@Query(value="select t from Tasks t where t.organizationId=:Id")
	List<Tasks> findAllByTaskId(@Param("Id") Integer id);
}
