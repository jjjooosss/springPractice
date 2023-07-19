package com.lgy.spring_ex2_5;

public class MultipleTriangle {
	public static void main(String[] args) {
		Multiple multiple = new Multiple();
		multiple.setNum(240);
		multiple.process();
		
		Triangle triangle = new Triangle();
		triangle.setX(4);
		triangle.setY(3);
		triangle.setZ(5);
		triangle.process();
	}
}
