package com.ceostocks.common.advice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainImpl {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring_common_test.xml");
		CustomerBo customerBo = context.getBean("customerBo", CustomerBo.class);
		customerBo.addCustomer();
		
		customerBo.addCustomerAround("Arun");
	}
}
