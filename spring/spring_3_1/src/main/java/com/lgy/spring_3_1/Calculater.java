package com.lgy.spring_3_1;

public class Calculater {
	public void addtion(int f, int s) {
		System.out.println("addtion()");
		int result=f+s;
		System.out.println(f+"+"+s+"="+result);
	}
	public void subtraction(int f, int s) {
		System.out.println("subtraction()");
		int result=f-s;
		System.out.println(f+"-"+s+"="+result);
	}
	public void multiplication(int f, int s) {
		System.out.println("multiplication()");
		int result=f*s;
		System.out.println(f+"*"+s+"="+result);
	}
	public void division(int f, int s) {
		System.out.println("division()");
		int result=f/s;
		System.out.println(f+"/"+s+"="+result);
	}
}
