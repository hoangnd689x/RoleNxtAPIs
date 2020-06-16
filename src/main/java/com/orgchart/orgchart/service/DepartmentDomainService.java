package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.DTO.DepartmentDomainDTO;
import com.orgchart.orgchart.Mapper.PositionMapper;
import com.orgchart.orgchart.Mapper.DepartmentDomainMapper;
import com.orgchart.orgchart.Repository.DepartmentDomainRepositiory;
import com.orgchart.orgchart.model.DepartmentDomain;

/**
 * @author NNA7HC
 *
 */
@Service
@Transactional
public class DepartmentDomainService {
	@Autowired
	DepartmentDomainRepositiory departmentDomainRepositiory;
	
	public List<DepartmentDomain> getAll() {
		return departmentDomainRepositiory.getAll();
	}
	
	public List<DepartmentDomain> getbyPositionId(int positionId) {
		return departmentDomainRepositiory.getByPositionId(positionId);
	}

	public DepartmentDomainDTO findById(int id) {
		return DepartmentDomainMapper.toDepartmentDomainDTO(departmentDomainRepositiory.getOne(Integer.valueOf(id)));
	}

	public int add(DepartmentDomainDTO obj) {
		DepartmentDomain rs = new DepartmentDomain();

		rs.setName(obj.getName());
		rs.setPositionObj(PositionMapper.toPosition(obj.getPositionObj()));
		rs.setCompetencies(obj.getCompetencies());
		rs.setEntryCriteria(obj.getEntryCriteria());
		rs.setResponsibilities(obj.getResponsibilities());
		rs.setKRA(obj.getKRA());
		rs.setIndustrialRole(obj.getIndustrialRole());
		//rs.setOrgObj(OrganizationMapper.toOrganization(obj.getOrgObj()));
		rs.setActivate(true);

		if (departmentDomainRepositiory.save(rs) != null) {
			return 1;
		}
		return 0;
	}

	public int update(DepartmentDomainDTO obj) {

		if (departmentDomainRepositiory.save(DepartmentDomainMapper.toDepartmentDomain(obj)) != null) {
			return 1;
		}
		return 0;
	}

	public int delete(DepartmentDomainDTO obj) {

		obj.setActivate(false);
		if (departmentDomainRepositiory.save(DepartmentDomainMapper.toDepartmentDomain(obj)) != null) {
			return 1;
		}
		return 0;
	}
}
