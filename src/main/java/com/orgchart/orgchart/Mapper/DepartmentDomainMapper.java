package com.orgchart.orgchart.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.orgchart.orgchart.DTO.DepartmentDomainDTO;
import com.orgchart.orgchart.model.DepartmentDomain;



/**
 * @author NNA7HC
 *
 */

public class DepartmentDomainMapper {
	public static DepartmentDomain toDepartmentDomain(DepartmentDomainDTO item) {
		DepartmentDomain rs = new DepartmentDomain();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setActivate(item.getActivate());
		rs.setPositionObj(PositionMapper.toPosition(item.getPositionObj()));
		rs.setCompetencies(item.getCompetencies());
		rs.setEntryCriteria(item.getEntryCriteria());
		rs.setResponsibilities(item.getResponsibilities());
		//rs.setOrgObj(OrganizationMapper.toOrganization(item.getOrgObj()));
		
		return rs;
	}
	
	public static DepartmentDomainDTO toDepartmentDomainDTO(DepartmentDomain item) {
		DepartmentDomainDTO rs = new DepartmentDomainDTO();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setActivate(item.getActivate());
		rs.setCompetencies(item.getCompetencies());
		rs.setEntryCriteria(item.getEntryCriteria());
		rs.setResponsibilities(item.getResponsibilities());
		rs.setPositionObj(PositionMapper.toPositionDTO(item.getPositionObj()));
		//rs.setOrgObj(OrganizationMapper.toOrganizationDTO(item.getOrgObj()));
		
		return rs;
	}
	
	public static List<DepartmentDomainDTO> toDepartmentDomainDTOList(List<DepartmentDomain> list)
	{
		List<DepartmentDomainDTO> rs = new ArrayList<DepartmentDomainDTO>();
		for (DepartmentDomain item : list) {
			rs.add(toDepartmentDomainDTO(item));
		}
		return rs;
	}
}
