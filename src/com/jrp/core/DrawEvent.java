package com.jrp.core;

import org.springframework.context.ApplicationEvent;

/**
 * @author jyoti_000
 * 
 * customized Event
 */
public class DrawEvent extends ApplicationEvent {

	public DrawEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "-----Draw Event Occured";
	}

}
