package com.lgy.spring_3_2;

public class MyCalculator {
	private Calculater calculater;
	private int firstNum;
	private int secondNum;
	
	public void add() {
		calculater.addtion(firstNum, secondNum);
	}
	public void sub() {
		calculater.subtraction(firstNum, secondNum);
	}
	public void mul() {
		calculater.multiplication(firstNum, secondNum);
	}
	public void div() {
		calculater.division(firstNum, secondNum);
	}
	
	public Calculater getCalculater() {
		return calculater;
	}
	public void setCalculater(Calculater calculater) {
		this.calculater = calculater;
	}
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	
}
