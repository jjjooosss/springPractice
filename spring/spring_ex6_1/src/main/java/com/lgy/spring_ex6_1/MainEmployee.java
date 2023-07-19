package com.lgy.spring_ex6_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEmployee {
	public static void main(String[] args) {
		String configLoc1 = "classpath:employeeCTX.xml";
		String configLoc2 = "classpath:employeeCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc1);
		Employee employee1 = ctx.getBean("employee1", Employee.class);
		System.out.println(employee1.getName());
		System.out.println(employee1.getSal());
		System.out.println(employee1.getCeltificates());
		System.out.println("=============================");
		
		EmployeeInfo employeeInfo = ctx.getBean("employeeInfo1",EmployeeInfo.class);
		Employee employee2 = employeeInfo.getEmployee();
		System.out.println(employee2.getName());
		System.out.println(employee2.getSal());
		System.out.println(employee2.getCeltificates());
		System.out.println("=============================");
		
		AbstractApplicationContext ctx2 = new GenericXmlApplicationContext(configLoc2);
		Employee employee3 = ctx2.getBean("employee3", Employee.class);
		System.out.println(employee3.getName());
		System.out.println(employee3.getSal());
		System.out.println(employee3.getCeltificates());
		System.out.println("=============================");
		
	}
}
