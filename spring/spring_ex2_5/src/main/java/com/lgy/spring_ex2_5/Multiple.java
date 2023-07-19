package com.lgy.spring_ex2_5;

public class Multiple {
	private int num;
	public void process() {
		boolean multiple =false;
		if (num %3 == 0) {
			System.out.println("3의 배수이다");
			multiple = true;
		}
		if (num %5 == 0) {
			System.out.println("5의 배수이다");
			multiple = true;
		}
		if (num %8 == 0) {
			System.out.println("8의 배수이다");
			multiple = true;
		}
		if (!multiple) {
			System.out.println("어느 배수도 아니다.");
		}
		
		
	}
//	public void process() {
//		int three = num%3;
//		int five = num%5;
//		int eight = num%8;		
//		
//		
//		if (three == 0 && five != 0 && eight != 0) {
//			System.out.println("3의 배수이다");
//		} else if (three == 0 && five == 0 && eight != 0) {
//			System.out.println("3의 배수이다");
//			System.out.println("5의 배수이다");
//		} else if (three == 0 && five == 0 && eight == 0) {
//			System.out.println("3의 배수이다");
//			System.out.println("5의 배수이다");
//			System.out.println("8의 배수이다");
//		}
//		else {
//			System.out.println("3,5,8의 배수가 아니다");
//		}
//		
//	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
	