package com.eTaskify.eTaskify.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.eTaskify.eTaskify.entity.Organizations;

@Repository
public interface OrganizationRepository extends JpaRepository<Organizations, Integer>{

	Organizations getById(Integer id);
	
	@Query(value = "select o from Organizations o where o.id =:organizationId")
	Organizations getOrganizationDetail(@Param("organizationId") Integer id);
	
	@Query(value="select o from Organizations o where o.id=:Id")
	List<Organizations> findAllByTaskId(@Param("Id") Integer id);
}
