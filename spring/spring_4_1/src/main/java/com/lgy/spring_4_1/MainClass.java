package com.lgy.spring_4_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLoc = "classpath:myInfoCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyInfo myInfo = ctx.getBean("myInfo",MyInfo.class);
//		이름~ 취미 ,bmi지수, 비만~저체중 출력
		myInfo.getInfo();
//		자원반납
		ctx.close();
	}
}
