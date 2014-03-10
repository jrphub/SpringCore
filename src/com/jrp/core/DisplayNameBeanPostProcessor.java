package com.jrp.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author jyoti_000
 * 
 *         This class is used for doing task before and after the initialization
 *         of bean, Besides implementing BeanPostProcessor, just we have to let
 *         Spring know about this bean by mentioning in xml file
 */
public class DisplayNameBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("After initialization of :" + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("Before initialization of :" + beanName);
		return bean;
	}

}
