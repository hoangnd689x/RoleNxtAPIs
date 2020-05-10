package com.orgchart.orgchart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author NNA7HC
 *
 */
@Entity
@Table(name = "CAREERPATH")
public class CareerPath {
	
	@Id
	@Column(name = "CP_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CP_NAME")
	private String name;
	
	@Column(name = "CP_COLOR")
	private String color;
	
	@Column(name = "ACTIVATE")
	private boolean activate;
	
	public CareerPath(int id, String name, String color, boolean activate) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.activate = activate;
	}
	public CareerPath() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean getActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
}
