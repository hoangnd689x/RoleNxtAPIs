package com.orgchart.orgchart.model;

import java.util.List;

public class Cluster {
	
	private long id;
	private String label;
	private List<Position> chideNodes;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<Position> getChideNodes() {
		return chideNodes;
	}
	public void setChideNodes(List<Position> chideNodes) {
		this.chideNodes = chideNodes;
	}
	
	

}
