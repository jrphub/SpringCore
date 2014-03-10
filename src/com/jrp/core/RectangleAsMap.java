package com.jrp.core;

import java.util.Map;
import java.util.Map.Entry;

public class RectangleAsMap {
	private Map<String, Point> points;

	public Map<String, Point> getPoints() {
		return points;
	}

	public void setPoints(Map<String, Point> points) {
		this.points = points;
	}
	
	public void show() {
		for (Entry<String, Point> point : points.entrySet()) {
			System.out.println(point.getKey()+" : ("+ point.getValue().getX() +", "+point.getValue().getY() + ")");
		}
	}
}
