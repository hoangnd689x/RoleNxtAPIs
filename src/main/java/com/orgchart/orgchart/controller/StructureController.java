package com.orgchart.orgchart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orgchart.orgchart.model.Structure;
import com.orgchart.orgchart.serviceImpl.StructureServiceImpl;

@Controller
public class StructureController {
	StructureServiceImpl structureService = new StructureServiceImpl();
	
	@GetMapping("/{department-name}/structure")
    public String getPositionDetails(@PathVariable("department-name") String departmentName, Model model) {
		List<Structure> listStructure = new ArrayList();
		List<Structure> listStructureByDepartmentName = new ArrayList();
		listStructure = structureService.getAllStructures();
		listStructureByDepartmentName=listStructure
				.stream()
				  .filter(d -> d.getDepartmentName().equalsIgnoreCase(departmentName))
				  .collect(Collectors.toList());
		model.addAttribute("items",listStructureByDepartmentName);
		return "structure";
    }
}
