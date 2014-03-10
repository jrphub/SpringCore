package com.jrp.core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;


/**
 * @author jyoti_000
 * 
 *         illustration of Stereotype Annotation (@Component, @Service,
 *         @Repository, @Controller), JSR-250 Annotation (@Resource,
 *         @PostConstruct, @PreDestroy),
 */

@Component
//@Service
//@Repository
//@Controller
public class LineAutowire {
	private Point pointA;
	private Point pointY;
	@Autowired
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getPointA() {
		return pointA;
	}

	// A JSR-250 Annotation , used like @Autowire byName, if we remove
	// (name="pointA"), then also it will search for beans called "pointA" and
	// inject
	@Resource(name = "pointA")
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointY() {
		return pointY;
	}

	@Autowired
	@Qualifier("ForPointY")
	public void setPointY(Point pointY) {
		this.pointY = pointY;
	}

	public void show() {
		System.out.println("pointA : (" + getPointA().getX() + ", "
				+ getPointA().getY() + ")");
		
		//usage of MessageSource Interface to retrieve messages out of property file
		System.out.println("By using MessageSource Interface: "+this.messageSource.getMessage("pointB", new Object[] {getPointY().getX(), getPointY().getY()}, "default pointB ", null));
		
		
		System.out.println(this.messageSource.getMessage("greeting", null, "default greeting", null));
	}

	@PostConstruct
	public void afterInitializeCircle() {
		System.out.println("JSR-250 implementation : after initialization");
	}

	@PreDestroy
	public void beforeDestroyCircle() {
		System.out.println("JSR-250 implementation : before destruction");
	}
}
