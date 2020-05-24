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
@Table(name = "ROLES")
public class Role {

	@Id
	@Column(name = "ROLE_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "POSITION_ID")
	private Position positionObj;

//	@ManyToOne
//	@JoinColumn(name = "CP_ID")
//	private CareerPath careerPath;

	@Column(name = "COMPETENICES")
	private String competencies;

	@Lob
	@Column(name = "DOMAIN_ROLES")
	private String domainRole;

	@Lob
	@Column(name = "PROJECT_CATEGORY")
	private String category;

	@Lob
	@Column(name = "KRA")
	private String KRA;

	@Lob
	@Column(name = "SCOPE")
	private String scope;

	@Lob
	@Column(name = "RESPONSIBILITIES")
	private String responsibilities;

	@Lob
	@Column(name = "INDUSTRIAL_ROLE")
	private String industrialRole;

	@Lob
	@Column(name = "ENTRY_CRIDENTIA")
	private String entryCriteria;

	@Column(name = "ACTIVATE")
	private boolean activate;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, Position positionObj, String competencies,
			String domainRole, String category, String kRA, String scope, String responsibilities,
			String industrialRole, String entryCriteria, boolean activate) {
		super();
		this.id = id;
		this.positionObj = positionObj;
		//this.deptDomain = deptDomain;
		this.competencies = competencies;
		this.domainRole = domainRole;
		this.category = category;
		KRA = kRA;
		this.scope = scope;
		this.responsibilities = responsibilities;
		this.industrialRole = industrialRole;
		this.entryCriteria = entryCriteria;
		this.activate = activate;
	}

	public String getCompetencies() {
		return competencies;
	}

	public void setCompetencies(String competencies) {
		this.competencies = competencies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public CareerPath getCareerPath() {
//		return careerPath;
//	}
//
//	public void setCareerPath(CareerPath careerPath) {
//		this.careerPath = careerPath;
//	}

	public Position getPositionObj() {
		return positionObj;
	}

	public void setPositionObj(Position positionObj) {
		this.positionObj = positionObj;
	}

	public String getDomainRole() {
		return domainRole;
	}

	public void setDomainRole(String domainRole) {
		this.domainRole = domainRole;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKRA() {
		return KRA;
	}

	public void setKRA(String kRA) {
		KRA = kRA;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getIndustrialRole() {
		return industrialRole;
	}

	public void setIndustrialRole(String industrialRole) {
		this.industrialRole = industrialRole;
	}

	public String getEntryCriteria() {
		return entryCriteria;
	}

	public void setEntryCriteria(String entryCriteria) {
		this.entryCriteria = entryCriteria;
	}

	public boolean getActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

}
