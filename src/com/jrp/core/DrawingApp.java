package com.jrp.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	private static AbstractApplicationContext context;

	/**
	 * @param args
	 * 
	 *            Using ApplicationContext
	 */
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		/* illustration of DI using setter and constructor */
		Triangle triangle1 = (Triangle) context.getBean("triangle"); // with
																		// Cast
		triangle1.draw();

		/*
		 * Triangle triangle2 = context.getBean("triangle",
		 * Triangle.class);//without cast triangle2.draw();
		 */

		/* illustration of injecting objects, inner bean, alias */
		Line line = (Line) context.getBean("line");
		line.show();

		/* illustration of injecting List of objects */
		RectangleAsList rectangle = (RectangleAsList) context
				.getBean("rectangle");
		rectangle.show();

		// set is also similar like list

		/* illustration of injecting map object */
		RectangleAsMap rectangleMap = (RectangleAsMap) context
				.getBean("rectangleAsMap");
		rectangleMap.show();

		/* illustration of Autowiring */
		LineAutowire lineAuto = (LineAutowire) context.getBean("lineAutowire");
		lineAuto.show();

		/* illustration of bean scope i.e singleton (default) and prototype */
		System.out.println(lineAuto);// 1
		LineAutowire lineAuto1 = (LineAutowire) context.getBean("lineAutowire");
		System.out.println(lineAuto1);// 2
		// When scope is prototype, 1 & 2 gives two different results, otherwise
		// same object i.e singleton by default
		
		/*illustration of bean definition inheritance, ways of initializing and destroying method*/
		Circle circle = (Circle) context.getBean("circle");
		circle.showRadius();
		
		
		/*illustration of "code to interface"*/
		//ShapeInterface shape = (ShapeInterface) context.getBean("line");
		ShapeInterface shape = (ShapeInterface) context.getBean("triangle");
		shape.draw();

	}
}
