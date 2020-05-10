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

import com.orgchart.orgchart.DTO.PositionDTO;
import com.orgchart.orgchart.Mapper.PositionMapper;
import com.orgchart.orgchart.service.PositionService;

/**
 * @author NNA7HC
 *
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "api/position")
public class PositionController {

	@Autowired
	PositionService positionService;
	
	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@ResponseBody
	public List<PositionDTO> getAll(){
		return PositionMapper.toPositionDTOList(this.positionService.getAll());
	}
	
	@RequestMapping(value = "/get-by-org/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<PositionDTO> getByOrgId(@PathVariable(required = false) int id){
		return PositionMapper.toPositionDTOList(this.positionService.getByOrg(id));
	}
	
	@RequestMapping(value = "/get-by-id/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PositionDTO getById(@PathVariable(required = false) int id){
		return this.positionService.findById(id);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> add(@RequestBody PositionDTO item) {
		return new ResponseEntity<Integer>(positionService.add(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> update(@RequestBody PositionDTO item) {
		return new ResponseEntity<Integer>(positionService.update(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> delete(@RequestBody PositionDTO item) {
		return new ResponseEntity<Integer>(positionService.delete(item), HttpStatus.OK);
	}
}
