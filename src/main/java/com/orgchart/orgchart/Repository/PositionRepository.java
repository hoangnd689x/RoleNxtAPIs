package com.orgchart.orgchart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.Position;

/**
 * @author NNA7HC
 *
 */

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer>{
	
	@Query("SELECT p FROM Position p WHERE p.activate = true")
	List<Position> getAll();
	
	@Query("SELECT p FROM Position p inner join p.organizationObj o WHERE o.id = :orgId AND p.activate = true")
	List<Position> getByOrgId(@Param("orgId") int orgId);
	
//	@Query("SELECT p FROM Position p inner join p.deptDomain d WHERE d.id = :deptDomainId AND p.name = :positionName AND p.activate = true")
//	Position getByDeptDomainandName(@Param("deptDomainId") int deptDomainId, @Param("positionName") String positionName);
}
