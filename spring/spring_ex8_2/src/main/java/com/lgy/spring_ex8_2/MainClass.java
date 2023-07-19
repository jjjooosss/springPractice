package com.lgy.spring_ex8_2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		xml파일에 프로퍼티파일을 명시해놨으므로 xml파일을 연결해야만 프로퍼티 값을 들고 올 수 있다!
//		"applicationCTX.xml" 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationCTX.xml");
		DbConnection dbConnection = ctx.getBean("dbConnection",DbConnection.class);
		System.out.println("mssqlID : "+dbConnection.getMssqlId()); 
		System.out.println("mssqlPW : "+dbConnection.getMssqlPw()); 
		System.out.println("mysqlID : "+dbConnection.getMysqlId()); 
		System.out.println("mysqlPW : "+dbConnection.getMysqlPw()); 
	}
}
