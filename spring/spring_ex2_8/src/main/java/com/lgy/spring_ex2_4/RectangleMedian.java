package com.lgy.spring_ex2_4;

public class RectangleMedian {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		rectangle.setX(150);
		rectangle.setY(150);
		rectangle.process();
		
		Median median = new Median();
		median.setX(20);
		median.setY(100);
		median.setZ(33);
		median.process();
		
	}
}
