package com.lgy.spring_ex6_2;

import java.util.ArrayList;

public class Professor {
	private String name;
	private int age;
	private ArrayList<String> subjects;
	
	
	
	public Professor(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(ArrayList<String> subjects) {
		this.subjects = subjects;
	}
	
	
}
