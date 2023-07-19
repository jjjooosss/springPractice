package com.lgy.spring_ex8_1;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EmpConnection implements EnvironmentAware, InitializingBean {
	// Environment : 환경 객체로 시스템 설정 값을 저장
	private Environment env;//객체 생성전에 environment 객체를 받아서 저장
	private String empId;
	private String empPw;
	
//	객체 생성 전 호출(1번)
	@Override
	public void setEnvironment(Environment environment) {
//		환경 객체를 env 객체에 저장
		setEnv(environment);
	}
	
//	객체 생성 후 호출(2번)
	@Override
	public void afterPropertiesSet() throws Exception {
//		프로퍼티 소스에서 emp.id 가져와 여기 변수에 저장
		setEmpId(env.getProperty("emp.id"));
		setEmpPw(env.getProperty("emp.pw"));
	}


	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPw() {
		return empPw;
	}

	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	
}
