package com.lgy.spring_ex2_1;

public class Circle {
	private int radius;
	
	public void area() {
		System.out.println("원의 면적은"+ (3.14*radius*radius));
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
}
