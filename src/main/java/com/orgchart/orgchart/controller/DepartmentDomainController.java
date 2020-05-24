package com.orgchart.orgchart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orgchart.orgchart.DTO.DepartmentDomainDTO;
import com.orgchart.orgchart.Mapper.DepartmentDomainMapper;
import com.orgchart.orgchart.service.DepartmentDomainService;

/**
 * @author NNA7HC
 *
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "api/department-domain")
public class DepartmentDomainController {
	@Autowired
	DepartmentDomainService departmentDomainService;
	
	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@ResponseBody
	public List<DepartmentDomainDTO> getAllDepartment(){
		return DepartmentDomainMapper.toDepartmentDomainDTOList(this.departmentDomainService.getAll());
	}
	
	@RequestMapping(value = "/get-by-id/{id}", method = RequestMethod.GET)
	@ResponseBody
	public DepartmentDomainDTO getById(@PathVariable(required = false) int id){
		return this.departmentDomainService.findById(id);
	}
	
	@RequestMapping(value = "/get-by-position/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<DepartmentDomainDTO> getByPositionId(@PathVariable(required = false) int id){
		return DepartmentDomainMapper.toDepartmentDomainDTOList(this.departmentDomainService.getbyPositionId(id));
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> addDepartmentDomain(@RequestBody DepartmentDomainDTO item) {
		return new ResponseEntity<Integer>(departmentDomainService.add(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> updateDepartmentDomain(@RequestBody DepartmentDomainDTO item) {
		return new ResponseEntity<Integer>(departmentDomainService.update(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> deleteDepartmentDomain(@RequestBody DepartmentDomainDTO item) {
		return new ResponseEntity<Integer>(departmentDomainService.delete(item), HttpStatus.OK);
	}
}
