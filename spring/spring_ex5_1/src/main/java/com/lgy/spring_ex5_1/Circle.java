package com.lgy.spring_ex5_1;

public class Circle {
	private int radius;
	
	public double process() {
		 return radius*radius*3.14;
	}
	public Circle(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
}
