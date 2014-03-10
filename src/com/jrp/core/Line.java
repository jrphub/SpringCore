package com.jrp.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author jyoti_000
 * 
 *         ApplicationContextAware is used to get the ApplicationCntext object
 *         created before for the application, The interface has one method
 *         setApplicationContext(ApplicationContext arg0) which needs to be
 *         defined
 * 
 *         BeanNameAware interface is used to get the bean name in the xml file
 *         for the class. it has one method setBeanName(String arg0)
 */
public class Line implements ApplicationContextAware, BeanNameAware, ShapeInterface {
	// A line has two points
	private Point pointA;
	private Point pointB;

	private ApplicationContext context = null;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public void show() {
		System.out.println("PointA : (" + getPointA().getX() + ", "
				+ getPointA().getY() + ")");
		System.out.println("PointB : (" + getPointB().getX() + ", "
				+ getPointB().getY() + ")");
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.setContext(context);
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println(beanName);
	}
	
	//optional
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public void draw() {
		System.out.println("A line is drawn");
		
	}

}
