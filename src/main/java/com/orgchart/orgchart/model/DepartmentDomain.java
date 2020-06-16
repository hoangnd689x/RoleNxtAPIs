package com.orgchart.orgchart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	@JoinColumn(name = "POSITION_ID")
	private Position positionObj;
	
	@Column(name = "DEPARTMENTDOMAIN_NAME")
	private String name;
	
	@Lob
	@Column(name = "COMPETENCIES")
	private String competencies;
	
	@Lob
	@Column(name = "RESPONSIBILITIES")
	private String responsibilities;

	@Lob
	@Column(name = "ENTRY_CRIDENTIA")
	private String entryCriteria;
	
	@Lob
	@Column(name = "KRA")
	private String KRA;
	
	@Lob
	@Column(name = "INDUSTRIAL_ROLE")
	private String industrialRole;
	
	@Column(name = "ACTIVATE")
	private boolean activate;

	public DepartmentDomain() {
		super();
	}

	public DepartmentDomain(int id, Position positionObj, String name, String competencies, String responsibilities,
			String entryCriteria, String kRA, String industrialRole, boolean activate) {
		super();
		this.id = id;
		this.positionObj = positionObj;
		this.name = name;
		this.competencies = competencies;
		this.responsibilities = responsibilities;
		this.entryCriteria = entryCriteria;
		KRA = kRA;
		this.industrialRole = industrialRole;
		this.activate = activate;
	}

	public String getKRA() {
		return KRA;
	}

	public void setKRA(String kRA) {
		KRA = kRA;
	}

	public String getIndustrialRole() {
		return industrialRole;
	}

	public void setIndustrialRole(String industrialRole) {
		this.industrialRole = industrialRole;
	}

	public String getCompetencies() {
		return competencies;
	}

	public void setCompetencies(String competencies) {
		this.competencies = competencies;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getEntryCriteria() {
		return entryCriteria;
	}

	public void setEntryCriteria(String entryCriteria) {
		this.entryCriteria = entryCriteria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Position getPositionObj() {
		return positionObj;
	}

	public void setPositionObj(Position positionObj) {
		this.positionObj = positionObj;
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
