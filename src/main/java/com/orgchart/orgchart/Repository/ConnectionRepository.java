package com.orgchart.orgchart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.Connection;

/**
 * @author NNA7HC
 *
 */

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Integer> {
	
	@Query("SELECT c FROM Connection c WHERE c.activate = true")
	List<Connection> getAll();
	
	@Query("SELECT c FROM Connection c inner join c.orgObj o WHERE o.id = :orgId AND c.activate = true")
	List<Connection> getByOrgId(@Param("orgId") int orgId);
}
