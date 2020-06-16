package com.orgchart.orgchart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.Organization;

/**
 * @author NNA7HC
 *
 */

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer>{
	
	@Query("SELECT o FROM Organization o WHERE o.activate = true")
	List<Organization> getAll();
	
	@Query("SELECT o FROM Organization o inner join o.domainObj d WHERE d.id = :domainId AND o.activate = true")
	List<Organization> getByDomainId(@Param("domainId") int domainId);
}
