package com.lgy.spring_3_1;

public class MainClass {
	public static void main(String[] args) {
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setCalculater(new Calculater());
		myCalculator.setFirstNum(10);
		myCalculator.setSecondNum(2);
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
	}
}
