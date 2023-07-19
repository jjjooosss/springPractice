package com.lgy.spring_7_2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX.xml");
//		<context:annotation-config></context:annotation-config> 추가하면
//		@PostConstruct, @PostConstruct 2개가동작됨
//		initMethod()
//		destroy()
		ctx.refresh();
//		@# afterPropertiesSet() : 1.빈 생성시 호출
//		INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@2957fcb0: startup date [Mon May 22 14:53:54 KST 2023]; root of context hierarchy
//		INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2d3fcdbd: defining beans [student,otherStudent]; root of factory hierarchy
//		@# destroy() : 4.소멸후  호출
		ctx.close();
		
//
//		Student student = ctx.getBean("student",Student.class);
//		System.out.println("이름 : "+student.getName());
//		System.out.println("나이 : "+student.getAge());
		
	}
}
