package com.orgchart.orgchart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.DepartmentDomain;


/**
 * @author NNA7HC
 *
 */

@Repository
public interface DepartmentDomainRepositiory extends JpaRepository<DepartmentDomain, Integer>{

	@Query("SELECT d FROM DepartmentDomain d WHERE d.activate = true")
	List<DepartmentDomain> getAll();
	
	@Query("SELECT d FROM DepartmentDomain d WHERE d.positionObj.id = :positionId AND d.activate = true")
	List<DepartmentDomain> getByPositionId(@Param("positionId") int positionId);
	
}
