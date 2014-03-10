package com.jrp.core;

import java.util.List;

public class RectangleAsList {
	private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void show() {
		System.out.println("Forming rectangle using List of points");
		for (Point point : points) {
			System.out.println("point : (" + point.getX() +", " + point.getY() + ")");
		}
	}
}
