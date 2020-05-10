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

import com.orgchart.orgchart.DTO.RoleDTO;
import com.orgchart.orgchart.Mapper.RoleMapper;
import com.orgchart.orgchart.service.RoleService;

/**
 * @author NNA7HC
 *
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "api/role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@ResponseBody
	public List<RoleDTO> getAll(){
		return RoleMapper.toRoleDTOList(this.roleService.getAll());
	}
	
	@RequestMapping(value = "/get-by-id/{id}", method = RequestMethod.GET)
	@ResponseBody
	public RoleDTO getById(@PathVariable(required = false) int id){
		return this.roleService.findById(id);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> add(@RequestBody RoleDTO item) {
		return new ResponseEntity<Integer>(roleService.add(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> update(@RequestBody RoleDTO item) {
		return new ResponseEntity<Integer>(roleService.update(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> delete(@RequestBody RoleDTO item) {
		return new ResponseEntity<Integer>(roleService.delete(item), HttpStatus.OK);
	}
}
