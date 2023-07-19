package com.lgy.spring_ex3_2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWon2dollar {
	public static void main(String[] args) {
		String configLoc = "classpath:won2dollarCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyWon2dollar myWon2dollar = ctx.getBean("myWon2dollar",MyWon2dollar.class);
		
		myWon2dollar.exch();
	}
}
