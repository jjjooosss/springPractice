package com.lgy.spring_ex3_1;

public class MyCircle {
	private Circle circle;
	private int myRadius;
	
	public void ar() {
		circle.area(myRadius);
	}
	
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public int getMyRadius() {
		return myRadius;
	}
	public void setMyRadius(int myRadius) {
		this.myRadius = myRadius;
	}
	
}
