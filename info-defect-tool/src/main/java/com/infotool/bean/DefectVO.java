package com.infotool.bean;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "All details about the Employee. ")
public class DefectVO {
	private int id;
    private String name;
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
    
    
}
