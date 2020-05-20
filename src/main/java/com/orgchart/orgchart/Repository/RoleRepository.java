package com.orgchart.orgchart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.Role;

/**
 * @author NNA7HC
 *
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	@Query("SELECT r FROM Role r WHERE r.activate = true")
	List<Role> getAll();
	
	@Query("SELECT r FROM Role r inner join r.positionObj p WHERE p.id = :positionId AND r.activate = true")
	List<Role> getByPositionId(@Param("positionId") int positionId);
	
	@Query("SELECT r FROM Role r inner join r.positionObj p WHERE p.id = :positionId AND p.organizationObj.domainObj.id = :domainId AND r.activate = true")
	Role getByDomainPosition(@Param("domainId") int domainId, @Param("positionId") int positionId);
}
