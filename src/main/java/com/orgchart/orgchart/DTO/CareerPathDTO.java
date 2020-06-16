package com.orgchart.orgchart.DTO;

/**
 * @author NNA7HC
 *
 */
public class CareerPathDTO {
	
	private int id;
	
	private String name;
	
	private String color;
	
	private boolean activate;
	
	public CareerPathDTO(int id, String name, String color, boolean activate) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.activate = activate;
	}
	public CareerPathDTO() {
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
