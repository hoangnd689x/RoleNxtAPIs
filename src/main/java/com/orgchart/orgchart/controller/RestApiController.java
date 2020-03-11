package com.orgchart.orgchart.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orgchart.orgchart.model.Department;
import com.orgchart.orgchart.model.Position;
import com.orgchart.orgchart.model.PositionDetails;
import com.orgchart.orgchart.model.Structure;
import com.orgchart.orgchart.serviceImpl.DepartmentServiceImpl;
import com.orgchart.orgchart.serviceImpl.PositionDetailServiceImpl;
import com.orgchart.orgchart.serviceImpl.PositionServiceImpl;
import com.orgchart.orgchart.serviceImpl.StructureServiceImpl;

/**
 * @author YOG1HC
 *
 */
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RestApiController {

	public static Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	PositionServiceImpl positionService = new PositionServiceImpl();
	
	StructureServiceImpl structureService = new StructureServiceImpl();
	
	DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
	
	PositionDetailServiceImpl poDService = new PositionDetailServiceImpl();
	
	
	/**
	 * get all positions in an organization
	 *
	 */
	@RequestMapping(value = "/getAllPositions/", method = RequestMethod.GET)
	public ResponseEntity<List<Position>> getAllPositions(){
		
		List<Position> listPosition = new ArrayList();
		listPosition = positionService.getAllPositions();
		
		return new ResponseEntity<List<Position>>(listPosition, HttpStatus.OK);
	}
	
	/**
	 * get all structures in an organization
	 *
	 */
	@RequestMapping(value = "/getAllStructures/", method = RequestMethod.GET)
	public ResponseEntity<List<Structure>> getAllStructures(){
		
		List<Structure> listStructure = new ArrayList();
		listStructure = structureService.getAllStructures();
		
		return new ResponseEntity<List<Structure>>(listStructure, HttpStatus.OK);
	}
	
	/**
	 * get all Departments in an organization
	 *
	 */
	@RequestMapping(value = "/getAllDepartments/", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> getAllDepartments(){
		
		List<Department> listDepartment = new ArrayList();
		listDepartment = departmentService.getAllDepartments();
		
		return new ResponseEntity<List<Department>>(listDepartment, HttpStatus.OK);
	}
	
	/**
	 * get all Departments in an organization
	 *
	 */
	@RequestMapping(value = "/getAllPositionDetails/", method = RequestMethod.GET)
	public ResponseEntity<List<PositionDetails>> getAllPositionDetails(){
		
		List<PositionDetails> listDepartment = new ArrayList();
		listDepartment = poDService.getAllPositionDetails();
		
		return new ResponseEntity<List<PositionDetails>>(listDepartment, HttpStatus.OK);
	}
	
}
