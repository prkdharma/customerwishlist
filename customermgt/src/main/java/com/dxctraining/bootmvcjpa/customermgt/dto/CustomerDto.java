package com.dxctraining.bootmvcjpa.customermgt.dto;

public class CustomerDto {

	private int id;
	private String name;

	public CustomerDto(int id, String name) {
		this.id = id;
		this.name = name;

	}

	public CustomerDto() {

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

}