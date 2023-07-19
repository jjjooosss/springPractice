package com.lgy.spring_ex8_4;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class JdbcDriver implements EnvironmentAware, InitializingBean {
	
	private Environment env;
	private String oracleJdbcDriver;
	private String mydqlJdbcDriver;
	
	@Override
	public void setEnvironment(Environment environment) {
		setEnv(environment);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		setOracleJdbcDriver(env.getProperty("oracle"));
		setMydqlJdbcDriver(env.getProperty("mysql"));
	}
	public Environment getEnv() {
		return env;
	}
	public void setEnv(Environment env) {
		this.env = env;
	}
	public String getOracleJdbcDriver() {
		return oracleJdbcDriver;
	}
	public void setOracleJdbcDriver(String oracleJdbcDriver) {
		this.oracleJdbcDriver = oracleJdbcDriver;
	}
	public String getMydqlJdbcDriver() {
		return mydqlJdbcDriver;
	}
	public void setMydqlJdbcDriver(String mydqlJdbcDriver) {
		this.mydqlJdbcDriver = mydqlJdbcDriver;
	}
	

}
