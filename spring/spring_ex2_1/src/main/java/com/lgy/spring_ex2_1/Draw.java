package com.lgy.spring_ex2_1;

public class Draw {
	public static void main(String[] args) {
//		Circle 클래스가 Draw 클래스에 의존 (dependency)
//		Cicle 클래스로 객체 생성해서 값을 주입(injection)
//		의존+주입(Dependency Injection) =DI
		Circle circle = new Circle();
		circle.setRadius(10);
		circle.area();
		
//		의존+주입(Dependency Injection) =DI
		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(20);
		rectangle.setHeight(30);
		rectangle.area();
	}
}
