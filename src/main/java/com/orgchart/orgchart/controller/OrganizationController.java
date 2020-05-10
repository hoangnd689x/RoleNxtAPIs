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

import com.orgchart.orgchart.DTO.OrganizationDTO;
import com.orgchart.orgchart.Mapper.OrganizationMapper;
import com.orgchart.orgchart.service.OrganizationService;

/**
 * @author NNA7HC
 *
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "api/org")
public class OrganizationController {

	@Autowired
	OrganizationService orgService;
	
	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@ResponseBody
	public List<OrganizationDTO> getAll(){
		return OrganizationMapper.toOrganizationDTOList(this.orgService.getAll());
	}
	
	@RequestMapping(value = "/get-by-domain/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<OrganizationDTO> getByDomainId(@PathVariable(required = false) int id){
		return OrganizationMapper.toOrganizationDTOList(this.orgService.getByDomain(id));
	}
	
	@RequestMapping(value = "/get-by-id/{id}", method = RequestMethod.GET)
	@ResponseBody
	public OrganizationDTO getById(@PathVariable(required = false) int id){
		return this.orgService.findById(id);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> add(@RequestBody OrganizationDTO item) {
		return new ResponseEntity<Integer>(orgService.add(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> update(@RequestBody OrganizationDTO item) {
		return new ResponseEntity<Integer>(orgService.update(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> delete(@RequestBody OrganizationDTO item) {
		return new ResponseEntity<Integer>(orgService.delete(item), HttpStatus.OK);
	}
}
