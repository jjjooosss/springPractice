package com.lgy.spring_ex6_1;

import java.util.ArrayList;

public class Employee {
	private String name;
	private int sal;
	private ArrayList<String> celtificates;
	
	
	
	public Employee(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public ArrayList<String> getCeltificates() {
		return celtificates;
	}
	public void setCeltificates(ArrayList<String> Celtificates) {
		this.celtificates = Celtificates;
	}
	
	
}
