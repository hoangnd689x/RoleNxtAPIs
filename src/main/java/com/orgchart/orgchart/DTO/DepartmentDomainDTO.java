package com.orgchart.orgchart.DTO;

/**
 * @author NNA7HC
 *
 */

public class DepartmentDomainDTO {
	private int id;
	private OrganizationDTO orgObj;
	private String name;
	private boolean activate;
	
	public DepartmentDomainDTO() {
		super();
	}
	
	public DepartmentDomainDTO(int id, OrganizationDTO orgObj, String name, boolean activate) {
		super();
		this.id = id;
		this.orgObj = orgObj;
		this.name = name;
		this.activate = activate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OrganizationDTO getOrgObj() {
		return orgObj;
	}
	public void setOrgObj(OrganizationDTO orgObj) {
		this.orgObj = orgObj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	
	
}
