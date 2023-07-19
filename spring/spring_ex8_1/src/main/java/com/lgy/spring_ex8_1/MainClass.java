package com.lgy.spring_ex8_1;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableApplicationContext 인터페이스를 이용해서 Environment 객체 생성
		ConfigurableEnvironment env = ctx.getEnvironment();
//		getPropertySources() 를 이용해서 프로퍼티 소스 객체 생성
		MutablePropertySources propertySources = env.getPropertySources();
		
		try {
//			ResourcePropertySource 객체를 이용해서 외부파일 정보를 가져와서 프로퍼티 소스에 추가
			propertySources.addLast(new ResourcePropertySource("classpath:oracle.account"));
		
			System.out.println(env.getProperty("emp.id"));
			System.out.println(env.getProperty("emp.pw"));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		다운캐스팅
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext) ctx;
		
		gCtx.load("applicationCTX.xml");
//		객체 생성 전과 객체 생성시 해당되는 메소드 호출 => 프로퍼티 값을 저장
//		private Environment env;//객체 생성전에 environment 객체를 받아서 저장
		gCtx.refresh();
		
		
		EmpConnection empConnection = gCtx.getBean("empConnection",EmpConnection.class);
		System.out.println("emp ID : "+empConnection.getEmpId()); 
		System.out.println("emp PW : "+empConnection.getEmpPw());
		
	}
}
