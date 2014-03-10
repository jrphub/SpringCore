package com.jrp.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class DrawingAppl {

	/**
	 * @param args
	 * Using BeanFactory, since spring 3.1 , XmlBeanFactory is deprecated
	 */
	public static void main(String[] args) {
		
	//@SuppressWarnings("deprecation")
	BeanFactory factory = new XmlBeanFactory (new FileSystemResource ("src/Spring.xml"));
	//Triangle triangle = (Triangle) factory.getBean("triangle"); //with casting
	Triangle triangle = factory.getBean("triangle", Triangle.class); //without casting
	triangle.draw();
	}

}
