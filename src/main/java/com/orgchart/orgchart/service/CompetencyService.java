package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.DTO.CompetencyDTO;
import com.orgchart.orgchart.Mapper.CompetencyMapper;
import com.orgchart.orgchart.Mapper.DomainMapper;
import com.orgchart.orgchart.model.Competency;

/**
 * @author NNA7HC
 *
 */
//@Service
//@Transactional
public class CompetencyService {
	
//	@Autowired
//	CompetencyRepository competencyRepository;
//	
//	public List<Competency> getAll(){
//		return competencyRepository.getAll();
//	}
//	
//	public List<Competency> getByDomainId(int domainId){
//		return competencyRepository.getByDomainId(domainId);
//	}
//	
//	public CompetencyDTO findById(int id) {
//		return CompetencyMapper.toCompetencyDTO(competencyRepository.getOne(Integer.valueOf(id)));
//	}
//	
//	public int add(CompetencyDTO obj) {
//		Competency rs = new Competency();
//		
//		rs.setName(obj.getName());
//		rs.setDmOjb(DomainMapper.toDomain(obj.getDmOjb()));
//		rs.setCategory(obj.getCategory());
//		rs.setActivate(true);
//		
//		if(competencyRepository.save(rs) != null)
//		{
//			return 1;
//		} 
//		return 0;
//	}
//	
//	public int update(CompetencyDTO obj) {
//		
//		if(competencyRepository.save(CompetencyMapper.toCompetency(obj)) != null)
//		{
//			return 1;
//		} 
//		return 0;
//	}
//	
//	public int delete(CompetencyDTO obj) {
//		
//		obj.setActivate(false);
//		if(competencyRepository.save(CompetencyMapper.toCompetency(obj)) != null)
//		{
//			return 1;
//		} 
//		return 0;
//	}
	

}
