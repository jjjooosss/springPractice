package com.lgy.spring_ex9_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Professor professor = ctx.getBean("professor",Professor.class);
//		학생정보 출력(핵심기능 - 메소드)
		professor.getProfessorInfo();
		
		Singer singer = ctx.getBean("singer",Singer.class);
//		노동자 정보 출력(핵심기능 - 메소드)
		singer.getSingerInfo();

		
	}
}
