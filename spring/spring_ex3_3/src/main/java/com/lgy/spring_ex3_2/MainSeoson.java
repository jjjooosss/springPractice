package com.lgy.spring_ex3_2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainSeoson {
	public static void main(String[] args) {
		String configLoc = "classpath:seosonCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MySeoson mySeoson = ctx.getBean("mySeoson",MySeoson.class);
		
		mySeoson.result();
	}
}
