package com.orgchart.orgchart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author NNA7HC
 *
 */

@Entity
@Table(name = "DEPARTMENTDOMAIN")
public class DepartmentDomain {

	@Id
	@Column(name = "DEPARTMENTDOMAIN_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ORG_ID")
	private Organization orgObj;
	
	@Column(name = "DEPARTMENTDOMAIN_NAME")
	private String name;
	
	@Column(name = "ACTIVATE")
	private boolean activate;

	public DepartmentDomain() {
		super();
	}

	public DepartmentDomain(int id, Organization orgObj, String name, boolean activate) {
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

	public Organization getOrgObj() {
		return orgObj;
	}

	public void setOrgObj(Organization orgObj) {
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
