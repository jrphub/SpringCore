package com.jrp.core;

public class Triangle implements ShapeInterface{
	private String type;

	// getter setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private int height;
	private String sidesType;

	// Constructor1
	public Triangle(int height) {
		this.height = height;
	}

	// constructor 2
	public Triangle(String sidesType) {
		this.sidesType = sidesType;
	}

	// constructor3
	public Triangle(int height, String sidesType) {
		this.height = height;
		this.sidesType = sidesType;
	}

	public int getHeight() {
		return height;
	}

	public String getSidesType() {
		return sidesType;
	}

	@Override
	public void draw() {
		System.out.println("A " + getType() + " Triangle drawn having height "
				+ getHeight() + " and the sides of triangle are "
				+ getSidesType());
	}
}
