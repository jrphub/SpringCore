package com.jrp.core;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author jyoti_000
 * 
 *         This class is made to illustrate bean definition inheritance. Also it
 *         illustrates how to do some task after init() of bean and before
 *         destroy() of bean
 *         
 *         we have implemented the concept in 2 ways
 *         1. using interfaces
 *         2. using custom methods and init-method, destroy-method attribute in xml file
 *         
 *         Also we have shown the order of exceution when both the ways are implemented
 *         
 *         illustration of Customized Event also
 * 
 */
public class Circle implements InitializingBean, DisposableBean, ApplicationEventPublisherAware{
	private Point pointA;
	private Point pointB;
	
	//event related
	private ApplicationEventPublisher appEventPublisher;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	@Required
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public void showRadius() {
		System.out.println("The radius is :"
				+ (getPointB().getY() - getPointA().getY()));
		
		//To show the event
		DrawEvent drawEvent = new DrawEvent(this);
		appEventPublisher.publishEvent(drawEvent);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init() is called");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Called before destroy() of bean");
	}
	
	public void myInit() {
		System.out.println("My init() is called");
	}
	
	public void myCleanUp() {
		System.out.println("My cleanUp() is called");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
			this.appEventPublisher = publisher;
	}
}
