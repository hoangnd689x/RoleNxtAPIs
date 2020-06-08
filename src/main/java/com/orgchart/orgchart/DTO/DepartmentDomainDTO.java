package com.orgchart.orgchart.DTO;


/**
 * @author NNA7HC
 *
 */

public class DepartmentDomainDTO {
	private int id;
	// private OrganizationDTO orgObj;
	private PositionDTO positionObj;
	private String name;
	private String competencies;
	private String responsibilities;
	private String entryCriteria;
	private boolean activate;
	private String KRA;
	private String industrialRole;

	public DepartmentDomainDTO() {
		super();
	}

	public DepartmentDomainDTO(int id, PositionDTO positionObj, String name, String competencies,
			String responsibilities, String entryCriteria, boolean activate, String kRA, String industrialRole) {
		super();
		this.id = id;
		this.positionObj = positionObj;
		this.name = name;
		this.competencies = competencies;
		this.responsibilities = responsibilities;
		this.entryCriteria = entryCriteria;
		this.activate = activate;
		KRA = kRA;
		this.industrialRole = industrialRole;
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

	public PositionDTO getPositionObj() {
		return positionObj;
	}

	public void setPositionObj(PositionDTO positionObj) {
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
